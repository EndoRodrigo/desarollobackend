package com.back.demo.controller;

import com.back.demo.model.Phone;
import com.back.demo.service.PhoneService;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PhoneController {


    @Autowired
    private PhoneService phoneService;

    @GetMapping("/listphone")
    public Iterable<Phone> getListPhone(){
        return phoneService.getListPhone();
    }

    @GetMapping("/phone/name/{gama}")
    public Iterable<Phone> getListPhoneName(@PathVariable String gama){
        return phoneService.getListPhoneName(gama);
    }

    @PostMapping("/createphone")
    public Phone createPhone(@RequestBody Phone phone){
        return phoneService.cretePhone(phone);
    }

}
