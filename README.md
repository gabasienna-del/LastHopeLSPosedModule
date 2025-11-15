# LastHopeLSPosedModule

Минимальный Android-проект (GABA) + заготовка для LSPosed-модуля.

**Пакет:** `com.laibandis.gaba`

## Что внутри
- `app/src/main/AndroidManifest.xml`
- `app/src/main/java/com/laibandis/gaba/MainActivity.java`
- `app/src/main/res/layout/activity_main.xml`
- `app/src/main/res/values/colors.xml`, `themes.xml`, `strings.xml`
- `file_paths.xml` и иконки

## Сборка локально (Termux / Linux / Windows WSL)
```bash
cd LastHopeLSPosedModule
# если есть gradle wrapper
./gradlew assembleDebug --no-daemon
