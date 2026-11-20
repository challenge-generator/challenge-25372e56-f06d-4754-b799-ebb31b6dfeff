# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de mecanismos de resiliencia en un sistema de banca**.

| | |
|---|---|
| Tema | Código resiliente |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | hexagonal/clean con capas reactivas |
| Tiempo estimado | 10 horas |

## Herramientas

- **Patrones de resiliencia y tolerancia a fallos**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Fallback**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Retry**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Resilience4j**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **RateLimit**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Circuit Breaker**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Bulkhead**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web
- org.springframework.boot:spring-boot-starter-test
- io.github.resilience4j:resilience4j-reactor 2.4.0
- io.github.resilience4j:resilience4j-spring-boot3 2.4.0
- io.projectreactor:reactor-core
- io.projectreactor:reactor-test
- org.springframework.boot:spring-boot-starter-actuator
- org.springframework.boot:spring-boot-starter-validation
- org.springframework.boot:spring-boot-starter-webflux

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Configuración inicial y análisis de requisitos**: Documento de análisis de requisitos y configuración del entorno de desarrollo.
- **Fase 2 — Implementación de Retry y Fallback**: Código que implementa Retry y Fallback para servicios externos.
- **Fase 3 — Implementación de Circuit Breaker y Bulkhead**: Código que implementa Circuit Breaker y Bulkhead para servicios externos.
- **Fase 4 — Implementación de RateLimit**: Código que implementa RateLimit para servicios externos.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/application/service/RetryService.java` — La pieza p1 (Implementación de lógica de reintentos con Project Reactor y Resilience4j, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/infrastructure/adapter/FallbackClient.java` — La pieza p2 (Implementación de un cliente de Fallback para proporcionar respuestas alternativas, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/application/service/CircuitBreakerService.java` — La pieza p3 (Implementación de Circuit Breaker con Resilience4j para prevenir fallos en cascada, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/application/service/BulkheadService.java` — La pieza p4 (Implementación de Bulkhead para limitar solicitudes concurrentes y evitar saturación, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/application/service/RateLimiterService.java` — La pieza p5 (Implementación de RateLimit para proteger servicios externos de sobrecarga, fase f4) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/Application.java` — absorbida: fuga de la pieza p1
- [ ] `src/main/java/com/example/reto/application/service/RetryService.java` — absorbida: fuga de la pieza p1
- [ ] `src/main/java/com/example/reto/application/service/CircuitBreakerService.java` — absorbida: fuga de la pieza p2
- [ ] `src/main/java/com/example/reto/application/service/BulkheadService.java` — absorbida: fuga de la pieza p2
- [ ] `src/main/java/com/example/reto/application/service/RateLimiterService.java` — absorbida: fuga de la pieza p2
- [ ] `src/main/java/com/example/reto/infrastructure/adapter/FallbackClient.java` — absorbida: fuga de la pieza p2
- [ ] `src/main/java/domain/model/RetryConfig.java` — absorbida: fuga de la pieza p4
- [ ] `src/main/java/com/example/reto/domain/model/BulkheadConfig.java` — absorbida: fuga de la pieza p4

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

## Pruebas de aceptacion y ubicacion de la logica

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

La logica de cada pieza va en su archivo; no la muevas a otro.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Patrón SAGA y Retry (project reactor). Menciono circuitbreaker pero menciono que lo implementaba con webclient lo cual no es posible nativamente sino combinandolo con alguna librería como resilience4j la cual nunca menciono , por lo anterior no le doy 4 puntos. | chequeo estatico (code): exige `Retry`, `resilience4j`, `CircuitBreaker`; prohibe `Saga`, `saga` | Restriccion no verificada en chequeo estatico (code): exige `Retry`, `resilience4j`, `CircuitBreaker`; prohibe `Saga`, `saga` |
| Patrón SAGA y Retry (project reactor). | `src/main/java/application/service/RetryService.java:RetryService` | Verificada |
| Patrón SAGA y Retry (project reactor). | sin ubicar | Restriccion no verificada en sin ubicar |

## Lo que falta y tenes que completar

### Imports sin uso (3) — no rompen la compilacion

Limpieza opcional: el proyecto compila igual con ellos.

- `src/main/java/Application.java` — `CircuitBreakerConfig`
- `src/main/java/Application.java` — `BulkheadConfig`
- `src/main/java/Application.java` — `RateLimiterConfig`

### Presentes (22)

- `pom.xml`
- `src/main/java/domain/model/Response.java`
- `src/main/java/domain/model/RetryConfig.java`
- `src/main/java/domain/model/CircuitBreakerConfig.java`
- `src/main/java/domain/model/BulkheadConfig.java`
- `src/main/java/domain/model/RateLimiterConfig.java`
- `src/main/java/domain/port/FallbackService.java`
- `src/main/java/application/service/RetryService.java`
- `src/main/java/infrastructure/adapter/FallbackClient.java`
- `src/main/java/application/service/CircuitBreakerService.java`
- `src/main/java/application/service/BulkheadService.java`
- `src/main/java/application/service/RateLimiterService.java`
- `src/main/java/resources/application.yml`
- `src/main/java/Application.java`
- `src/main/java/com/example/reto/application/service/RetryService.java`
- `src/main/java/com/example/reto/application/service/CircuitBreakerService.java`
- `src/main/java/com/example/reto/application/service/BulkheadService.java`
- `src/main/java/com/example/reto/application/service/RateLimiterService.java`
- `src/main/java/com/example/reto/infrastructure/adapter/FallbackClient.java`
- `src/main/java/com/example/reto/domain/model/BulkheadConfig.java`
- `src/main/java/com/example/reto/domain/model/Response.java`
- `src/main/java/domain/service/SagaOrchestrator.java`

### Capas del patron declarado

Son las capas que la propuesta arquitectonica plantea, marcadas segun existan hoy en el repo. Orientan donde poner el codigo nuevo; no son una condicion para compilar.

- `src/main/java/com/bank/resilience/domain/model` (ausente)
- `src/main/java/com/bank/resilience/domain/port` (ausente)
- `src/main/java/com/bank/resilience/application/service` (ausente)
- `src/main/java/com/bank/resilience/infrastructure/adapter` (ausente)
- `src/main/java/com/bank/resilience/infrastructure/config` (ausente)
- `src/main/java/com/bank/resilience/infrastructure/client` (ausente)
- `src/main/resources` (ausente)
- `src/test/java/com/bank/resilience` (ausente)

## Verificacion

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean con capas reactivas**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2
- Brecha que el reto ataca: CREA software tolerante a fallos inesperados utilizando mecanismos que aislen los errores y eviten colapso de funcionalidades críticas de un sistema.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
