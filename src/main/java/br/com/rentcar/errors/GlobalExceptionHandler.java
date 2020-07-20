package br.com.rentcar.errors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response handleAllExceptions(Exception ex) {
        ErrorResponse errorResponse = getErrorResponse(ex);
        return Response.status(BAD_REQUEST).entity(errorResponse).build();
    }

    private ErrorResponse getErrorResponse(Exception ex) {
        Throwable cause = Optional.ofNullable(ExceptionUtils.getRootCause(ex)).orElse(ex);
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST);
        if (cause instanceof ConstraintViolationException) {
            List<String> errorMessages = ((ConstraintViolationException) cause).getConstraintViolations()
                    .stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
            errorResponse.setErrorMessageList(errorMessages);
        } else if(cause instanceof org.hibernate.exception.ConstraintViolationException) {
            errorResponse.setErrorMessageList(Collections.singletonList(cause.getLocalizedMessage()));
        } else if (cause instanceof DataIntegrityViolationException || cause instanceof org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException) {
            errorResponse.setErrorMessageList(Collections.singletonList("Duplicate data"));
        } else {
            errorResponse.setErrorMessageList(Collections.singletonList(ex.getMessage()));
        }

        return errorResponse;
    }
}
