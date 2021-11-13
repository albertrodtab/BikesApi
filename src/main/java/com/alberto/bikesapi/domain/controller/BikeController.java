package com.alberto.bikesapi.domain.controller;

import com.alberto.bikesapi.domain.Bike;
import com.alberto.bikesapi.domain.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/bikes")
    //enviamos un parametro como parte de la URL
    //con el requestParam puedo asignar un nombre y que no se vea el nombre real del codigo en la dirección
    //doy un valor por defecto y sino que busque por el parametro que le indico.
    public List<Bike> getBikesByStationId(@RequestParam(name = "station", defaultValue = "0") int stationId){
        List<Bike> bikes;

        if( stationId == 0){
            bikes =bikeService.findAllBikes();
        } else {
            bikes = bikeService.findAllBikes(stationId);
        }
        return bikes;
    }

    @GetMapping("/bike/{id}")
    //PathVariable el parámetro forman parte de la propia URL
    public Bike getBike(@PathVariable long id){
        Bike bike = bikeService.findBike(id);
        return bike;
    }

    //borrar una Bici y enseñar que bici se ha borrado
    @DeleteMapping("/bike/{id}")
    public Bike removeBike(@PathVariable long id){
        Bike bike = bikeService.removeBike(id);
        return bike;
    }

    //registrar una bici
    //Debemos pasar los datos, como añadimos datos en una operación, debemos convertirlo en un cuerpo de la llamada
    //para ello utilizamos un RequestBody
    //cuando yo le digo que le envío un objeto java, lo que hacemos es enviarle un json en el postman en body>raw>json
    //y escribo el objeto que quiero registrar
    //El parámetro aquí es un objeto y lo enviamos como un json
    @PostMapping("/bikes")
    public Bike addBike(@RequestBody Bike bike){
        Bike newBike = bikeService.addBike(bike);
        return newBike;
    }

    //en este caso que tambien enviamos un parámetro en un requestBody, tambien tenemos que enviar la informacion en un json.
    //con el metodo put en postman tengo que enviar el objeto aunque solo modifique un atributo, put modifica el objeto
    //para modificar un solo atributo patch
    //Enviamos un parámetro como objeto y otro que forma parte de la propia dirección
    @PutMapping("/bike/{id}")
    public Bike modifyBike(@RequestBody Bike bike, @PathVariable long id){
        Bike newBike = bikeService.modifyBike(id, bike);
        return newBike;
    }


}
