# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

PromptCraft is a Kotlin Multiplatform Compose application targeting Desktop (JVM) and Web (WebAssembly) platforms. The project follows the standard KMP architecture with shared common code and platform-specific implementations.

### Architecture

**Multiplatform Structure:**
- `commonMain/` - Shared business logic and UI components using Compose Multiplatform
- `jvmMain/` - Desktop-specific implementations and entry points
- `wasmJsMain/` - Web-specific implementations and configurations

**Key Patterns:**
- `expect/actual` declarations for platform-specific implementations (see `Platform.kt`)
- Compose UI shared across all platforms using Material Design 3
- Single source of truth for UI components in `commonMain`

**Main Components:**
- `App.kt` - Root Compose application with Material 3 theming
- `Platform.kt` - Abstract platform interface with platform-specific implementations
- `Greeting.kt` - Simple business logic example demonstrating platform integration

## Development Commands

### Build and Run

**Desktop Application:**
```bash
./gradlew composeApp:run
```

**Web Application (Development):**
```bash
./gradlew composeApp:wasmJsBrowserDevelopmentRun
```

**Build All Targets:**
```bash
./gradlew build
```

### Testing

**Run All Tests:**
```bash
./gradlew test
```

**Platform-Specific Tests:**
```bash
./gradlew jvmTest
./gradlew wasmJsTest
```

### Distribution

**Desktop Distribution:**
```bash
./gradlew createDistributable
```
Supports DMG (macOS), MSI (Windows), and DEB (Linux) formats.

**Web Build for Production:**
```bash
./gradlew composeApp:wasmJsBrowserProductionWebpack
```

## Technology Stack

**Core Technologies:**
- Kotlin 2.2.0 with Multiplatform support
- Compose Multiplatform 1.8.2
- Material Design 3
- Kotlin/Wasm for web target

**Key Dependencies:**
- `androidx.lifecycle:lifecycle-viewmodel-compose` - Lifecycle-aware ViewModels
- `androidx.lifecycle:lifecycle-runtime-compose` - Compose runtime integration  
- `kotlinx-coroutines-swing` - JVM-specific coroutines integration

**Development Tools:**
- Compose Hot Reload for faster development iterations
- Webpack dev server for web development with source mapping

## Platform-Specific Notes

**JVM Target:**
- Entry point: `com.iafedoseye.promptcraft.MainKt`
- Uses Swing coroutines for background operations
- Supports native distributions via Compose Desktop

**WebAssembly Target:**
- Module name: `composeApp`
- Output: `composeApp.js`
- Requires modern browsers with WebAssembly support
- Hot reload available in development mode

## Project Structure Conventions

- Platform-specific code should implement `expect` functions declared in `commonMain`
- UI components should be defined in `commonMain` when possible
- Platform-specific resources go in respective platform source sets
- Main application logic resides in `App.kt` as the entry point