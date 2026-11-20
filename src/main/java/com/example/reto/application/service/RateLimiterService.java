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