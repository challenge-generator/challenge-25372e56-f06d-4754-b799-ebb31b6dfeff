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