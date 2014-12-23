package me.karun.models;

import com.google.gson.Gson;

public class Response {
    private final int code;
    private final String message;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
