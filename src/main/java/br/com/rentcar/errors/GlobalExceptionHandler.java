package br.com.rentcar.errors;

import br.com.rentcar.exceptions.EmailAlreadyExistException;
import br.com.rentcar.exceptions.LoginAlreadyExistException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex) {
        List<String> errorMessages = getErrorMessages(ex);
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST);
        errorResponse.setErrorMessageList(errorMessages);
        return new ResponseEntity < > (errorResponse, HttpStatus.BAD_REQUEST);
    }

    private List<String> getErrorMessages(Exception ex) {
        List<String> errorMessageList = new ArrayList<>();
        Throwable cause = Optional.ofNullable(ExceptionUtils.getRootCause(ex)).orElse(ex);
        if (cause instanceof ConstraintViolationException) {
            errorMessageList = ((ConstraintViolationException) cause).getConstraintViolations()
                .stream().map(ConstraintViolation::getIn)
                .collect(Collectors.toList());
        } if (cause instanceof LoginAlreadyExistException) {
            errorMessageList = Collections.singletonList(cause.getMessage());
        } if (cause instanceof EmailAlreadyExistException) {
            errorMessageList = Collections.singletonList(cause.getMessage());
        } else {
            errorMessageList = Collections.singletonList(ex.getLocalizedMessage());
        }

        return errorMessageList;
    }
}
