# Portfolio

| Area           | Technology                                        |
|----------------|---------------------------------------------------|
| Language       | Kotlin                                            |
| Web Build      | Kotlin/WasmJs (Compose for Web)                   |
| Deployment     | GitHub Actions + GitHub Pages                     |

---

- **CI/CD via GitHub Actions**  
   On every push to the `main` branch, the app is built using `wasmJsBrowserDistribution` and deployed automatically to GitHub Pages.

---

build : `./gradlew :composeApp:wasmJsBrowserDevelopmentRun`

path : `/composeApp/build/dist/js/productionExecutable/`

### Ref.
---
Deploy wasmJs : https://medium.com/@schott12521/deploy-kotlin-mutliplatform-wasmjs-to-github-pages-fe295d8b420f