package com.alberto.bikesapi.service;

import com.alberto.bikesapi.domain.Bike;
import com.alberto.bikesapi.exception.BikeNotFoundException;
import com.alberto.bikesapi.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public List<Bike> findAllBikes() {
        return bikeRepository.findAll();
    }

    @Override
    public List<Bike> findAllBikes(int stationId) {
        return bikeRepository.findByStationId(stationId);
    }

    @Override
    public Bike findBike(long id) throws BikeNotFoundException{
       return bikeRepository.findById(id)
               .orElseThrow(BikeNotFoundException::new);
    }

    @Override
    public void repairBike(Bike bike) {

    }

    @Override
    // primero busco el objeto que quiero borrar, paso el objeto al metodo delete y devuelvo el objeto borrado
    public Bike removeBike(long id) throws BikeNotFoundException{
        Bike bike = bikeRepository.findById(id)
              .orElseThrow(BikeNotFoundException::new);
        bikeRepository.delete(bike);
        return bike;
    }

    @Override
    // muy facil por que existe ya el metodo guardar
    public Bike addBike(Bike bike) {
        return bikeRepository.save(bike);
    }

    @Override
    //este es un poco mas complicado
    //me hago con la bice, modifico la información y devuelvo y guardo la bici en el repositorio
        public Bike modifyBike(long id, Bike newBike) throws BikeNotFoundException{
        Bike bike = bikeRepository.findById(id)
                .orElseThrow(BikeNotFoundException::new);
        bike.setAvailable(newBike.isAvailable());
        bike.setBabyChair((newBike.isBabyChair()));
        bike.setBattery(newBike.getBattery());
        bike.setKilometers(newBike.getKilometers());
        bike.setStationId(newBike.getStationId());
        return bikeRepository.save(bike);
    }
}
