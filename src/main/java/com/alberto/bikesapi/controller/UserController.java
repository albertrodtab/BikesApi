package com.alberto.bikesapi.controller;

import com.alberto.bikesapi.domain.Bike;
import com.alberto.bikesapi.domain.User;
import com.alberto.bikesapi.exception.BikeNotFoundException;
import com.alberto.bikesapi.exception.ErrorResponse;
import com.alberto.bikesapi.exception.UserNotFoundException;
import com.alberto.bikesapi.service.BikeService;
import com.alberto.bikesapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    //enviamos un parametro como parte de la URL
    //con el requestParam puedo asignar un nombre y que no se vea el nombre real del codigo en la dirección
    //doy un valor por defecto y sino que busque por el parametro que le indico.
    public List<User> getUsersByStationId(@RequestParam(name = "station", defaultValue = "0") int stationId){
        List<User> users;

        if( stationId == 0){
            users = userService.findAllUser();
        } else {
            users = userService.findAllUser(stationId);
        }
        return users;
    }

    @GetMapping("/user/{id}")
    //PathVariable el parámetro forman parte de la propia URL
    public User getUser(@PathVariable long id) throws UserNotFoundException {
        User user = userService.findUser(id);
        return user;
    }

//    //borrar una Bici y enseñar que bici se ha borrado
//    @DeleteMapping("/bike/{id}")
//    public Bike removeBike(@PathVariable long id) throws BikeNotFoundException {
//        Bike bike = bikeService.removeBike(id);
//        return bike;
//    }

    //registrar un usuario
    //Debemos pasar los datos, como añadimos datos en una operación, debemos convertirlo en un cuerpo de la llamada
    //para ello utilizamos un RequestBody
    //cuando yo le digo que le envío un objeto java, lo que hacemos es enviarle un json en el postman en body>raw>json
    //y escribo el objeto que quiero registrar
    //El parámetro aquí es un objeto y lo enviamos como un json
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return newUser;
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
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException unfe){
        ErrorResponse errorResponse = new ErrorResponse("404", unfe.getMessage());
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
