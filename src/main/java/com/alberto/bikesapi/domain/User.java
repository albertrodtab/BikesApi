package com.alberto.bikesapi.domain;

import com.alberto.bikesapi.service.BikeService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String dni;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(name = "birth_date")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDate;

    //1 usuario n rutas, pero 1 ruta solo con 1 usuario.
    @OneToMany(mappedBy = "user")
    private List<Route> routes;


}
