package com.example.demo.exception;

public class MissingRequestParameterException extends BadRequestException {

    public static final String MISSING_PARAMETER_MESSAGE = " parameter is required";

    public MissingRequestParameterException(String parameter) {
        super(parameter + MISSING_PARAMETER_MESSAGE);
    }
}
