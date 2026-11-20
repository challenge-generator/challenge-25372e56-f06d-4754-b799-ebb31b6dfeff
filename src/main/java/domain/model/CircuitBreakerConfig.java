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