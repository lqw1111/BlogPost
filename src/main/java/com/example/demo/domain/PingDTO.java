package com.example.demo.domain;

import java.util.Objects;

public class PingDTO {
    private boolean success;

    public PingDTO(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PingDTO pingDTO = (PingDTO) o;
        return success == pingDTO.success;
    }

    @Override
    public int hashCode() {

        return Objects.hash(success);
    }
}
