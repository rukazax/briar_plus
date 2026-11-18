package org.briarproject.briar.api.plus.voice;

import org.briarproject.nullsafety.NotNullByDefault;

@NotNullByDefault
public enum VoiceCallState {
	IDLE,
	CALLING,
	RINGING,
	CONNECTING,
	CONNECTED,
	ON_HOLD,
	RECONNECTING,
	ENDED,
	FAILED
}
