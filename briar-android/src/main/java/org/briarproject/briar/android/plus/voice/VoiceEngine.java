package org.briarproject.briar.android.plus.voice;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Local audio capture/playback foundation for briar+ voice calls.
 *
 * Network transport and Opus encoding are intentionally kept outside this
 * class. Audio frames will later be handed to the selected VoiceTransport.
 */
public final class VoiceEngine {

	private static final int SAMPLE_RATE = 48_000;
	private static final int CHANNEL_IN = AudioFormat.CHANNEL_IN_MONO;
	private static final int CHANNEL_OUT = AudioFormat.CHANNEL_OUT_MONO;
	private static final int ENCODING = AudioFormat.ENCODING_PCM_16BIT;

	private final AtomicBoolean running = new AtomicBoolean(false);
	private AudioRecord recorder;
	private AudioTrack player;
	private Thread captureThread;

	public synchronized void start() {
		if (running.get()) return;
		int minRecord = AudioRecord.getMinBufferSize(SAMPLE_RATE, CHANNEL_IN, ENCODING);
		int minPlay = AudioTrack.getMinBufferSize(SAMPLE_RATE, CHANNEL_OUT, ENCODING);
		if (minRecord <= 0 || minPlay <= 0) {
			throw new IllegalStateException("Audio subsystem is unavailable");
		}
		int bufferSize = Math.max(minRecord, minPlay) * 2;
		recorder = new AudioRecord(MediaRecorder.AudioSource.VOICE_COMMUNICATION,
				SAMPLE_RATE, CHANNEL_IN, ENCODING, bufferSize);
		player = new AudioTrack(AudioManager.STREAM_VOICE_CALL, SAMPLE_RATE,
				CHANNEL_OUT, ENCODING, bufferSize, AudioTrack.MODE_STREAM);
		running.set(true);
		recorder.startRecording();
		player.play();
		captureThread = new Thread(this::captureLoop, "briar+-voice-capture");
		captureThread.start();
	}

	private void captureLoop() {
		short[] buffer = new short[960]; // 20 ms at 48 kHz, ready for Opus framing
		while (running.get()) {
			int read = recorder.read(buffer, 0, buffer.length);
			if (read > 0) {
				// briar+ will encode/transmit these PCM frames with Opus here.
				// For now this is intentionally a local audio loopback foundation.
				player.write(buffer, 0, read);
			}
		}
	}

	public synchronized void stop() {
		if (!running.getAndSet(false)) return;
		if (recorder != null) {
			try { recorder.stop(); } catch (IllegalStateException ignored) { }
			recorder.release();
			recorder = null;
		}
		if (player != null) {
			try { player.stop(); } catch (IllegalStateException ignored) { }
			player.release();
			player = null;
		}
		captureThread = null;
	}
}
