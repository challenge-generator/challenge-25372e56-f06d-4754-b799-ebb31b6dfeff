// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application.service;

import domain.model.RateLimiterConfig;
import domain.model.Response;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.reactor.ratelimiter.operator.RateLimiterOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Supplier;

public class RateLimiterService {

    private static final Logger log = LoggerFactory.getLogger(RateLimiterService.class);
    private static final String RATE_LIMIT_ERROR_CODE = "RATE_LIMIT_EXCEEDED";
    private static final String RATE_LIMIT_ERROR_MESSAGE = "Too many requests. Please try again later.";

    private final RateLimiterRegistry rateLimiterRegistry;

    public RateLimiterService() {
        this.rateLimiterRegistry = RateLimiterRegistry.of(RateLimiterConfig.custom()
                .limitForPeriod(100)
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .build());
    }

    public Mono<Response> executeWithRateLimit(Supplier<Mono<Response>> operation, RateLimiterConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithRateLimit");
    }

    public Mono<Response> executeWithRateLimitConfig(Supplier<Mono<Response>> operation, RateLimiterConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithRateLimitConfig");
    }

    public Mono<Response> executeWithRateLimit(Supplier<Mono<Response>> operation, int limitForPeriod, Duration limitRefreshPeriod) {
      throw new UnsupportedOperationException("TODO(reto): executeWithRateLimit");
    }
}