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