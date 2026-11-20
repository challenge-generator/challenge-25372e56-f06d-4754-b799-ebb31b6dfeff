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