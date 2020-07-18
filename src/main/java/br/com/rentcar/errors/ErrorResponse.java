package br.com.rentcar.errors;

import io.jsonwebtoken.lang.Collections;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

    private HttpStatus status;
    private Integer errorCode;
    private List<String> errorMessageList;
    private LocalDateTime atTime;

    public ErrorResponse(HttpStatus status) {
        this.status = status;
        this.errorCode = status.value();
        this.errorMessageList = new ArrayList<>();
        this.atTime = LocalDateTime.now(ZoneOffset.UTC);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getErrorMessageList() {
        return errorMessageList;
    }

    public void setErrorMessageList(List<String> message) {
        this.errorMessageList = message;
    }

    public LocalDateTime getAtTime() {
        return atTime;
    }

    private void setAtTime(LocalDateTime atTime) {
        this.atTime = atTime;
    }
}
