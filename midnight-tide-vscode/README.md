# Midnight Tide — VS Code Theme

A blue-dominant dark theme on a `#151719` cool-gray base. Color-vision-safe error and VCS palette: soft coral for errors, yellow for warnings, blue for modified lines and neutral gray for deleted lines, all chosen to avoid red/green confusion.

This is the VS Code port of the [Midnight Tide JetBrains theme](https://github.com/Chelayel/Midnight-Tide) — same palette, same design decisions.

## Palette

**Backgrounds:**

| Layer | Hex | Used for |
|---|---|---|
| Outer | `#151719` | Activity bar, status bar, title bar |
| Editor | `#151719` | Editor & terminal |
| Sidebar | `#1A1D21` | File explorer, panel sections |
| Elevated | `#1A1D21` / `#1F2226` | Popups, inputs, dropdowns |

**Syntax (blue + purple keywords):**

| Token | Hex |
|---|---|
| Keywords (`import`, `const`, `class`, etc.) | `#C084FC` purple |
| Strings | `#7DD3FC` sky blue |
| Numbers, properties, instance fields | `#0891B2` teal |
| Functions, methods, HTML tags | `#60A5FA` medium blue |
| Class/type names | `#A5F3FC` lavender-cyan |
| Parameters | `#BFDBFE` pale blue (italic) |
| `this` / `self` | `#C084FC` purple (italic) |
| Comments | `#7A7E85` muted gray (italic) |
| Decorators / annotations | `#FACC15` yellow |

**Status colors (red-green colorblind-safe):**

| Indicator | Hex |
|---|---|
| Errors | `#E88F89` coral |
| Warnings | `#FACC15` yellow |
| Git added | `#73BD79` desaturated green |
| Git modified | `#70AEFF` blue |
| Git deleted | `#6F737A` neutral gray |
| Git untracked | `#E88F89` coral |
| Git conflict | `#DE6A66` deep coral |

**Search matches** are saturated teal (`#155E75` for highlights, `#0E7490` for the active match) so they pop against both the editor background and the selection.

## Midnight Tide Bioluminescence

The extension also installs a second, more colorful theme. It keeps the same background, UI and status colors, and adds glowing accents:

| Change | Color |
|---|---|
| Strings | `#5EEAD4` seafoam |
| Numbers and constants | `#FDBA74` peach |
| Classes and types | `#F0ABFC` orchid |
| Properties | `#7DD3FC` sky blue |
| Keywords | `#C084FC` purple, now italic |
| Cursor | `#5EEAD4` seafoam |
| Status bar | `#0E3B44` deep teal |
| Rainbow brackets and guides | seafoam, orchid, peach, blue, purple, sky |

Pick it with **Ctrl/Cmd + K, Ctrl/Cmd + T** → **Midnight Tide Bioluminescence**.

Bracket-pair guides are off in VS Code by default. To see the colored vertical guides, add this to your settings:

```json
"editor.guides.bracketPairs": "active"
```

Italic keywords look best with a font that has a cursive italic, such as Victor Mono or Monaspace Radon.

## Install

### From `.vsix` file

1. Download `midnight-tide-vscode-1.1.0.vsix` from the [Releases page](https://github.com/Chelayel/Midnight-Tide/releases)
2. In VS Code: open the Extensions panel, click the **`…`** menu in the top-right, choose **Install from VSIX…**, pick the file
3. **Ctrl/Cmd + K, Ctrl/Cmd + T** to open the theme picker, choose **Midnight Tide** or **Midnight Tide Bioluminescence**

### From source folder (development)

```bash
# Copy the extension folder to your VS Code extensions directory
# macOS / Linux:
cp -r midnight-tide-vscode ~/.vscode/extensions/midnight-tide-vscode

# Windows:
xcopy /E /I midnight-tide-vscode %USERPROFILE%\.vscode\extensions\midnight-tide-vscode
```

Restart VS Code, then **Ctrl/Cmd + K, Ctrl/Cmd + T** → **Midnight Tide**.

### Build the `.vsix` from source

```bash
npm install -g @vscode/vsce
cd midnight-tide-vscode
vsce package
```

Produces `midnight-tide-vscode-<version>.vsix` in the current directory.

## Companion: file/folder icons

The theme controls colors only — file-tree icons are a separate extension. To get the colorful Material-style icons (the look from the reference screenshot), pair Midnight Tide with one of these:

- **[Material Icon Theme](https://marketplace.visualstudio.com/items?itemName=PKief.material-icon-theme)** — the canonical one
- **[VSCode Icons](https://marketplace.visualstudio.com/items?itemName=vscode-icons-team.vscode-icons)** — alternative style

Install either, then **File → Preferences → Theme → File Icon Theme** (or `Ctrl+K Ctrl+T` for color theme, the icon theme picker is right next to it).

## Project layout

```
midnight-tide-vscode/
├── package.json                          ← extension manifest
├── README.md
└── themes/
    ├── MidnightTide-color-theme.json         ← Midnight Tide: all the colors + tokens
    └── MidnightTide-Bioluminescence-color-theme.json  ← the Bioluminescence variant
```

The single theme JSON has three sections:
- `colors` — workbench (editor chrome, sidebar, tabs, status bar, etc.)
- `tokenColors` — TextMate-scope syntax highlighting (the broad-coverage layer)
- `semanticTokenColors` — newer, richer semantic highlighting (overrides TextMate where the language server provides semantic info)

To tweak: edit the JSON, reload VS Code (`Cmd+R` / `Ctrl+R`), the theme picks up changes immediately.

## License

MIT. Built by [Chelayel](https://www.chelayel.com).
