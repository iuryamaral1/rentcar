package br.com.rentcar.dto;

import br.com.rentcar.errors.ErrorResponse;

import java.util.List;

public abstract class OutputDto {

    private List<ErrorResponse> errors;

    public List<ErrorResponse> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorResponse> errors) {
        this.errors = errors;
    }
}
