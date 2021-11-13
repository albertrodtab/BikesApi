package com.alberto.bikesapi.repository;

import com.alberto.bikesapi.domain.Bike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends CrudRepository<Bike, Long> {


    List<Bike> findAll();
    List<Bike> findByBabyChair(Boolean babyChair);
    List<Bike> findByBatteryGreaterThan(int battery);
    List<Bike> findByStationId(int StationId);

}
