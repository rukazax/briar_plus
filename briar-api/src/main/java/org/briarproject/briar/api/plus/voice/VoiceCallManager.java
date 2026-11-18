package org.briarproject.briar.api.plus.voice;

import org.briarproject.bramble.api.contact.ContactId;
import org.briarproject.nullsafety.NotNullByDefault;

@NotNullByDefault
public interface VoiceCallManager {
	VoiceCall startCall(ContactId contactId);
	void acceptCall(VoiceCallId callId);
	void endCall(VoiceCallId callId);
	VoiceCall getCall(VoiceCallId callId);
}
