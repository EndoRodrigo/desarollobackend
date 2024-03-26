package com.back.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.demo.model.Phone;
import com.back.demo.repository.PhoneRepository;


@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    public Iterable<Phone> getListPhone(){
        return phoneRepository.findAll();
    }

    @SuppressWarnings("null")
    public Phone cretePhone(Phone phone){
        return phoneRepository.save(phone);
    }

    public Iterable<Phone> getListPhoneName(String name){
        return phoneRepository.findByGama(name);
    }
}
