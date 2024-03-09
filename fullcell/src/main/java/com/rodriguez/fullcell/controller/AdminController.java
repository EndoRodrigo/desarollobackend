package com.rodriguez.fullcell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.rodriguez.fullcell.model.Usuario;
import com.rodriguez.fullcell.service.UsuarioService;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private UsuarioService userService;
    
    @GetMapping("/user/v2")
    public List<Usuario> getCelular() {
        return userService.getlista();
    }

    @PostMapping("/user/create")
    public Usuario crearCelular(@RequestBody Usuario cel) {
        return  userService.crearCelular(cel);
    }

    @PutMapping("/user/update")
    public Usuario actualizarCelular(@RequestBody Usuario cel) {
        return userService.updatCelular(cel);
    }

    @DeleteMapping("/user/delete")
    public String eliminarCelular(@RequestBody Usuario cel) {
        return userService.eliminarCelular(cel);
    }
    
}
