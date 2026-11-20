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