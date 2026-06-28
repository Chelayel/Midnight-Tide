# Midnight Tide — VS Code Theme

A blue-dominant dark theme on a `#151719` cool-gray base. Color-vision-safe error and VCS palette: amber and yellow stand in for red, neutral gray for deleted lines, mustard-brown for merge conflicts — all chosen to kill red/green confusion.

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
| Comments | `#525861` muted gray (italic) |
| Decorators / annotations | `#FACC15` yellow |

**Status colors (red-green colorblind-safe):**

| Indicator | Hex |
|---|---|
| Errors | `#F59E0B` amber |
| Warnings | `#FACC15` yellow |
| Git added | `#73BD79` desaturated green |
| Git modified | `#70AEFF` blue |
| Git deleted | `#6F737A` neutral gray |
| Git conflict | `#D69A6B` mustard-brown |

**Search matches** are saturated teal (`#155E75` for highlights, `#0E7490` for the active match) so they pop against both the editor background and the selection.

## Install

### From `.vsix` file

1. Download `midnight-tide-1.0.0.vsix`
2. In VS Code: open the Extensions panel, click the **`…`** menu in the top-right, choose **Install from VSIX…**, pick the file
3. **Ctrl/Cmd + K, Ctrl/Cmd + T** to open the theme picker, choose **Midnight Tide**

### From source folder (development)

```bash
# Copy the extension folder to your VS Code extensions directory
# macOS / Linux:
cp -r midnight-tide-vscode ~/.vscode/extensions/midnight-tide-1.0.0

# Windows:
xcopy /E /I midnight-tide-vscode %USERPROFILE%\.vscode\extensions\midnight-tide-1.0.0
```

Restart VS Code, then **Ctrl/Cmd + K, Ctrl/Cmd + T** → **Midnight Tide**.

### Build the `.vsix` from source

```bash
npm install -g @vscode/vsce
cd midnight-tide-vscode
vsce package
```

Produces `midnight-tide-1.0.0.vsix` in the current directory.

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
    └── MidnightTide-color-theme.json         ← ALL the colors + tokens
```

The single theme JSON has three sections:
- `colors` — workbench (editor chrome, sidebar, tabs, status bar, etc.)
- `tokenColors` — TextMate-scope syntax highlighting (the broad-coverage layer)
- `semanticTokenColors` — newer, richer semantic highlighting (overrides TextMate where the language server provides semantic info)

To tweak: edit the JSON, reload VS Code (`Cmd+R` / `Ctrl+R`), the theme picks up changes immediately.

## License

MIT.
