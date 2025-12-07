# Plataforma Segura QA – Proyecto 2FA Automatizado 🚀

## 🧩 Descripción General  
Este proyecto demuestra un flujo completo de **automatización QA** para un escenario de **login con doble factor de autenticación (2FA)**.  
Incluye:

- Generación de OTP vía **módulo API (Java + Maven)**
- Validación del OTP mediante **UI automatizada con Playwright**
- Integración con **Allure Reports**
- Ejecución continua mediante **GitHub Actions**
- Arquitectura modular profesional (pruebas API + UI)

Este repositorio está diseñado para demostrar habilidades de nivel **QA Automation Senior**.

---

## ⚙️ Tecnologías Utilizadas
### 🔹 Backend / API
- Java 21  
- Maven  
- JUnit 5  
- Generación de OTP  
- Modelo limpio en módulos  

### 🔹 Frontend / UI Automation
- Playwright for Java  
- Manejo de escenarios UI con OTP  
- Capturas automáticas para evidencia

### 🔹 Integración y Reporting
- Allure Framework  
- Surefire Reports  
- GitHub Actions CI Pipeline

---

## 📁 Estructura del Proyecto
```
plataforma-segura-qa/
│
├── pruebas-api/
│   ├── GeneradorOTP.java
│   └── tests API
│
├── pruebas-ui/
│   ├── otp.html (pantalla 2FA)
│   ├── PruebaLogin2FATest.java
│   └── evidencias / screenshots
│
└── .github/workflows/
    └── ci.yml
```

---

## ▶️ Ejecución del Proyecto en Local

### 1️⃣ Clonar el repositorio
```bash
git clone https://github.com/vbtony6/plataforma-segura-qa.git
cd plataforma-segura-qa
```

### 2️⃣ Ejecutar pruebas API
```bash
mvn -pl pruebas-api test
```

Esto generará el archivo OTP en:

```
otp/otp-generado.txt
```

### 3️⃣ Ejecutar pruebas UI
```bash
mvn -pl pruebas-ui test
```

Playwright abrirá la pantalla 2FA y validará automáticamente el OTP generado.

---

## ☁️ Ejecución en GitHub Actions (CI/CD)
Cada cambio push a `main` dispara la ejecución del pipeline definido en:

```
.github/workflows/ci.yml
```

El pipeline:

✔ Descarga dependencias  
✔ Ejecuta pruebas API  
✔ Ejecuta pruebas UI en modo headless  
✔ Publica Allure Results como artefacto descargable  

Puedes ver las ejecuciones aquí:

👉 **Actions:** https://github.com/vbtony6/plataforma-segura-qa/actions

---

## 🧪 Evidencias de Ejecución
El pipeline genera:

- Capturas de pantalla  
- Logs de prueba  
- Reportes Allure  
- Resultados JUnit XML  

Los artefactos quedan disponibles después de cada run.

---

## 🦸 Sobre este proyecto
Este repositorio fue creado como demostración profesional de:

- Arquitectura modular en automatización  
- Integración API + UI  
- Flujo real de 2FA  
- CI/CD corporativo  
- Buenas prácticas QA Senior  

Es un proyecto ideal para entrevistas técnicas, portafolio profesional y presentaciones para empresas.

---

## ✨ Autor
**Julio Lazo**  
QA Automation Specialist  
