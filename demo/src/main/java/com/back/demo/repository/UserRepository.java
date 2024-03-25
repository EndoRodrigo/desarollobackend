package com.back.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.back.demo.model.User;



public interface UserRepository extends CrudRepository<User, Long> {

    public Optional<User> findByName(User name);

}
