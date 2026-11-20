package com.example.reto.domain.model;

public record Response<T>(
    String status,
    T data,
    String message,
    String errorCode,
    boolean success
) {
    public static <T> Response<T> success(T data, String message) {
        return new Response<>("SUCCESS", data, message, null, true);
    }

    public static <T> Response<T> failure(String message, String errorCode) {
        return new Response<>("FAILURE", null, message, errorCode, false);
    }

    public static <T> Response<T> of(T data) {
        return new Response<>("SUCCESS", data, "Operation completed successfully", null, true);
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isFailure() {
        return !success;
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Response<T> withData(T newData) {
        return new Response<>(this.status, newData, this.message, this.errorCode, this.success);
    }

    public Response<T> withMessage(String newMessage) {
        return new Response<>(this.status, this.data, newMessage, this.errorCode, this.success);
    }

    public Response<T> withErrorCode(String newErrorCode) {
        return new Response<>(this.status, this.data, this.message, newErrorCode, this.success);
    }
}