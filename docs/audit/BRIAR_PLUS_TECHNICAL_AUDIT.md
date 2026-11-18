# briar+ — Technical audit 0.2 (2026-10-10)

## Verified locally

Source: uploaded `briar-plus-0.2.0-alpha.1.zip`.

- Briar `LICENSE.txt` states GPL v3 **or later** in its text. GitLab metadata may describe GPLv3 only; verify per-file licensing before distribution.
- `briar-api/.../plus/voice/` contains `VoiceCallManager`, `VoiceCall`, `VoiceCallId`, `VoiceCodec`, `VoiceTransport`, `VoiceCallState`.
- `briar-android/.../plus/voice/VoiceEngine.java` records and immediately plays PCM in a local loopback. It does not implement a network call.
- No Opus encoder, authenticated realtime channel, session handshake, signaling protocol, call UI, or working conferencing integration is present in this layer.
- The Android application ID remains `org.briarproject.briar.android`, despite the displayed name being changed. Fork distribution needs an independent ID and migration/security plan.
- `settings.gradle` only includes mailbox modules for integration tests; `briar-mailbox/` is a placeholder/submodule in this ZIP. The complete Mailbox source is not present.
- `VoiceEngine` needs permission handling, AudioRecord/AudioTrack initialized-state checks, lifecycle and concurrency tests; current direct loopback risks feedback and does not validate remote audio.
- APK build and automated tests were **not** performed in this audit.

## External-source license gate

- Briar main repository: GPLv3 family; Briar Mailbox: AGPLv3.
- Sideband: CC BY-NC-SA 4.0 with additional binary permission; do not incorporate its code into briar+ without a specific compatible grant and legal review.
- LXST: CC BY-NC-ND 4.0; not suitable for direct modified integration into GPL/AGPL code under current grant.
- Reticulum and LXMF licenses must be independently reviewed per component before any code reuse.
- Jami: inspect exact components, license headers, dependencies and JNI/Android build integration before code reuse. Architectural concepts can be studied without copying code.

## Architecture decision — conditional

Keep Briar messaging, identity, forums/blogs and sync as baseline. Define an independent `RealtimeCallTransport` boundary. Use existing authenticated identities for signaling but perform a separate, cryptographically authenticated call-session handshake. Mailbox can deliver invitations and missed-call notices, not realtime audio. Prioritize one-to-one calls on an available direct LAN path; only after measured success consider relays, Tor feasibility, Bluetooth and conferences. Never assert that an encrypted messenger's existing transport automatically supports low-latency audio.

## Next engineering acceptance gates

1. CI builds an APK from a pinned toolchain and passes existing tests.
2. Independent application ID, versioning and branding are reviewed; preserve original copyright and license notices.
3. A documented call threat model and message protocol exist, with replay resistance, authenticated peer identity, key separation and session teardown.
4. A deterministic fake-transport test establishes offer/answer, cancellation, timeout and concurrent-call handling.
5. Two physical Android devices complete an authenticated one-to-one call over Wi-Fi with measured latency, packet loss, battery use and reconnection behavior.
6. Only then implement group calls, optional relays, community invitations and biometrics.

## Sources

- https://code.briarproject.org/briar/briar/blob/master/LICENSE.txt
- https://code.briarproject.org/briar/briar-mailbox/-/blob/main/LICENSE
- https://github.com/markqvist/Sideband
- https://github.com/markqvist/LXST
- https://git.jami.net/
