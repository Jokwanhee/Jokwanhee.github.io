# 🏋️‍♂️ Gym App (Kotlin Multiplatform + WASM + Supabase)
This is a Kotlin Multiplatform project targeting Web.

| Area           | Technology                                        |
|----------------|---------------------------------------------------|
| Language       | Kotlin                                            |
| Web Build      | Kotlin/WasmJs (Compose for Web)                   |
| Deployment     | GitHub Actions + GitHub Pages                     |
| Backend / DB   | [Supabase](https://supabase.io/)                  |
| UI Design      | Figma MCP Plugin                                  |
| Automation     | Gemini CLI ([gemini.design](https://gemini.design)) |

---

1. **CI/CD via GitHub Actions**  
   On every push to the `main` branch, the app is built using `wasmJsBrowserDistribution` and deployed automatically to GitHub Pages.

2. **Secure Secret Handling**  
   Supabase credentials are stored as GitHub Secrets, and a `Key.kt` file is generated dynamically during the CI process.

---

build : ./gradlew :composeApp:wasmJsBrowserDevelopmentRun
path : /composeApp/build/dist/js/productionExecutable/

### Ref.
---
Deploy wasmJs : https://medium.com/@schott12521/deploy-kotlin-mutliplatform-wasmjs-to-github-pages-fe295d8b420f