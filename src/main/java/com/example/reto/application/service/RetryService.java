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