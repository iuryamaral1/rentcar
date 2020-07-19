package br.com.rentcar.errors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex) {
        ErrorResponse errorResponse = getErrorResponse(ex);
        return new ResponseEntity < > (errorResponse, HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse getErrorResponse(Exception ex) {
        Throwable cause = Optional.ofNullable(ExceptionUtils.getRootCause(ex)).orElse(ex);
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST);
        if (cause instanceof ConstraintViolationException) {
            List<String> errorMessages = ((ConstraintViolationException) cause).getConstraintViolations()
                    .stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
            errorResponse.setErrorMessageList(errorMessages);
        } else {
            errorResponse.setErrorMessageList(Collections.singletonList(ex.getMessage()));
        }

        return errorResponse;
    }
}
