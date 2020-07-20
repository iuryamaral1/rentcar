package br.com.rentcar.exceptions;

public class EmailAlreadyExistException extends Exception {

    public EmailAlreadyExistException() {
        super("Email Already Exists!");
    }
}
