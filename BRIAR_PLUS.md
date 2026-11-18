# briar+

briar+ is a derivative development project based on the Briar source tree.

## Licensing

The Briar source code and this derivative project remain subject to the
applicable GNU General Public License v3 / project licensing notices included
in this repository. The original `LICENSE.txt` is preserved unchanged.

## First development layer

The first briar+ layer introduces the voice-call API and the Android audio
capture/playback foundation. Realtime network transport, Opus encoding,
session negotiation and Mailbox signaling are separate layers and are not
collapsed into the audio engine.
