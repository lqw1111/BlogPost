package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.util.Objects;

public class ApiError {
    private HttpStatus status;
    private String error;

    public ApiError(HttpStatus status, String error) {
        this.status = status;
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiError apiError = (ApiError) o;
        return status == apiError.status &&
                Objects.equals(error, apiError.error);
    }

    @Override
    public int hashCode() {

        return Objects.hash(status, error);
    }
}
