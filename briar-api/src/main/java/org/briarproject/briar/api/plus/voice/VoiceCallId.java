package org.briarproject.briar.api.plus.voice;

import org.briarproject.nullsafety.NotNullByDefault;

import java.util.UUID;

import javax.annotation.concurrent.Immutable;

@Immutable
@NotNullByDefault
public final class VoiceCallId {
	private final UUID value;

	public VoiceCallId() {
		this(UUID.randomUUID());
	}

	public VoiceCallId(UUID value) {
		this.value = value;
	}

	public UUID getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof VoiceCallId && value.equals(((VoiceCallId) o).value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
