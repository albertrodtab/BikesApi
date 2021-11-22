package com.alberto.bikesapi.repository;

import com.alberto.bikesapi.domain.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {


    List<Route> findAll();


}
