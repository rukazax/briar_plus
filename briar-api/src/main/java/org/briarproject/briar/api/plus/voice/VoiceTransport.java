package org.briarproject.briar.api.plus.voice;

import org.briarproject.nullsafety.NotNullByDefault;

@NotNullByDefault
public enum VoiceTransport {
	BLUETOOTH,
	WIFI_DIRECT,
	TOR,
	RELAY,
	MESH
}
