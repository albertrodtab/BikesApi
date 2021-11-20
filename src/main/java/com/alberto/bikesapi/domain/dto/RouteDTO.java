package com.alberto.bikesapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RouteDTO {

    /*
    Es una especie de clon de la ruta pero no tiene correspondencia con la base de datos solo sirve para definir
    como quiero mostrar mis datos de una forma acotada
    Así envio los campos de la ruta y dos campas a mayores que me serviran para saber con que bici y usuario está relacionada.
    */
    //debo indicarle en que formato voy a introducir las fechas7
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate endDate;
    private int kilometers;
    private long user;
    private long bike;
}
