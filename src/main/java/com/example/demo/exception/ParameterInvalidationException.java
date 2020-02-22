package com.example.demo.exception;

public class ParameterInvalidationException extends BadRequestException {

    public static final String MESSAGE = " parameter is invalid";

    public ParameterInvalidationException(String parameter) {
        super(parameter + MESSAGE);
    }
}
