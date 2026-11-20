# Implementación de mecanismos de resiliencia en un sistema de banca

En un sistema de banca, es crucial garantizar que las transacciones se completen de manera exitosa a pesar de posibles fallos en servicios externos o internos. Tu tarea es implementar mecanismos de resiliencia utilizando patrones como SAGA, Retry, Fallback, RateLimit, Circuit Breaker y Bulkhead para asegurar que el sistema continúe operando de manera eficiente y segura ante fallos inesperados.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Código resiliente |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 10 horas |

## Stack

- **Lenguaje:** Java
- **Framework:** Spring Boot 3.5
- **Version:** Java 21

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Tener el proyecto base del reto funcionando en tu máquina: clonar el repositorio, instalar las herramientas y verificar que compila y arranca antes de empezar a practicar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Instala las herramientas para ejecutar el proyecto: JDK 17+ y Maven 3.9+.
- Clona el repositorio del reto (el enlace viene en la entrega del reto y en la sección "Repositorio del Proyecto" del PDF) y ábrelo en tu IDE.
- Instala las dependencias y compila ejecutando `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` en la raíz del repositorio.
- Confirma que el comando termina sin errores: el proyecto arranca y sus pruebas corren.
- Ubica los archivos de práctica: son los que contienen `TODO(reto)` (búscalos en el repositorio). Lee el README.md y el AGENTS.md antes de empezar.

**Entregable:** El proyecto compila/arranca sin errores con `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package`.

<details>
<summary>Pistas de conocimiento</summary>

- Los archivos con `TODO(reto)` son el ejercicio: el resto del repositorio ya está resuelto y no hace falta tocarlo.
- Si el comando de verificación falla, revisa la versión de las herramientas instaladas antes de modificar código.
- AGENTS.md describe el reto, el comando de verificación y las reglas del repositorio.

</details>

### Fase 1: Configuración inicial y análisis de requisitos

**Objetivo:** Entender los requisitos de resiliencia y configurar el entorno de desarrollo.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Documentar los requisitos de resiliencia identificados para el sistema, incluyendo la necesidad de manejar fallos temporales, prevenir propagación de fallos y limitar solicitudes.
- Configurar el proyecto con las dependencias de Resilience4j y Project Reactor, asegurando que las versiones sean compatibles con Spring WebFlux.
- Verificar la configuración mediante un caso de aceptación que confirme la presencia de las dependencias requeridas en el archivo de construcción (pom.xml o build.gradle).

**Entregable:** Documento de análisis de requisitos y configuración del entorno de desarrollo.

<details>
<summary>Pistas de conocimiento</summary>

- Identifica las posibles fuentes de fallos en el sistema.
- Investiga los patrones de resiliencia y su aplicación en sistemas de banca.

</details>

### Fase 2: Implementación de Retry y Fallback

**Objetivo:** Implementar mecanismos de Retry y Fallback para manejar fallos temporales en servicios externos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementa un mecanismo de Retry para reintentar las solicitudes a servicios externos que fallen temporalmente.
- Implementa un mecanismo de Fallback para proporcionar una respuesta alternativa cuando un servicio externo falle.

**Entregable:** Código que implementa Retry y Fallback para servicios externos.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza el patrón Retry para reintentar las solicitudes fallidas.
- Implementa el patrón Fallback para proporcionar una respuesta alternativa en caso de fallo.

</details>

### Fase 3: Implementación de Circuit Breaker y Bulkhead

**Objetivo:** Implementar mecanismos de Circuit Breaker y Bulkhead para prevenir la propagación de fallos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementa un mecanismo de Circuit Breaker para detener las solicitudes a servicios externos que fallen repetidamente.
- Implementa un mecanismo de Bulkhead para aislar las solicitudes a servicios externos y prevenir la propagación de fallos.

**Entregable:** Código que implementa Circuit Breaker y Bulkhead para servicios externos.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza el patrón Circuit Breaker para detener las solicitudes a servicios externos que fallen repetidamente.
- Implementa el patrón Bulkhead para aislar las solicitudes a servicios externos y prevenir la propagación de fallos.

</details>

### Fase 4: Implementación de RateLimit

**Objetivo:** Implementar un mecanismo de RateLimit para limitar el número de solicitudes a servicios externos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Implementa un mecanismo de RateLimit para limitar el número de solicitudes a servicios externos.
- Configura el mecanismo de RateLimit para ajustar el número máximo de solicitudes permitidas por segundo.

**Entregable:** Código que implementa RateLimit para servicios externos.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza el patrón RateLimit para limitar el número de solicitudes a servicios externos.
- Configura el mecanismo de RateLimit para ajustar el número máximo de solicitudes permitidas por segundo.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los patrones de resiliencia y cómo se aplican en un sistema de banca?
- **paraQueSirve**: ¿Para qué sirven los mecanismos de resiliencia en un sistema de banca?
- **comoSeUsa**: ¿Cómo se implementan los mecanismos de resiliencia en un sistema de banca?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar mecanismos de resiliencia en un sistema de banca?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación de mecanismos de resiliencia en un sistema de banca?

## Criterios de Evaluacion

- Implementación correcta de Retry y Fallback para servicios externos.
- Implementación correcta de Circuit Breaker y Bulkhead para servicios externos.
- Implementación correcta de RateLimit para servicios externos.
- Documentación clara y concisa del análisis de requisitos y configuración del entorno de desarrollo.

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Configuración inicial y análisis de requisitos | — | — | El documento de análisis de requisitos incluye la identificación de mecanismos de resiliencia necesarios: Retry, Fallback, Circuit Breaker, Bulkhead y RateLimit.; El entorno de desarrollo está configurado con las dependencias de Resilience4j y Project Reactor, verificable en el archivo de construcción. | — | — |
| f2 — Implementación de Retry y Fallback | Implementación de lógica de reintentos con Project Reactor y Resilience4j | `src/main/java/application/service/RetryService.java:RetryService` | El sistema debe reintentar solicitudes fallidas a servicios externos un número configurable de veces antes de aplicar un Fallback.; El Fallback debe proporcionar una respuesta alternativa cuando el servicio externo no está disponible después de los reintentos.; Los casos de aceptación deben incluir escenarios de éxito, fallo transitorio y fallo permanente. | — | — |
| f2 — Implementación de Retry y Fallback | Implementación de un cliente de Fallback para proporcionar respuestas alternativas | `src/main/java/infrastructure/adapter/FallbackClient.java:FallbackClient` | El sistema debe reintentar solicitudes fallidas a servicios externos un número configurable de veces antes de aplicar un Fallback.; El Fallback debe proporcionar una respuesta alternativa cuando el servicio externo no está disponible después de los reintentos.; Los casos de aceptación deben incluir escenarios de éxito, fallo transitorio y fallo permanente. | — | — |
| f3 — Implementación de Circuit Breaker y Bulkhead | Implementación de Circuit Breaker con Resilience4j para prevenir fallos en cascada | `src/main/java/application/service/CircuitBreakerService.java:CircuitBreakerService` | El Circuit Breaker debe abrirse después de un número configurable de fallos y rechazar solicitudes durante un tiempo de espera.; El Bulkhead debe limitar el número de solicitudes concurrentes a un servicio externo, evitando la saturación de recursos.; Los casos de aceptación deben incluir escenarios de apertura/cierre del Circuit Breaker y saturación del Bulkhead. | — | — |
| f3 — Implementación de Circuit Breaker y Bulkhead | Implementación de Bulkhead para limitar solicitudes concurrentes y evitar saturación | `src/main/java/application/service/BulkheadService.java:BulkheadService` | El Circuit Breaker debe abrirse después de un número configurable de fallos y rechazar solicitudes durante un tiempo de espera.; El Bulkhead debe limitar el número de solicitudes concurrentes a un servicio externo, evitando la saturación de recursos.; Los casos de aceptación deben incluir escenarios de apertura/cierre del Circuit Breaker y saturación del Bulkhead. | — | — |
| f4 — Implementación de RateLimit | Implementación de RateLimit para proteger servicios externos de sobrecarga | `src/main/java/application/service/RateLimiterService.java:RateLimiterService` | El RateLimit debe limitar el número de solicitudes a un servicio externo en una ventana de tiempo configurable.; Las solicitudes que excedan el límite deben ser rechazadas con un código de estado apropiado.; Los casos de aceptación deben incluir escenarios de límite alcanzado y límite no alcanzado. | — | — |

## Pruebas de aceptacion

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Patrón SAGA y Retry (project reactor). Menciono circuitbreaker pero menciono que lo implementaba con webclient lo cual no es posible nativamente sino combinandolo con alguna librería como resilience4j la cual nunca menciono , por lo anterior no le doy 4 puntos. | chequeo estatico (code): exige `Retry`, `resilience4j`, `CircuitBreaker`; prohibe `Saga`, `saga` | Restriccion no verificada en chequeo estatico (code): exige `Retry`, `resilience4j`, `CircuitBreaker`; prohibe `Saga`, `saga` |
| Patrón SAGA y Retry (project reactor). | `src/main/java/application/service/RetryService.java:RetryService` | Verificada |
| Patrón SAGA y Retry (project reactor). | sin ubicar | Restriccion no verificada en sin ubicar |

## Herramientas

- **Patrones de resiliencia y tolerancia a fallos**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Fallback**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Retry**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Resilience4j**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **RateLimit**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Circuit Breaker**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Bulkhead**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
