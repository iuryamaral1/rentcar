package br.com.rentcar.exceptions;

public class LoginAlreadyExistException extends Exception {

    public LoginAlreadyExistException() {
        super("Login already exist!");
    }
}
