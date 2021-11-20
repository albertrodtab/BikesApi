package com.alberto.bikesapi.exception;

public class RouteNotFoundException extends Exception {

    private static final String DEFAULT_ERROR_MESSAGE = "Route not found";

    //hago dos metodos uno para poder pasar un mensaje y otro que no pasa un mensaje por defecto.
    public RouteNotFoundException (String message) {
        super(message);
    }

    public RouteNotFoundException() {
        super(DEFAULT_ERROR_MESSAGE);
    }
}
