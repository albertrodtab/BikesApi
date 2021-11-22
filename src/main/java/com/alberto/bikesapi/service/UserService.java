package com.alberto.bikesapi.service;

import com.alberto.bikesapi.domain.User;
import com.alberto.bikesapi.exception.BikeNotFoundException;
import com.alberto.bikesapi.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    List<User> findAllUser();
    List<User> findAllUser(long bikeId);
    List<User> findAllUser(int stationId);
    User findUser(long id) throws UserNotFoundException;


    User removeUser(long id) throws UserNotFoundException;

    User addUser(User user) ;

    User modifyUser(long id, User user) throws UserNotFoundException;
}
