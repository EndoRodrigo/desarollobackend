package com.back.demo.controller;

import com.back.demo.model.Phone;
import com.back.demo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class PhoneController {


    @Autowired
    private PhoneService phoneService;

    @GetMapping("/listphone")
    public Iterable<Phone> getListPhone(){
        return phoneService.getListPhone();
    }

    @PostMapping("/createphone")
    public Phone createPhone(@RequestBody Phone phone){
        return phoneService.cretePhone(phone);
    }

}
