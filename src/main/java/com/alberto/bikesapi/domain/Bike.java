package com.alberto.bikesapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bikes")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private boolean available;
    @Column
    private int kilometers;
    @Column
    private int battery;
    @Column(name = "baby_chair")
    private boolean babyChair;
    @Column(name = "station_id")
    private int stationId;

    //como ya está relacionado en el otro lado aquí solo indico por que objeto tiene mapearse
    // 1 bici varias rutas, pero 1 ruta solo 1 bici
    @OneToMany(mappedBy = "bike")
    private List<Route> routes;
}
