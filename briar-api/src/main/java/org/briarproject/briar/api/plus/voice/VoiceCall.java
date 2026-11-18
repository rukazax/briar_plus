package org.briarproject.briar.api.plus.voice;

import org.briarproject.bramble.api.contact.ContactId;
import org.briarproject.nullsafety.NotNullByDefault;

import javax.annotation.concurrent.Immutable;

@Immutable
@NotNullByDefault
public final class VoiceCall {
	private final VoiceCallId id;
	private final ContactId contactId;
	private final VoiceCallState state;
	private final VoiceTransport transport;
	private final VoiceCodec codec;

	public VoiceCall(VoiceCallId id, ContactId contactId,
			VoiceCallState state, VoiceTransport transport, VoiceCodec codec) {
		this.id = id;
		this.contactId = contactId;
		this.state = state;
		this.transport = transport;
		this.codec = codec;
	}

	public VoiceCallId getId() { return id; }
	public ContactId getContactId() { return contactId; }
	public VoiceCallState getState() { return state; }
	public VoiceTransport getTransport() { return transport; }
	public VoiceCodec getCodec() { return codec; }
}
