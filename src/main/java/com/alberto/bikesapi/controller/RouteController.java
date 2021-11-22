package com.alberto.bikesapi.controller;

import com.alberto.bikesapi.domain.Route;
import com.alberto.bikesapi.domain.dto.RouteDTO;
import com.alberto.bikesapi.exception.BikeNotFoundException;
import com.alberto.bikesapi.exception.ErrorResponse;
import com.alberto.bikesapi.exception.RouteNotFoundException;
import com.alberto.bikesapi.exception.UserNotFoundException;
import com.alberto.bikesapi.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/routes")
    //enviamos un parametro como parte de la URL
    //con el requestParam puedo asignar un nombre y que no se vea el nombre real del codigo en la dirección
    //doy un valor por defecto y sino que busque por el parametro que le indico.
    public List<Route> getRoutesByBikeId(@RequestParam(name = "bike", defaultValue = "0") long bikeId) throws BikeNotFoundException{
        List<Route> routes;

        if( bikeId == 0){
            routes = routeService.findAllRoute();
        } else {
            routes = routeService.findAllRouteByBike(bikeId);
        }
        return routes;
    }

    @GetMapping("/route/{id}")
    //PathVariable el parámetro forman parte de la propia URL
    public Route getRoute(@PathVariable long id) throws RouteNotFoundException {
        Route route = routeService.findRoute(id);
        return route;
    }

//    //borrar una Bici y enseñar que bici se ha borrado
//    @DeleteMapping("/bike/{id}")
//    public Bike removeBike(@PathVariable long id) throws BikeNotFoundException {
//        Bike bike = bikeService.removeBike(id);
//        return bike;
//    }

    //registrar una ruta
    //Debemos pasar los datos, como añadimos datos en una operación, debemos convertirlo en un cuerpo de la llamada
    //para ello utilizamos un RequestBody
    //cuando yo le digo que le envío un objeto java, lo que hacemos es enviarle un json en el postman en body>raw>json
    //y escribo el objeto que quiero registrar
    //El parámetro aquí es un objeto y lo enviamos como un json
    /*En este caso como no quiero jugar con el objeto completo, porque se relaciona con las demás no le vamos a pasar
    todos los objetos completos, porque son los 4 atributos de la ruta y la bici completa y el usuario completo.
    Aquí entra el concepto DTO, es un objeto que me va a servir para enviar o recibir información de una manera más compacta
    lo creamos dentro del domain Data Transfer Object (DTO (objeto de transferencia de datos)) pasar toda esta información sin
    acotarlo crea bucles infinitos de información que transpasan un json enorme por eso creamos el DTO
    a mi RequestBody me devolvera un RouteDTO
     */
    @PostMapping("/routes")
    public Route addRoute(@RequestBody RouteDTO routeDto) throws UserNotFoundException, BikeNotFoundException {
        return routeService.addRoute(routeDto);
    }

//    //en este caso que tambien enviamos un parámetro en un requestBody, tambien tenemos que enviar la informacion en un json.
//    //con el metodo put en postman tengo que enviar el objeto aunque solo modifique un atributo, put modifica el objeto
//    //para modificar un solo atributo patch
//    //Enviamos un parámetro como objeto y otro que forma parte de la propia dirección
//    @PutMapping("/bike/{id}")
//    public Bike modifyBike(@RequestBody Bike bike, @PathVariable long id) throws BikeNotFoundException {
//        Bike newBike = bikeService.modifyBike(id, bike);
//        return newBike;
//    }

    //creo también un método que capture la excepción y la devuelve un poco más elegante
    @ExceptionHandler(RouteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRouteNotFoundException(RouteNotFoundException rnfe){
        ErrorResponse errorResponse = new ErrorResponse("404", rnfe.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //TODO mas tipos de excepciones que puedan gernerar errores.

    //Esta excepción genérica me sirve para controlar culquier excepción que yo no haya pensado y controlado.
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException (Exception exception){
        ErrorResponse errorResponse = new ErrorResponse("999", "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
