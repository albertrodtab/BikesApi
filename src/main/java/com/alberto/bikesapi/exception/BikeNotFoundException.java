package com.alberto.bikesapi.exception;

public class BikeNotFoundException extends Exception {

    private static final String DEFAULT_ERROR_MESSAGE = "Bike not found";

    //hago dos metodos uno para poder pasar un mensaje y otro que no pasa ningún mensaje pero que no es lo habitual
    public BikeNotFoundException (String message) {
        super(message);
    }

    public BikeNotFoundException() {
        super(DEFAULT_ERROR_MESSAGE);
    }


}

