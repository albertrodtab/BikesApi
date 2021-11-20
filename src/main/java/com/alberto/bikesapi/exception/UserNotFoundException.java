package com.alberto.bikesapi.exception;

public class UserNotFoundException extends Exception {

    private static final String DEFAULT_ERROR_MESSAGE = "User not found";

    //hago dos metodos uno para poder pasar un mensaje y otro que no pasa un mensaje por defecto.
    public UserNotFoundException (String message) {
        super(message);
    }

    public UserNotFoundException() {
        super(DEFAULT_ERROR_MESSAGE);
    }
}
