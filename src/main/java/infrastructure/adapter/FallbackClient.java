// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.adapter;

import domain.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class FallbackClient {

    private static final Logger log = LoggerFactory.getLogger(FallbackClient.class);
    private static final String FALLBACK_STATUS = "DEGRADED";
    private static final String FALLBACK_MESSAGE = "Service temporarily unavailable. Using fallback response.";

    public Mono<Response> getFallbackResponse() {
      throw new UnsupportedOperationException("TODO(reto): getFallbackResponse");
    }

    public <T> Mono<Response<T>> getFallbackResponseFor(Class<T> dataType) {
      throw new UnsupportedOperationException("TODO(reto): getFallbackResponseFor");
    }
}