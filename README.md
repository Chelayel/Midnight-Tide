# Midnight Tide

A cool-blue dark theme on `#151719` with teal accents and a colorblind-safe diff and error palette. Two ports, one design:

| Editor | Folder | Get it |
| --- | --- | --- |
| JetBrains (2025.3+, Islands layout) | [`midnight-tide/`](midnight-tide/) | [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/31513-midnight-tide) |
| VS Code | [`midnight-tide-vscode/`](midnight-tide-vscode/) | [VS Code Marketplace](https://marketplace.visualstudio.com/items?itemName=Chelayel.midnight-tide-vscode) |

## License

MIT. Built by [Chelayel](https://www.chelayel.com).

## Publishing

A tag publishes both themes at the tag's version:

```
git tag v1.0.3 && git push origin v1.0.3
```

[`release.yml`](.github/workflows/release.yml) builds and verifies the JetBrains plugin and the VS Code extension, attaches both to a GitHub release, and uploads each to its marketplace only when that marketplace doesn't already have the version, so re-running a tag is safe. A push to `main` that touches either theme builds them as a check and publishes nothing. Bump `pluginVersion` in `midnight-tide/gradle.properties` and `version` in `midnight-tide-vscode/package.json` alongside the tag so local builds carry the same number.

Store tokens are repository secrets (`gh secret set NAME`, value on standard input):

| Secret | For |
| --- | --- |
| `JETBRAINS_MARKETPLACE_TOKEN` | JetBrains Marketplace, a token from https://plugins.jetbrains.com/author/me/tokens |
| `VSCE_PAT` | VS Code Marketplace, an Azure DevOps PAT with *Marketplace: Manage* on all accessible organizations (retired by Microsoft on 2026-12-01) |
| `AZURE_CLIENT_ID`, `AZURE_TENANT_ID` | VS Code Marketplace through a managed identity instead of the PAT; its federated credential must trust this repository's `marketplace-publish` environment |
| `OVSX_PAT` | Open VSX, optional |

A missing token skips that store with a warning.
