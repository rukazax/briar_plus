# Происхождение исходников и изменения

briar+ — модификация Briar. Изменения снимка `0.2.0-alpha.1` задокументированы при импорте 18 ноября 2026 года. Точные даты отдельных изменений в доступных архивах не подтверждены.

## Изменения форка

- В `briar-api` добавлены шесть Java-файлов с интерфейсами, моделями и состояниями звонка.
- В `briar-android` добавлен `VoiceEngine.java` для локальной записи и воспроизведения PCM. Изменены `build.gradle`, `src/main/AndroidManifest.xml` и `src/main/res/values/strings.xml`.
- Добавлена исходная записка `BRIAR_PLUS.md`.
- При переносе в Git добавлены этот документ, дорожная карта и индекс в корневом README. Оригинальный README перемещён в `docs/upstream/README.md`. Технический аудит перенесён без правок.

## Исходные материалы

| Материал | SHA-256 |
| --- | --- |
| `briar-master.zip`, базовое дерево исходников | `99c1f97145cbaf2cef0b9e14dc7f4eecd6f2d43cea17f0396ce2c178192fbe87` |
| `briar-plus-0.2.0-alpha.1.zip`, исходники с изменениями briar+ | `9d7735b84ff32c6435717f0208a8ef7b77342f120877bc0cde3459249ec583c6` |
| `BRIAR_PLUS_TECHNICAL_AUDIT.md`, исходный аудит | `4e8d9efdf6f52121b52a2644817cd9a8944717c9d1389dbe628b7af7287d29b9` |
| `briar-plus-audit-0.2.zip`, архив с тем же файлом аудита | `f8c1d842f9999f5a1e7312badbb38a654ada9d9549c226668d4e45abbfa070e0` |

В архиве исходников имеется объявление подмодуля Mailbox в `.gitmodules`. Полный код Mailbox и точная ревизия подмодуля в переданном снимке отсутствуют. Коммит upstream, соответствующий исходному архиву, не указан.

## Лицензирование

Исходный `LICENSE.txt` перенесён без изменений. В нём указана GNU GPL версии 3 или более поздней. На странице лицензии upstream в GitLab указана GPL v3 only. Для снимка действуют исходные уведомления о лицензиях, включая указания в отдельных компонентах. Шаблон MIT из начального коммита GitHub не применяется к исходникам Briar.

Источники: [Briar](https://code.briarproject.org/briar/briar), [LICENSE.txt upstream](https://code.briarproject.org/briar/briar/blob/master/LICENSE.txt), [GNU GPL v3](https://www.gnu.org/licenses/gpl-3.0.html).
