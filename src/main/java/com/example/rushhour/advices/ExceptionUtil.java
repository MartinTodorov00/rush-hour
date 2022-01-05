package com.example.rushhour.advices;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExceptionUtil {

    private ExceptionUtil() {
    }

    public static Map<String, Object> getBody(Exception exception, HttpStatus httpStatus) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", httpStatus.value());
        body.put("message", exception.getMessage());


        return body;
    }
}