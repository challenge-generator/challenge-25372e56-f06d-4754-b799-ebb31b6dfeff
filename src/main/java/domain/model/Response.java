package domain.model;

import java.util.Objects;

public record Response<T>(
        boolean success,
        String message,
        T data,
        String errorCode) {

    public Response {
        Objects.requireNonNull(message, "Message cannot be null");
    }

    public static <T> Response<T> success(T data, String message) {
        return new Response<>(true, message, data, null);
    }

    public static <T> Response<T> failure(String message, String errorCode) {
        return new Response<>(false, message, null, errorCode);
    }

    public boolean isSuccess() {
        return success;
    }
}