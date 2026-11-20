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