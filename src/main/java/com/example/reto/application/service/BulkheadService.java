// TODO(reto): archivo stubbeado; implementa los cuerpos.
package com.example.reto.application.service;

import com.example.reto.domain.model.BulkheadConfig;
import com.example.reto.domain.model.Response;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
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
    private static final String DEFAULT_BULKHEAD_NAME = "defaultBulkhead";

    private final BulkheadRegistry bulkheadRegistry;

    public BulkheadService() {
        this.bulkheadRegistry = BulkheadRegistry.ofDefaults();
    }

    public BulkheadService(BulkheadRegistry bulkheadRegistry) {
        this.bulkheadRegistry = bulkheadRegistry;
    }

    public Mono<Response> executeWithBulkhead(Supplier<Mono<Response>> operation, BulkheadConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithBulkhead");
    }

    public Mono<Response> executeWithBulkheadConfig(Supplier<Mono<Response>> operation, BulkheadConfig config) {
      throw new UnsupportedOperationException("TODO(reto): executeWithBulkheadConfig");
    }

    public Bulkhead getBulkhead(String name) {
        return bulkheadRegistry.bulkhead(name);
    }

    public BulkheadRegistry getBulkheadRegistry() {
        return bulkheadRegistry;
    }

    public void removeBulkhead(String name) {
        bulkheadRegistry.removeBulkhead(name);
    }

    public boolean isBulkheadAvailable(String name) {
      throw new UnsupportedOperationException("TODO(reto): isBulkheadAvailable");
    }

    public int getAvailableConcurrentCalls(String name) {
      throw new UnsupportedOperationException("TODO(reto): getAvailableConcurrentCalls");
    }

    public int getMaxConcurrentCalls(String name) {
      throw new UnsupportedOperationException("TODO(reto): getMaxConcurrentCalls");
    }
}