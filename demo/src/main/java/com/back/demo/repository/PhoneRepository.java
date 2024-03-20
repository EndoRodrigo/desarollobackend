package com.back.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.back.demo.model.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Long>{

}
