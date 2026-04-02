# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Capacitor plugin (`@skippay/capacitor-localization-settings`) that exposes per-app language preferences API on iOS and Android. Two methods: `getLanguage()` and `setLanguage()`.

## Architecture

- **TypeScript layer** (`src/`): Plugin registration via `registerPlugin`, type definitions, web fallback using `navigator.language`
- **iOS native** (`ios/Sources/LocalizationSettingsPlugin/`): Swift implementation using `Locale.preferredLanguages` and `UserDefaults("AppleLanguages")`
- **Android native** (`android/src/main/java/com/skippay/plugins/localization/settings/`): Java implementation using `AppCompatDelegate.setApplicationLocales()` (API 33+)
- **Example app** (`example/`): Vite-based test app

Plugin follows standard Capacitor plugin pattern: bridge class (extends CAPPlugin/Plugin) delegates to implementation class.

## Build & Development Commands

- `npm run build` — Clean, generate docs, compile TypeScript, bundle with Rollup
- `npm run verify` — Verify builds for all platforms (iOS, Android, web)
- `npm run verify:ios` — Build iOS with xcodebuild
- `npm run verify:android` — Build and test Android with Gradle
- `npm run lint` — Run ESLint + Prettier + SwiftLint checks
- `npm run fmt` — Auto-format all code (ESLint fix + Prettier write + SwiftLint fix)
- `npm run docgen` — Regenerate API docs in README.md from JSDoc in `src/definitions.ts`

## Platform Requirements

- Capacitor 8.x (peer dependency)
- iOS: deployment target 15.0
- Android: minSdk 24, targetSdk 36, compileSdk 36, Java 21
- TypeScript 5.x, Rollup 4.x (ESM config: `rollup.config.mjs`)
