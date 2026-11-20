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