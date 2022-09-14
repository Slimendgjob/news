package com.news.news.exception;

public class BaseException extends RuntimeException {

    private String path;
    private String message;

    private BaseException(String path, String message) {
        this.path = path;
        this.message = message;
    }

    public static BaseException notFoundWithId(String path, Long id) {
        return new BaseException(path, String.format("not found with id=%s", id));
    }

    public String getPath() {
        return path;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
