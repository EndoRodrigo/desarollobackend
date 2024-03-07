package com.coorporation.sistema_de_ventas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coorporation.sistema_de_ventas.Model.UserModel;
import com.coorporation.sistema_de_ventas.Repository.UserRepositiry;

@RestController
public class UserController {

    @Autowired
    private UserRepositiry usuarioRepository;

    
    @GetMapping("/")
    public List<UserModel> getAllUserList() {
        return usuarioRepository.findAll();
    }

}
