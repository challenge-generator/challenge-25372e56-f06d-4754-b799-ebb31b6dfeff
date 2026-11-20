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