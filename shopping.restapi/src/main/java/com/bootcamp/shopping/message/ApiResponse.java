package com.bootcamp.shopping.message;

public class ApiResponse {
    private String message;
    private String error;
    private Object content;

    public ApiResponse(String message, Object content) {
        this.message = message;
        this.content = content;
    }

    public ApiResponse(String message, String error) {
        this.message = message;
        this.error = error;
    }
}
