package com.alberto.bikesapi.service;

import com.alberto.bikesapi.domain.Route;
import com.alberto.bikesapi.domain.User;
import com.alberto.bikesapi.domain.dto.RouteDTO;
import com.alberto.bikesapi.exception.BikeNotFoundException;
import com.alberto.bikesapi.exception.RouteNotFoundException;
import com.alberto.bikesapi.exception.UserNotFoundException;

import java.util.List;

public interface RouteService {

    List<Route> findAllRoute();
    List<Route> findAllRouteByBike(long bikeId) throws BikeNotFoundException;
    List<Route> findAllRouteByUser(long userId) throws UserNotFoundException;

    Route findRoute(long id) throws RouteNotFoundException;


    Route removeRoute(long id) throws RouteNotFoundException;

    Route addRoute(RouteDTO routeDto) throws UserNotFoundException, BikeNotFoundException;

    Route modifyRoute(long id, Route route) throws RouteNotFoundException;
}
