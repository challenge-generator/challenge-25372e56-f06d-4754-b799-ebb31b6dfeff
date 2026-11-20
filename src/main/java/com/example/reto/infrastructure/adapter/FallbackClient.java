// TODO(reto): archivo stubbeado; implementa los cuerpos.
package com.example.reto.infrastructure.adapter;

import domain.model.Response;
import domain.port.FallbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class FallbackClient implements FallbackService<Object> {

    private static final Logger log = LoggerFactory.getLogger(FallbackClient.class);

    private static final String FALLBACK_STATUS = "FALLBACK";
    private static final String FALLBACK_MESSAGE = "Se ejecutó el fallback debido a un error en la operación principal";

    private final Map<String, Object> fallbackDataCache;

    public FallbackClient() {
        this.fallbackDataCache = new HashMap<>();
        initializeFallbackCache();
    }

    private void initializeFallbackCache() {
        fallbackDataCache.put("defaultAccount", createDefaultAccountData());
        fallbackDataCache.put("defaultBalance", createDefaultBalanceData());
        fallbackDataCache.put("defaultTransaction", createDefaultTransactionData());
    }

    private Map<String, Object> createDefaultAccountData() {
        Map<String, Object> account = new HashMap<>();
        account.put("id", "fallback-account-id");
        account.put("status", "ACTIVE");
        account.put("message", "Datos de cuenta desde fallback");
        return account;
    }

    private Map<String, Object> createDefaultBalanceData() {
        Map<String, Object> balance = new HashMap<>();
        balance.put("available", 0.00);
        balance.put("currency", "USD");
        balance.put("message", "Datos de balance desde fallback");
        return balance;
    }

    private Map<String, Object> createDefaultTransactionData() {
        Map<String, Object> transaction = new HashMap<>();
        transaction.put("id", "fallback-tx-id");
        transaction.put("status", "PENDING");
        transaction.put("message", "Datos de transacción desde fallback");
        return transaction;
    }

    @Override
    public Mono<Response<Object>> executeFallback(Throwable throwable) {
      throw new UnsupportedOperationException("TODO(reto): executeFallback");
    }

    public Mono<Response> getFallbackResponse() {
      throw new UnsupportedOperationException("TODO(reto): getFallbackResponse");
    }

    @SuppressWarnings("unchecked")
    public <T> Mono<Response<T>> getFallbackResponseFor(Class<T> dataType) {
      throw new UnsupportedOperationException("TODO(reto): SuppressWarnings");
    }

    private Map<String, Object> createGenericFallbackData(Class<?> dataType) {
        Map<String, Object> genericData = new HashMap<>();
        genericData.put("type", dataType.getSimpleName());
        genericData.put("fallback", true);
        genericData.put("message", "Datos genéricos de fallback");
        return genericData;
    }

    public Mono<Response> getFallbackResponseWithData(String key, Object data) {
      throw new UnsupportedOperationException("TODO(reto): getFallbackResponseWithData");
    }

    public Map<String, Object> getCachedFallbackData(String key) {
        return (Map<String, Object>) fallbackDataCache.get(key);
    }

    public void cacheFallbackData(String key, Object data) {
        fallbackDataCache.put(key, data);
        log.info("Datos de fallback cacheados para clave: {}", key);
    }

    public void clearFallbackCache() {
        fallbackDataCache.clear();
        initializeFallbackCache();
        log.info("Cache de fallback limpiada y reinicializada");
    }
}