package com.alberto.bikesapi.service;

import com.alberto.bikesapi.domain.Bike;
import com.alberto.bikesapi.exception.BikeNotFoundException;

import java.util.List;

public interface BikeService {

    List<Bike> findAllBikes();
    List<Bike> findAllBikes(int stationId);
    Bike findBike(long id) throws BikeNotFoundException;
    void repairBike(Bike bike);

    Bike removeBike(long id) throws BikeNotFoundException;

    Bike addBike(Bike bike);

    Bike modifyBike(long id, Bike bike) throws BikeNotFoundException;
}
