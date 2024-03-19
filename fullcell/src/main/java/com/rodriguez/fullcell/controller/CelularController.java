package com.rodriguez.fullcell.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rodriguez.fullcell.model.Celular;
import com.rodriguez.fullcell.service.CelularService;


@RestController
@RequestMapping("/celulares")
public class CelularController {

    @Autowired
    private CelularService celularService;
    
   @GetMapping("/listado")
    public List<Celular> getCelular() {
        return celularService.getlista();
    }

    @PostMapping("/create")
    public Celular crearCelular(@RequestBody Celular cel) {
        return  celularService.crearCelular(cel);
    }

    @PutMapping("/update")
    public Celular actualizarCelular(@RequestBody Celular cel) {
        return celularService.updatCelular(cel);
    }

    @DeleteMapping("/delete")
    public String eliminarCelular(@RequestBody Celular cel) {
        return celularService.eliminarCelular(cel);
    }
    
}
