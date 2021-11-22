package com.alberto.bikesapi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long routeId;
    @Column(name = "start_date")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate startDate;
    @Column(name = "end_date")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate endDate;
    @Column
    private int kilometers;

    //Debemos establecer como se relaciona ruta con los usuarios y las bicis
    //Indicamos el tipo de relación, 1 routas solo tendrán asociada una bici, pero un bici puede tener n rutas
    // por eso es ManyToOne porque route es el lado n
    @ManyToOne
    //indica la columa por la que estaran relacionada que tendra la clave ajena bike_id
    @JoinColumn(name = "bike_id")
    //para evitar el bucle de que asocie rutas a bicis y sea algo infinito añadimos @JsonBackReference
    @JsonBackReference
    private Bike bike;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}
