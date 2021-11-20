package com.alberto.bikesapi.service;

import com.alberto.bikesapi.domain.Bike;
import com.alberto.bikesapi.domain.Route;
import com.alberto.bikesapi.domain.User;
import com.alberto.bikesapi.domain.dto.RouteDTO;
import com.alberto.bikesapi.exception.BikeNotFoundException;
import com.alberto.bikesapi.exception.RouteNotFoundException;
import com.alberto.bikesapi.exception.UserNotFoundException;
import com.alberto.bikesapi.repository.BikeRepository;
import com.alberto.bikesapi.repository.RouteRepository;
import com.alberto.bikesapi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public List<Route> findAllRoute() {
        return null;
    }

    @Override
    public List<Route> findAllRouteByBike(long bikeId) throws BikeNotFoundException {
        return null;
    }

    @Override
    public List<Route> findAllRouteByUser(long userId) throws UserNotFoundException {
        return null;
    }

    @Override
    public Route findRoute(long id) throws RouteNotFoundException {
        return null;
    }

    @Override
    public Route removeRoute(long id) throws RouteNotFoundException {
        return null;
    }

    @Override
    public Route addRoute(RouteDTO routeDto) throws UserNotFoundException, BikeNotFoundException{
        //tengo que recuperar los objetos enteros para pasarlos a la base de datos no solo el id
        User user = userRepository.findById(routeDto.getUser())
                .orElseThrow(UserNotFoundException::new);
        Bike bike = bikeRepository.findById(routeDto.getBike())
                .orElseThrow(BikeNotFoundException::new);
        /*
        vamos a utilizar un mapeador(introducir dependencia modelmapper) para no tener que ir indicandolo al
        nuevo objeto todos los atributos
        Le indico mapeame el objeto que te indico en la nueva ruta con lo que debe tener cualquier ruta y ya cojes la
        información y yo le indico a mayores los que objetos completos que no estan en el DTO, no solo los id.
        Con el map me ahorro los get set para poder crear un objeto. Solo mapea lo que es comun a ambos objetos y
        lo demas lo ignora.
         */
        ModelMapper mapper = new ModelMapper();
        Route route = mapper.map(routeDto, Route.class);
        route.setBike(bike);
        route.setUser(user);
        return routeRepository.save(route);
    }

    @Override
    public Route modifyRoute(long id, Route route) throws RouteNotFoundException {
        return null;
    }
}
