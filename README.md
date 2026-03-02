# 🏦 Davivienda – QA Automation Challenge (Monorepo)

## 1. Objetivo
Implementar una solución de automatización integral que valide los flujos críticos del sistema OrangeHRM, bajo un enfoque de **Monorepo** que centraliza pruebas de **Capa de Servicio (API)** y **Capa de Interfaz (UI)**.

Para asegurar un proceso de pruebas robusto, se diseñó un entorno escalable compuesto por:

* **Automatización API:** Pruebas de servicios para la gestión de empleados utilizando el módulo REST de Serenity.
* **Automatización UI:** Implementada con **Serenity BDD**, **Selenium** y **Java**, utilizando el patrón **Screenplay**.
* **Integración Continua (CI/CD):** Configuración de **GitHub Actions** para la ejecución automática y generación de artefactos.



## 2. Arquitectura del Proyecto (Monorepo)

```
DAVIVIENDA_AUTOMATION_FRAMEWORK
│
├── .github/workflows/           # 🚀 Orquestación CI/CD
│   └── full-ci.yml              # Pipeline unificado (API & Web)
│
├── davivienda-api-automation/   # 🌐 Módulo de Pruebas API
│   ├── src/test/java            # Lógica de servicios
│   │   └── co.com.davivienda.automation
│   │       ├── models           # POJOs para Payloads
│   │       ├── questions        # Validaciones de respuesta
│   │       ├── runners          # Ejecutores de Cucumber
│   │       ├── stepdefinitions  # Pasos de prueba
│   │       └── task             # Acciones de servicio (POST, GET)
│   └── pom.xml                  # Dependencias de Backend
│
└── davivienda-web-automation/   # 🖥️ Módulo de Pruebas Web (UI)
    ├── src/test/java            # Automatización con Serenity
    │   └── co.com.davivienda.automation
    │       ├── interactions     # 🛠️ Clases personalizadas (WaitUntilReady)
    │       ├── questions        # Verificaciones de interfaz
    │       ├── runners          # Ejecutores de Cucumber
    │       ├── stepdefinitions  # Pasos de flujo UI
    │       ├── task             # Tareas de negocio (PIM)
    │       └── ui               # Localizadores (Targets)
    ├── src/test/resources       # Features y serenity.conf
    └── pom.xml                  # Dependencias de Frontend
```
## 3. Patrón de Diseño: Screenplay
Se implementó el patrón **Screenplay** en ambos módulos para garantizar una arquitectura robusta y escalable:

* **Mantenibilidad**: Los cambios en la UI o API se actualizan en un solo lugar, ya sea en el **Target** (localizadores) o en la **Task** (lógica de negocio), evitando la duplicidad de código.
* **Reutilización**: Las interacciones personalizadas, como la clase `WaitUntilReady` (ver `image_52213e.png`), se diseñaron para ser usadas en múltiples escenarios de prueba sin modificaciones adicionales.
* **Legibilidad Semántica**: Gracias a la sintaxis de Serenity, las pruebas se leen como lenguaje natural, lo que facilita el entendimiento del flujo de negocio para perfiles no técnicos o interesados (Stakeholders).


## 4. Stack Tecnológico
La solución utiliza las siguientes tecnologías de estándar industrial para asegurar estabilidad y reportes de alta calidad:

* **Java 17**: Lenguaje de programación robusto y con soporte de largo plazo (LTS).
* **Maven**: Gestor de dependencias y ciclo de vida del proyecto.
* **Serenity BDD**: Framework central para la gestión de reportes vivos y soporte de **Cucumber** y **Rest**.
* **Selenium WebDriver**: Motor para la automatización de interacciones en navegadores web.
* **GitHub Actions**: Orquestador de **CI/CD** para la ejecución automatizada en la nube.
## 5. Estrategia de Pruebas
Se automatizaron los flujos de punta a punta (End-to-End) asegurando la calidad en ambas capas:

* **Módulo API**: Validación de creación de empleados, códigos de estado HTTP y consistencia de datos en la respuesta JSON.
* **Módulo UI**: Flujo completo de autenticación, navegación al módulo PIM, registro de nuevo personal y validación de visibilidad en el encabezado de perfil.
* **Ejecución Robusta**: Configuración de esperas dinámicas para mitigar fallos por latencia en el entorno de CI/CD.

## 6. Reportes y Evidencias
El framework genera automáticamente reportes enriquecidos en la carpeta `target/site/serenity` de cada módulo:

* **Screenshots paso a paso** en cada interacción de la prueba UI.
* **Logs detallados** de las peticiones y respuestas en las pruebas de API.
## 7. Ejecución de Pruebas

### Ejecutar módulo API
```
cd davivienda-api-automation
mvn clean verify
```
### Ejecutar módulo Web (UI)
```
cd davivienda-web-automation
mvn clean verify
```
## 8. Decisiones Técnicas

* **Modo Headless**: Se configuró Chrome para ejecutarse sin interfaz en GitHub Actions, optimizando el uso de recursos y evitando fallos de renderizado en servidores Linux.
* **Sincronización Avanzada**: Implementación de la interacción `WaitUntilReady` para manejar la carga asíncrona de elementos en el DOM de OrangeHRM.
* **Aislamiento de Módulos**: Cada proyecto dentro del Monorepo cuenta con su propio `pom.xml`, permitiendo gestionar dependencias específicas para Backend y Frontend.
## 9. Ejecución en el Pipeline (CI/CD)
El proyecto cuenta con un flujo de trabajo automatizado en **GitHub Actions** que permite validar la integridad del código de manera continua.

### Disparadores del Workflow
1.  **Automático**: Se ejecuta con cada `push` o `pull_request` a la rama `main`.
2.  **Manual (Workflow Dispatch)**: Permite ejecutar las pruebas bajo demanda desde la pestaña "Actions" de GitHub, seleccionando el tipo de prueba (API, Web o Ambas).

### Acceso a los Resultados
Una vez finalizada la ejecución, los reportes de **Serenity BDD** están disponibles para su revisión:
1.  Vaya a la pestaña **Actions** en el repositorio.
2.  Seleccione la ejecución más reciente.
3.  Descienda hasta la sección **Artifacts** y descargue el paquete de reportes.
4.  Descomprima y abra el archivo `index.html` para ver el detalle técnico y las evidencias.
  
