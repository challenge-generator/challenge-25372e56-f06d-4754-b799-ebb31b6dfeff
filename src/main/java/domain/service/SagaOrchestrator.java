package domain.service;

import domain.model.Response;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SagaOrchestrator<T> {

    private final List<SagaStep<T>> steps = new ArrayList<>();
    private final Retry retrySpec;

    public SagaOrchestrator(Retry retrySpec) {
        this.retrySpec = retrySpec;
    }

    public SagaOrchestrator(int maxAttempts, Duration waitDuration) {
        this.retrySpec = Retry.backoff(maxAttempts, waitDuration)
                .filter(throwable -> !(throwable instanceof IllegalArgumentException));
    }

    public SagaOrchestrator<T> addStep(SagaStep<T> step) {
        steps.add(step);
        return this;
    }

    public Mono<Response<T>> execute() {
        return executeStep(0, null);
    }

    private Mono<Response<T>> executeStep(int currentStep, T accumulatedData) {
        if (currentStep >= steps.size()) {
            return Mono.just(Response.success(accumulatedData, "Saga completed successfully"));
        }

        SagaStep<T> step = steps.get(currentStep);
        
        return step.execute(accumulatedData)
                .flatMap(response -> {
                    if (response.isSuccess()) {
                        return executeStep(currentStep + 1, response.data());
                    } else {
                        return compensate(currentStep, accumulatedData, response);
                    }
                })
                .retryWhen(retrySpec)
                .onErrorResume(throwable -> compensate(currentStep, accumulatedData, 
                        Response.failure("Saga failed: " + throwable.getMessage(), "SAGA_ERROR")));
    }

    private Mono<Response<T>> compensate(int failedStep, T originalData, Response<T> errorResponse) {
        if (failedStep == 0) {
            return Mono.just(Response.failure(
                    "Saga compensation failed at step 0: " + errorResponse.message(),
                    "SAGA_COMPENSATION_ERROR"));
        }

        return compensateStep(failedStep - 1, originalData);
    }

    private Mono<Response<T>> compensateStep(int stepIndex, T data) {
        if (stepIndex < 0) {
            return Mono.just(Response.failure("Saga fully compensated", "SAGA_COMPENSATED"));
        }

        SagaStep<T> step = steps.get(stepIndex);
        
        return step.compensate(data)
                .flatMap(compensatedData -> compensateStep(stepIndex - 1, compensatedData))
                .onErrorResume(throwable -> Mono.just(Response.failure(
                        "Compensation failed at step " + stepIndex + ": " + throwable.getMessage(),
                        "COMPENSATION_ERROR")));
    }

    public interface SagaStep<T> {
        Mono<Response<T>> execute(T input);
        Mono<T> compensate(T data);
    }

    public static <T> SagaOrchestrator<T> create(int maxAttempts, long waitDurationMillis) {
        return new SagaOrchestrator<>(maxAttempts, Duration.ofMillis(waitDurationMillis));
    }

    public static <T> SagaOrchestrator<T> create(Retry retrySpec) {
        return new SagaOrchestrator<>(retrySpec);
    }
}