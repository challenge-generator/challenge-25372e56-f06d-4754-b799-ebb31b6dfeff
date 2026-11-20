# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/application/service/RetryService.java` — La pieza p1 (Implementación de lógica de reintentos con Project Reactor y Resilience4j, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/infrastructure/adapter/FallbackClient.java` — La pieza p2 (Implementación de un cliente de Fallback para proporcionar respuestas alternativas, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/application/service/CircuitBreakerService.java` — La pieza p3 (Implementación de Circuit Breaker con Resilience4j para prevenir fallos en cascada, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/application/service/BulkheadService.java` — La pieza p4 (Implementación de Bulkhead para limitar solicitudes concurrentes y evitar saturación, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/application/service/RateLimiterService.java` — La pieza p5 (Implementación de RateLimit para proteger servicios externos de sobrecarga, fase f4) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/Application.java` — absorbida: fuga de la pieza p1
- `src/main/java/com/example/reto/application/service/RetryService.java` — absorbida: fuga de la pieza p1
- `src/main/java/com/example/reto/application/service/CircuitBreakerService.java` — absorbida: fuga de la pieza p2
- `src/main/java/com/example/reto/application/service/BulkheadService.java` — absorbida: fuga de la pieza p2
- `src/main/java/com/example/reto/application/service/RateLimiterService.java` — absorbida: fuga de la pieza p2
- `src/main/java/com/example/reto/infrastructure/adapter/FallbackClient.java` — absorbida: fuga de la pieza p2
- `src/main/java/domain/model/RetryConfig.java` — absorbida: fuga de la pieza p4
- `src/main/java/com/example/reto/domain/model/BulkheadConfig.java` — absorbida: fuga de la pieza p4

## Herramientas

- **Patrones de resiliencia y tolerancia a fallos**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Fallback**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Retry**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Resilience4j**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **RateLimit**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Circuit Breaker**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.
- **Bulkhead**: Tecnologia pedida para este reto: forma parte del stack con el que se resuelve el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Imports sin uso — no rompen la compilacion

Limpieza opcional: el proyecto compila igual con ellos:

- `src/main/java/Application.java` — `CircuitBreakerConfig`
- `src/main/java/Application.java` — `BulkheadConfig`
- `src/main/java/Application.java` — `RateLimiterConfig`

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2

### Brecha de conocimiento
CREA software tolerante a fallos inesperados utilizando mecanismos que aislen los errores y eviten colapso de funcionalidades críticas de un sistema.

### Reto
- Tema: Código resiliente
- Seniority: advanced-l2
- Tipo: practical
- Título: Implementación de mecanismos de resiliencia en un sistema de banca
- Tiempo estimado: 10 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración inicial y análisis de requisitos — objetivo: Entender los requisitos de resiliencia y configurar el entorno de desarrollo. — entregable (NO resolver): Documento de análisis de requisitos y configuración del entorno de desarrollo.
- Fase 2: Implementación de Retry y Fallback — objetivo: Implementar mecanismos de Retry y Fallback para manejar fallos temporales en servicios externos. — entregable (NO resolver): Código que implementa Retry y Fallback para servicios externos.
- Fase 3: Implementación de Circuit Breaker y Bulkhead — objetivo: Implementar mecanismos de Circuit Breaker y Bulkhead para prevenir la propagación de fallos. — entregable (NO resolver): Código que implementa Circuit Breaker y Bulkhead para servicios externos.
- Fase 4: Implementación de RateLimit — objetivo: Implementar un mecanismo de RateLimit para limitar el número de solicitudes a servicios externos. — entregable (NO resolver): Código que implementa RateLimit para servicios externos.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-reactor</artifactId>
            <version>2.4.0</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot3</artifactId>
            <version>2.4.0</version>
        </dependency>
        <dependency>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-core</artifactId>
        </dependency>
        <dependency>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-test</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/domain/model/Response.java ===
package domain.model;

import java.util.Objects;

public record Response<T>(
        boolean success,
        String message,
        T data,
        String errorCode) {

    public Response {
        Objects.requireNonNull(message, "Message cannot be null");
    }

    public static <T> Response<T> success(T data, String message) {
        return new Response<>(true, message, data, null);
    }

    public static <T> Response<T> failure(String message, String errorCode) {
        return new Response<>(false, message, null, errorCode);
    }

    public boolean isSuccess() {
        return success;
    }
}

// === ARCHIVO: src/main/java/domain/model/RetryConfig.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package domain.model;

import java.time.Duration;
import java.util.Objects;

public record RetryConfig(
        int maxAttempts,
        Duration waitDuration,
        Class<? extends Throwable>[] retryExceptions) {

    public RetryConfig {
        Objects.requireNonNull(waitDuration, "Wait duration cannot be null");
        if (maxAttempts <= 0) {
            throw new IllegalArgumentException("Max attempts must be positive");
        }
        if (retryExceptions == null || retryExceptions.length == 0) {
            throw new IllegalArgumentException("At least one retry exception must be specified");
        }
    }

    public static RetryConfig defaultConfig() {
      throw new UnsupportedOperationException("TODO(reto): defaultConfig");
    }
}

// === ARCHIVO: src/main/java/domain/model/CircuitBreakerConfig.java ===
package domain.model;

import java.time.Duration;
import java.util.Objects;

public record CircuitBreakerConfig(
        int failureRateThreshold,
        Duration waitDurationInOpenState,
        int ringBufferSizeInHalfOpenState,
        int ringBufferSizeInClosedState,
        Class<? extends Throwable>[] recordExceptions,
        Class<? extends Throwable>[] ignoreExceptions) {

    public CircuitBreakerConfig {
        Objects.requireNonNull(waitDurationInOpenState, "Wait duration in open state cannot be null");
        if (failureRateThreshold <= 0 || failureRateThreshold > 100) {
            throw new IllegalArgumentException("Failure rate threshold must be between 1 and 100");
        }
        if (ringBufferSizeInHalfOpenState <= 0 || ringBufferSizeInClosedState <= 0) {
            throw new IllegalArgumentException("Ring buffer sizes must be positive");
        }
        if (recordExceptions == null || recordExceptions.length == 0) {
            throw new IllegalArgumentException("At least one record exception must be specified");
        }
    }

    public static CircuitBreakerConfig defaultConfig() {
        return new CircuitBreakerConfig(
                50,
                Duration.ofSeconds(30),
                10,
                100,
                new Class[]{Exception.class},
                new Class[]{IllegalArgumentException.class}
        );
    }
}

// === ARCHIVO: src/main/java/domain/model/BulkheadConfig.java ===
package domain.model;

import java.util.Objects;

public record BulkheadConfig(
        int maxConcurrentCalls,
        int maxWaitDurationMillis) {

    public BulkheadConfig {
        if (maxConcurrentCalls <= 0) {
            throw new IllegalArgumentException("Max concurrent calls must be positive");
        }
        if (maxWaitDurationMillis < 0) {
            throw new IllegalArgumentException("Max wait duration must be non-negative");
        }
    }

    public static BulkheadConfig defaultConfig() {
        return new BulkheadConfig(
                10,
                5000
        );
    }
}

// === ARCHIVO: src/main/java/domain/model/RateLimiterConfig.java ===
package domain.model;

import java.time.Duration;
import java.util.Objects;

public record RateLimiterConfig(
        int limitForPeriod,
        Duration limitRefreshPeriod,
        int timeoutDurationMillis) {

    public RateLimiterConfig {
        Objects.requireNonNull(limitRefreshPeriod, "Limit refresh period cannot be null");
        if (limitForPeriod <= 0) {
            throw new IllegalArgumentException("Limit for period must be positive");
        }
        if (timeoutDurationMillis < 0) {
            throw new IllegalArgumentException("Timeout duration must be non-negative");
        }
    }

    public static RateLimiterConfig defaultConfig() {
        return new RateLimiterConfig(
                100,
                Duration.ofSeconds(1),
                5000
        );
    }
}

// === ARCHIVO: src/main/java/domain/port/FallbackService.java ===
package domain.port;

import domain.model.Response;
import reactor.core.publisher.Mono;

public interface FallbackService<T> {
    Mono<Response<T>> executeFallback(Throwable throwable);
}

// === ARCHIVO: src/main/java/application/service/RetryService.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application.service;

import domain.model.Response;
import domain.model.RetryConfig;
import domain.port.FallbackService;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig as ResilienceRetryConfig;
import io.github.resilience4j.retry.RetryEvent;
import io.github.resilience4j.reactor.retry.RetryOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Supplier;

@Service
public class RetryService {

    private static final Logger log = LoggerFactory.getLogger(RetryService.class);
    private final FallbackService<?> fallbackService;

    public RetryService(FallbackService<?> fallbackService) {
        this.fallbackService = fallbackService;
    }

    public Mono<Response> executeWithRetry(Supplier<Mono<Response>> operation, int maxRetries, Duration delay) {
      throw new UnsupportedOperationException("TODO(reto): executeWithRetry");
    }

    public Mono<Response> executeWithRetryConfig(Supplier<Mono<Response>> operation, RetryConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithRetryConfig");
    }
}

// === ARCHIVO: src/main/java/infrastructure/adapter/FallbackClient.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.adapter;

import domain.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class FallbackClient {

    private static final Logger log = LoggerFactory.getLogger(FallbackClient.class);
    private static final String FALLBACK_STATUS = "DEGRADED";
    private static final String FALLBACK_MESSAGE = "Service temporarily unavailable. Using fallback response.";

    public Mono<Response> getFallbackResponse() {
      throw new UnsupportedOperationException("TODO(reto): getFallbackResponse");
    }

    public <T> Mono<Response<T>> getFallbackResponseFor(Class<T> dataType) {
      throw new UnsupportedOperationException("TODO(reto): getFallbackResponseFor");
    }
}

// === ARCHIVO: src/main/java/application/service/CircuitBreakerService.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application.service;

import domain.model.CircuitBreakerConfig;
import domain.model.Response;
import domain.port.FallbackService;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerEvent;
import io.github.resilience4j.circuitbreaker.CircuitBreakerState;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Supplier;

@Service
public class CircuitBreakerService {

    private static final Logger log = LoggerFactory.getLogger(CircuitBreakerService.class);
    private final FallbackService<?> fallbackService;

    public CircuitBreakerService(FallbackService<?> fallbackService) {
        this.fallbackService = fallbackService;
    }

    public Mono<Response> executeWithCircuitBreaker(Supplier<Mono<Response>> operation, CircuitBreakerConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithCircuitBreaker");
    }

    public Mono<Response> executeWithCircuitBreakerConfig(Supplier<Mono<Response>> operation,
                                                            domain.model.CircuitBreakerConfig config) {
                                                              throw new UnsupportedOperationException("TODO(reto): executeWithCircuitBreakerConfig");
                                                            }

    private Mono<Response> applyFallback(Throwable error) {
      throw new UnsupportedOperationException("TODO(reto): applyFallback");
    }
}

// === ARCHIVO: src/main/java/application/service/BulkheadService.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application.service;

import domain.model.BulkheadConfig;
import domain.model.Response;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadEvent;
import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.reactor.bulkhead.operator.BulkheadOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Supplier;

@Service
public class BulkheadService {

    private static final Logger log = LoggerFactory.getLogger(BulkheadService.class);

    public Mono<Response> executeWithBulkhead(Supplier<Mono<Response>> operation, BulkheadConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithBulkhead");
    }

    public Mono<Response> executeWithBulkheadConfig(Supplier<Mono<Response>> operation,
                                                      BulkheadConfig config) {
                                                        throw new UnsupportedOperationException("TODO(reto): executeWithBulkheadConfig");
                                                      }
}

// === ARCHIVO: src/main/java/application/service/RateLimiterService.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application.service;

import domain.model.RateLimiterConfig;
import domain.model.Response;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.reactor.ratelimiter.operator.RateLimiterOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Supplier;

public class RateLimiterService {

    private static final Logger log = LoggerFactory.getLogger(RateLimiterService.class);
    private static final String RATE_LIMIT_ERROR_CODE = "RATE_LIMIT_EXCEEDED";
    private static final String RATE_LIMIT_ERROR_MESSAGE = "Too many requests. Please try again later.";

    private final RateLimiterRegistry rateLimiterRegistry;

    public RateLimiterService() {
        this.rateLimiterRegistry = RateLimiterRegistry.of(RateLimiterConfig.custom()
                .limitForPeriod(100)
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .build());
    }

    public Mono<Response> executeWithRateLimit(Supplier<Mono<Response>> operation, RateLimiterConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithRateLimit");
    }

    public Mono<Response> executeWithRateLimitConfig(Supplier<Mono<Response>> operation, RateLimiterConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithRateLimitConfig");
    }

    public Mono<Response> executeWithRateLimit(Supplier<Mono<Response>> operation, int limitForPeriod, Duration limitRefreshPeriod) {
      throw new UnsupportedOperationException("TODO(reto): executeWithRateLimit");
    }
}

// === ARCHIVO: src/main/java/resources/application.yml ===
server:
  port: 8080

spring:
  application:
    name: resiliencia-banca
  profiles:
    active: default

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,circuitbreakers,retry,bulkhead,ratelimiter
  endpoint:
    health:
      show-details: always
  health:
    circuitbreakers:
      enabled: true
    retry:
      enabled: true
    bulkhead:
      enabled: true
    ratelimiter:
      enabled: true

resilience4j:
  retry:
    instances:
      default:
        maxAttempts: 3
        waitDuration: 500ms
        retryExceptions:
          - java.io.IOException
          - java.util.concurrent.TimeoutException
          - org.springframework.web.reactive.function.client.WebClientResponseException$ServiceUnavailable
        enableExponentialBackoff: true
        exponentialBackoffMultiplier: 2
        ignoreExceptions:
          - java.lang.IllegalArgumentException
      paymentService:
        maxAttempts: 5
        waitDuration: 1000ms
        retryExceptions:
          - java.io.IOException
          - java.util.concurrent.TimeoutException
        enableExponentialBackoff: true
        exponentialBackoffMultiplier: 2
      accountService:
        maxAttempts: 3
        waitDuration: 800ms
        retryExceptions:
          - java.io.IOException

  circuitbreaker:
    instances:
      default:
        failureRateThreshold: 50
        waitDurationInOpenState: 30s
        ringBufferSizeInHalfOpenState: 10
        ringBufferSizeInClosedState: 100
        recordExceptions:
          - java.io.IOException
          - java.util.concurrent.TimeoutException
          - org.springframework.web.reactive.function.client.WebClientResponseException
        ignoreExceptions:
          - java.lang.IllegalArgumentException
      paymentService:
        failureRateThreshold: 40
        waitDurationInOpenState: 60s
        ringBufferSizeInHalfOpenState: 15
        ringBufferSizeInClosedState: 200
        recordExceptions:
          - java.io.IOException
          - java.util.concurrent.TimeoutException
      accountService:
        failureRateThreshold: 60
        waitDurationInOpenState: 20s
        ringBufferSizeInHalfOpenState: 8
        ringBufferSizeInClosedState: 50

  bulkhead:
    instances:
      default:
        maxConcurrentCalls: 10
        maxWaitDuration: 5000ms
      paymentService:
        maxConcurrentCalls: 5
        maxWaitDuration: 3000ms
      accountService:
        maxConcurrentCalls: 15
        maxWaitDuration: 8000ms

  ratelimiter:
    instances:
      default:
        limitForPeriod: 100
        limitRefreshPeriod: 1s
        timeoutDuration: 5000ms
      paymentService:
        limitForPeriod: 50
        limitRefreshPeriod: 1s
        timeoutDuration: 3000ms
      accountService:
        limitForPeriod: 200
        limitRefreshPeriod: 1s
        timeoutDuration: 5000ms

logging:
  level:
    root: INFO
    com.example: DEBUG
    io.github.resilience4j: DEBUG
    reactor.netty: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"

app:
  services:
    payment:
      base-url: http://localhost:8081
      timeout: 5000
    account:
      base-url: http://localhost:8082
      timeout: 3000
  fallback:
    enabled: true
    default-message: "Servicio temporalmente no disponible. Por favor, intente más tarde."
    default-status: "UNAVAILABLE"

// === ARCHIVO: src/main/java/Application.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application;

import application.service.RetryService;
import application.service.CircuitBreakerService;
import application.service.BulkheadService;
import application.service.RateLimiterService;
import infrastructure.adapter.FallbackClient;
import domain.model.Response;
import domain.model.RetryConfig;
import domain.model.CircuitBreakerConfig;
import domain.model.BulkheadConfig;
import domain.model.RateLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@RequestMapping("/api/resilience")
public class Application {

    private final RetryService retryService;
    private final CircuitBreakerService circuitBreakerService;
    private final BulkheadService bulkheadService;
    private final RateLimiterService rateLimiterService;
    private final FallbackClient fallbackClient;

    public Application(
            RetryService retryService,
            CircuitBreakerService circuitBreakerService,
            BulkheadService bulkheadService,
            RateLimiterService rateLimiterService,
            FallbackClient fallbackClient) {
        this.retryService = retryService;
        this.circuitBreakerService = circuitBreakerService;
        this.bulkheadService = bulkheadService;
        this.rateLimiterService = rateLimiterService;
        this.fallbackClient = fallbackClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostMapping("/retry")
    public Mono<Response> executeWithRetry(
            @RequestParam(defaultValue = "3") int maxRetries,
            @RequestParam(defaultValue = "500") long delayMs) {
              throw new UnsupportedOperationException("TODO(reto): PostMapping");
            }

    @PostMapping("/retry/config")
    public Mono<Response> executeWithRetryConfig() {
        RetryConfig config = RetryConfig.defaultConfig();
        return retryService.executeWithRetryConfig(
            () -> simulateExternalServiceCall(),
            config
        );
    }

    @PostMapping("/circuit-breaker")
    public Mono<Response> executeWithCircuitBreaker() {
      throw new UnsupportedOperationException("TODO(reto): PostMapping");
    }

    @PostMapping("/bulkhead")
    public Mono<Response> executeWithBulkhead() {
      throw new UnsupportedOperationException("TODO(reto): PostMapping");
    }

    @PostMapping("/rate-limit")
    public Mono<Response> executeWithRateLimit() {
      throw new UnsupportedOperationException("TODO(reto): PostMapping");
    }

    @PostMapping("/fallback")
    public Mono<Response> getFallbackResponse() {
      throw new UnsupportedOperationException("TODO(reto): PostMapping");
    }

    private Mono<Response> simulateExternalServiceCall() {
      throw new UnsupportedOperationException("TODO(reto): simulateExternalServiceCall");
    }
}

// === ARCHIVO: src/main/java/com/example/reto/application/service/RetryService.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package com.example.reto.application.service;

import domain.model.Response;
import domain.model.RetryConfig;
import domain.port.FallbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Supplier;

public class RetryService {

    private static final Logger log = LoggerFactory.getLogger(RetryService.class);
    private final FallbackService<?> fallbackService;

    public RetryService(FallbackService<?> fallbackService) {
        this.fallbackService = fallbackService;
    }

    public Mono<Response> executeWithRetry(
            Supplier<Mono<Response>> operation, 
            int maxRetries, 
            Duration delay) {
              throw new UnsupportedOperationException("TODO(reto): executeWithRetry");
            }

    public Mono<Response> executeWithRetryConfig(
            Supplier<Mono<Response>> operation, 
            RetryConfig config) {
              throw new UnsupportedOperationException("TODO(reto): executeWithRetryConfig");
            }
}

// === ARCHIVO: src/main/java/com/example/reto/application/service/CircuitBreakerService.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package com.example.reto.application.service;

import domain.model.CircuitBreakerConfig;
import domain.model.Response;
import domain.port.FallbackService;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Supplier;

public class CircuitBreakerService {

    private static final Logger log = LoggerFactory.getLogger(CircuitBreakerService.class);
    private final FallbackService<?> fallbackService;

    public CircuitBreakerService(FallbackService<?> fallbackService) {
        this.fallbackService = fallbackService;
    }

    public Mono<Response> executeWithCircuitBreaker(
            Supplier<Mono<Response>> operation, 
            CircuitBreakerConfig config) {
              throw new UnsupportedOperationException("TODO(reto): executeWithCircuitBreaker");
            }

    public Mono<Response> executeWithCircuitBreakerConfig(
            Supplier<Mono<Response>> operation, 
            domain.model.CircuitBreakerConfig config) {
              throw new UnsupportedOperationException("TODO(reto): executeWithCircuitBreakerConfig");
            }

    private Mono<Response> applyFallback(Throwable error) {
      throw new UnsupportedOperationException("TODO(reto): applyFallback");
    }
}

// === ARCHIVO: src/main/java/com/example/reto/application/service/BulkheadService.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package com.example.reto.application.service;

import com.example.reto.domain.model.BulkheadConfig;
import com.example.reto.domain.model.Response;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.github.resilience4j.reactor.bulkhead.operator.BulkheadOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Supplier;

@Service
public class BulkheadService {

    private static final Logger log = LoggerFactory.getLogger(BulkheadService.class);
    private static final String DEFAULT_BULKHEAD_NAME = "defaultBulkhead";

    private final BulkheadRegistry bulkheadRegistry;

    public BulkheadService() {
        this.bulkheadRegistry = BulkheadRegistry.ofDefaults();
    }

    public BulkheadService(BulkheadRegistry bulkheadRegistry) {
        this.bulkheadRegistry = bulkheadRegistry;
    }

    public Mono<Response> executeWithBulkhead(Supplier<Mono<Response>> operation, BulkheadConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithBulkhead");
    }

    public Mono<Response> executeWithBulkheadConfig(Supplier<Mono<Response>> operation, BulkheadConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithBulkheadConfig");
    }

    public Bulkhead getBulkhead(String name) {
        return bulkheadRegistry.bulkhead(name);
    }

    public BulkheadRegistry getBulkheadRegistry() {
        return bulkheadRegistry;
    }

    public void removeBulkhead(String name) {
        bulkheadRegistry.removeBulkhead(name);
    }

    public boolean isBulkheadAvailable(String name) {
      throw new UnsupportedOperationException("TODO(reto): isBulkheadAvailable");
    }

    public int getAvailableConcurrentCalls(String name) {
      throw new UnsupportedOperationException("TODO(reto): getAvailableConcurrentCalls");
    }

    public int getMaxConcurrentCalls(String name) {
      throw new UnsupportedOperationException("TODO(reto): getMaxConcurrentCalls");
    }
}

// === ARCHIVO: src/main/java/com/example/reto/application/service/RateLimiterService.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package com.example.reto.application.service;

import domain.model.RateLimiterConfig;
import domain.model.Response;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.reactor.ratelimiter.operator.RateLimiterOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Supplier;

@Service
public class RateLimiterService {

    private static final Logger log = LoggerFactory.getLogger(RateLimiterService.class);

    public static final String RATE_LIMIT_ERROR_CODE = "RATE_LIMIT_EXCEEDED";
    public static final String RATE_LIMIT_ERROR_MESSAGE = "Se ha excedido el límite de solicitudes permitidas";

    private final RateLimiterRegistry rateLimiterRegistry;

    public RateLimiterService() {
        this.rateLimiterRegistry = RateLimiterRegistry.ofDefaults();
    }

    public RateLimiterService(RateLimiterRegistry rateLimiterRegistry) {
        this.rateLimiterRegistry = rateLimiterRegistry;
    }

    public Mono<Response> executeWithRateLimit(Supplier<Mono<Response>> operation, RateLimiterConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithRateLimit");
    }

    public Mono<Response> executeWithRateLimitConfig(Supplier<Mono<Response>> operation, RateLimiterConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithRateLimitConfig");
    }

    public RateLimiter getRateLimiter(String name) {
        return rateLimiterRegistry.rateLimiter(name);
    }

    public RateLimiterRegistry getRateLimiterRegistry() {
        return rateLimiterRegistry;
    }
}

// === ARCHIVO: src/main/java/com/example/reto/infrastructure/adapter/FallbackClient.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package com.example.reto.infrastructure.adapter;

import domain.model.Response;
import domain.port.FallbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class FallbackClient implements FallbackService<Object> {

    private static final Logger log = LoggerFactory.getLogger(FallbackClient.class);

    private static final String FALLBACK_STATUS = "FALLBACK";
    private static final String FALLBACK_MESSAGE = "Se ejecutó el fallback debido a un error en la operación principal";

    private final Map<String, Object> fallbackDataCache;

    public FallbackClient() {
        this.fallbackDataCache = new HashMap<>();
        initializeFallbackCache();
    }

    private void initializeFallbackCache() {
        fallbackDataCache.put("defaultAccount", createDefaultAccountData());
        fallbackDataCache.put("defaultBalance", createDefaultBalanceData());
        fallbackDataCache.put("defaultTransaction", createDefaultTransactionData());
    }

    private Map<String, Object> createDefaultAccountData() {
        Map<String, Object> account = new HashMap<>();
        account.put("id", "fallback-account-id");
        account.put("status", "ACTIVE");
        account.put("message", "Datos de cuenta desde fallback");
        return account;
    }

    private Map<String, Object> createDefaultBalanceData() {
        Map<String, Object> balance = new HashMap<>();
        balance.put("available", 0.00);
        balance.put("currency", "USD");
        balance.put("message", "Datos de balance desde fallback");
        return balance;
    }

    private Map<String, Object> createDefaultTransactionData() {
        Map<String, Object> transaction = new HashMap<>();
        transaction.put("id", "fallback-tx-id");
        transaction.put("status", "PENDING");
        transaction.put("message", "Datos de transacción desde fallback");
        return transaction;
    }

    @Override
    public Mono<Response<Object>> executeFallback(Throwable throwable) {
      throw new UnsupportedOperationException("TODO(reto): executeFallback");
    }

    public Mono<Response> getFallbackResponse() {
      throw new UnsupportedOperationException("TODO(reto): getFallbackResponse");
    }

    @SuppressWarnings("unchecked")
    public <T> Mono<Response<T>> getFallbackResponseFor(Class<T> dataType) {
      throw new UnsupportedOperationException("TODO(reto): SuppressWarnings");
    }

    private Map<String, Object> createGenericFallbackData(Class<?> dataType) {
        Map<String, Object> genericData = new HashMap<>();
        genericData.put("type", dataType.getSimpleName());
        genericData.put("fallback", true);
        genericData.put("message", "Datos genéricos de fallback");
        return genericData;
    }

    public Mono<Response> getFallbackResponseWithData(String key, Object data) {
      throw new UnsupportedOperationException("TODO(reto): getFallbackResponseWithData");
    }

    public Map<String, Object> getCachedFallbackData(String key) {
        return (Map<String, Object>) fallbackDataCache.get(key);
    }

    public void cacheFallbackData(String key, Object data) {
        fallbackDataCache.put(key, data);
        log.info("Datos de fallback cacheados para clave: {}", key);
    }

    public void clearFallbackCache() {
        fallbackDataCache.clear();
        initializeFallbackCache();
        log.info("Cache de fallback limpiada y reinicializada");
    }
}

// === ARCHIVO: src/main/java/com/example/reto/domain/model/BulkheadConfig.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package com.example.reto.domain.model;

import java.time.Duration;

public record BulkheadConfig(
    int maxConcurrentCalls,
    Duration maxWaitDuration,
    String fallbackMethod
) {
    public static BulkheadConfig defaultConfig() {
      throw new UnsupportedOperationException("TODO(reto): defaultConfig");
    }

    public static BulkheadConfig withDefaults() {
        return defaultConfig();
    }

    public BulkheadConfig withMaxConcurrentCalls(int maxConcurrentCalls) {
        return new BulkheadConfig(
            maxConcurrentCalls,
            this.maxWaitDuration,
            this.fallbackMethod
        );
    }

    public BulkheadConfig withMaxWaitDuration(Duration maxWaitDuration) {
        return new BulkheadConfig(
            this.maxConcurrentCalls,
            maxWaitDuration,
            this.fallbackMethod
        );
    }

    public BulkheadConfig withFallbackMethod(String fallbackMethod) {
        return new BulkheadConfig(
            this.maxConcurrentCalls,
            this.maxWaitDuration,
            fallbackMethod
        );
    }

    public boolean isValid() {
        return maxConcurrentCalls > 0 && maxWaitDuration != null && maxWaitDuration.toMillis() >= 0;
    }

    public String getBulkheadName() {
        return "defaultBulkhead";
    }
}

// === ARCHIVO: src/main/java/com/example/reto/domain/model/Response.java ===
package com.example.reto.domain.model;

public record Response<T>(
    String status,
    T data,
    String message,
    String errorCode,
    boolean success
) {
    public static <T> Response<T> success(T data, String message) {
        return new Response<>("SUCCESS", data, message, null, true);
    }

    public static <T> Response<T> failure(String message, String errorCode) {
        return new Response<>("FAILURE", null, message, errorCode, false);
    }

    public static <T> Response<T> of(T data) {
        return new Response<>("SUCCESS", data, "Operation completed successfully", null, true);
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isFailure() {
        return !success;
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Response<T> withData(T newData) {
        return new Response<>(this.status, newData, this.message, this.errorCode, this.success);
    }

    public Response<T> withMessage(String newMessage) {
        return new Response<>(this.status, this.data, newMessage, this.errorCode, this.success);
    }

    public Response<T> withErrorCode(String newErrorCode) {
        return new Response<>(this.status, this.data, this.message, newErrorCode, this.success);
    }
}

// === ARCHIVO: src/main/java/domain/service/SagaOrchestrator.java ===
package domain.service;

import domain.model.Response;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SagaOrchestrator<T> {

    private final List<SagaStep<T>> steps = new ArrayList<>();
    private final Retry retrySpec;

    public SagaOrchestrator(Retry retrySpec) {
        this.retrySpec = retrySpec;
    }

    public SagaOrchestrator(int maxAttempts, Duration waitDuration) {
        this.retrySpec = Retry.backoff(maxAttempts, waitDuration)
                .filter(throwable -> !(throwable instanceof IllegalArgumentException));
    }

    public SagaOrchestrator<T> addStep(SagaStep<T> step) {
        steps.add(step);
        return this;
    }

    public Mono<Response<T>> execute() {
        return executeStep(0, null);
    }

    private Mono<Response<T>> executeStep(int currentStep, T accumulatedData) {
        if (currentStep >= steps.size()) {
            return Mono.just(Response.success(accumulatedData, "Saga completed successfully"));
        }

        SagaStep<T> step = steps.get(currentStep);
        
        return step.execute(accumulatedData)
                .flatMap(response -> {
                    if (response.isSuccess()) {
                        return executeStep(currentStep + 1, response.data());
                    } else {
                        return compensate(currentStep, accumulatedData, response);
                    }
                })
                .retryWhen(retrySpec)
                .onErrorResume(throwable -> compensate(currentStep, accumulatedData, 
                        Response.failure("Saga failed: " + throwable.getMessage(), "SAGA_ERROR")));
    }

    private Mono<Response<T>> compensate(int failedStep, T originalData, Response<T> errorResponse) {
        if (failedStep == 0) {
            return Mono.just(Response.failure(
                    "Saga compensation failed at step 0: " + errorResponse.message(),
                    "SAGA_COMPENSATION_ERROR"));
        }

        return compensateStep(failedStep - 1, originalData);
    }

    private Mono<Response<T>> compensateStep(int stepIndex, T data) {
        if (stepIndex < 0) {
            return Mono.just(Response.failure("Saga fully compensated", "SAGA_COMPENSATED"));
        }

        SagaStep<T> step = steps.get(stepIndex);
        
        return step.compensate(data)
                .flatMap(compensatedData -> compensateStep(stepIndex - 1, compensatedData))
                .onErrorResume(throwable -> Mono.just(Response.failure(
                        "Compensation failed at step " + stepIndex + ": " + throwable.getMessage(),
                        "COMPENSATION_ERROR")));
    }

    public interface SagaStep<T> {
        Mono<Response<T>> execute(T input);
        Mono<T> compensate(T data);
    }

    public static <T> SagaOrchestrator<T> create(int maxAttempts, long waitDurationMillis) {
        return new SagaOrchestrator<>(maxAttempts, Duration.ofMillis(waitDurationMillis));
    }

    public static <T> SagaOrchestrator<T> create(Retry retrySpec) {
        return new SagaOrchestrator<>(retrySpec);
    }
}
```
