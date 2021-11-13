package com.alberto.bikesapi.domain.service;

import com.alberto.bikesapi.domain.Bike;

import java.util.List;

public interface BikeService {

    List<Bike> findAllBikes();
    List<Bike> findAllBikes(int stationId);
    Bike findBike(long id);
    void repairBike(Bike bike);

    Bike removeBike(long id);

    Bike addBike(Bike bike);

    Bike modifyBike(long id, Bike bike);
}
