# LastHopeLSPosedModule

Минимальный Android-проект (template) под пакет `com.laibandis.gaba`.
Содержит пример Activity, PhotoStore и HookEntry для LSPosed/Xposed.

## Структура
- app/src/main/java/com/laibandis/gaba — MainActivity, PhotoStore
- app/src/main/java/com/laibandis/gaba/xposed — HookEntry.java
- app/src/main/res — layout, xml, values
- .github/workflows/android-build.yml — GitHub Actions сборка

## Сборка в GH Actions
Пуш в main запустит workflow, который выполнит `./gradlew assembleDebug`.
