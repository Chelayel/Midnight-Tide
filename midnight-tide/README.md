# Midnight Tide — JetBrains Theme

A cool-blue dark theme on `#151719`. Built for JetBrains' **Islands** layout, with teal accents and a colorblind-safe diff palette.

## What this is

The editor color scheme is forked directly from JetBrains' built-in **Islands Dark** with three surgical changes:

1. **Editor background** remapped to `#151719` (was `#191A1C`), with chrome backgrounds shifted to a cooler tier
2. **Teal accent** (`#0891B2`) for selection, focus, action button — replacing Islands Dark's azure
3. **Diff line colors** swapped to JetBrains' deuteranopia palette so they're colorblind-safe out of the box

Everything else — syntax tokens, gutter, popups, all ~190 other color keys — inherits from Islands Dark unchanged.

## Background tiers

| Layer | Hex | Used for |
|---|---|---|
| Editor base | `#151719` | The text editor itself |
| Caret row / docs | `#1A1D21` | Subtle line highlight, doc popups |
| Chrome panels | `#1F2226` | Folded text borders, separators |
| Darker chrome | `#2A2E33` | Selected-tab darker accents |

## Diff palette (deuteranopia-safe)

| Key | Hex |
|---|---|
| `ADDED_LINES_COLOR` | `#355237` |
| `MODIFIED_LINES_COLOR` | `#345A67` |
| `DELETED_LINES_COLOR` | `#656E76` (neutral gray, no red) |
| `WHITESPACES_MODIFIED_LINES_COLOR` | `#34434D` |

These match the values JetBrains uses internally when you turn on "Adjust colors for red-green vision deficiency" — applied directly so they show in normal mode too.

## Requirements

- JetBrains IDE 2025.3 or newer (needed for the `Islands Dark` parent theme)

## Install

1. Download `midnight-tide-1.0.0.zip`
2. **Settings → Plugins → ⚙ → Install Plugin from Disk…** → pick the zip
3. Restart the IDE
4. **Settings → Appearance → Theme → Midnight Tide**
5. **Settings → Editor → Color Scheme → Midnight Tide**
6. (Recommended) Enable **"Different tool window background"** in the Appearance settings for the floating-island look

## Build from source

JDK 17+ required.

```bash
chmod +x gradlew
./gradlew buildPlugin
```

Produces the installable plugin at `build/distributions/midnight-tide-1.0.0.zip`.

## Project layout

```
midnight-tide/
├── build.gradle.kts
├── settings.gradle.kts
└── src/main/resources/
    ├── META-INF/plugin.xml
    └── themes/
        ├── MidnightTide.theme.json    ← UI chrome
        └── MidnightTide.xml           ← editor color scheme (forked from Islands Dark)
```

## Companion: file/folder icons

Midnight Tide controls colors only — file-tree icons are a separate plugin type. To get colorful Material-style icons, install **Atom Material Icons** from JetBrains Marketplace alongside Midnight Tide.

## License

MIT.
