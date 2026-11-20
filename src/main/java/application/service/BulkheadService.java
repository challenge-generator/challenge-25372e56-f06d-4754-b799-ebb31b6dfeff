// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application.service;

import domain.model.BulkheadConfig;
import domain.model.Response;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadEvent;
import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.reactor.bulkhead.operator.BulkheadOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Supplier;

@Service
public class BulkheadService {

    private static final Logger log = LoggerFactory.getLogger(BulkheadService.class);

    public Mono<Response> executeWithBulkhead(Supplier<Mono<Response>> operation, BulkheadConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithBulkhead");
    }

    public Mono<Response> executeWithBulkheadConfig(Supplier<Mono<Response>> operation,
                                                      BulkheadConfig config) {
                                                        throw new UnsupportedOperationException("TODO(reto): executeWithBulkheadConfig");
                                                      }
}