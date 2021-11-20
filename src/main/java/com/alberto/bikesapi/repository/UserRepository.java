package com.alberto.bikesapi.repository;

import com.alberto.bikesapi.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    List<User> findAll();

}
