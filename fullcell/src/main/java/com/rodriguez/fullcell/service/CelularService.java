package com.rodriguez.fullcell.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rodriguez.fullcell.model.Celular;
import com.rodriguez.fullcell.repositoy.CelularRepository;

@Service
public class CelularService {

    @Autowired
    private CelularRepository celularRepository;

    public List<Celular> getlista(){
        return celularRepository.findAll();
    }

    public Celular crearCelular(Celular cel){
        return celularRepository.save(cel);
    }

    public Celular updatCelular(Celular cel){
        return  celularRepository.save(cel);
    }

    public String  eliminarCelular(Celular cel){
        celularRepository.delete(cel);
        return "Usuario eliminadio "+ cel.getId();
    }
}
