package com.rodriguez.fullcell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.rodriguez.fullcell.model.Ventas;
import com.rodriguez.fullcell.service.VentasService;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;
    
    @GetMapping("/listado")
    public List<Ventas> getCelular() {
        return (List<Ventas>) ventasService.getlista();
    }

    @PostMapping("/create")
    public Ventas crearCelular(@RequestBody Ventas cel) {
        return  ventasService.crearCelular(cel);
    }

    @PutMapping("/update")
    public Ventas actualizarCelular(@RequestBody Ventas cel) {
        return ventasService.updatCelular(cel);
    }

    @DeleteMapping("/delete")
    public String eliminarCelular(@RequestBody Ventas cel) {
        return ventasService.eliminarCelular(cel);
    }
    
}
