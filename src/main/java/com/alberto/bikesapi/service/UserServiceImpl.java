package com.alberto.bikesapi.service;

import com.alberto.bikesapi.domain.User;
import com.alberto.bikesapi.exception.UserNotFoundException;
import com.alberto.bikesapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAllUser() {

        return userRepository.findAll();
    }

    @Override
    public List<User> findAllUser(long bikeId) {

        return null;
    }

    @Override
    public List<User> findAllUser(int stationId) {
        return null;
    }

    @Override
    public User findUser(long id) throws UserNotFoundException {
        return null;
    }

    @Override
    public User removeUser(long id) throws UserNotFoundException {
        return null;
    }

    @Override
    public User addUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User modifyUser(long id, User user) throws UserNotFoundException {
        return null;
    }
}
