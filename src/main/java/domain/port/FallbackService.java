package domain.port;

import domain.model.Response;
import reactor.core.publisher.Mono;

public interface FallbackService<T> {
    Mono<Response<T>> executeFallback(Throwable throwable);
}