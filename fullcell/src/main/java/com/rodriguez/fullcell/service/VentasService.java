package com.rodriguez.fullcell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rodriguez.fullcell.model.Ventas;
import com.rodriguez.fullcell.repositoy.VentasRepository;

@Service
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    
    public Iterable<Ventas> getlista(){
        return ventasRepository.findAll();
    }

    public Ventas crearCelular(Ventas cel){
        return ventasRepository.save(cel);
    }

    public Ventas updatCelular(Ventas cel){
        return  ventasRepository.save(cel);
    }

    public String  eliminarCelular(Ventas cel){
        ventasRepository.delete(cel);
        return "Usuario eliminadio "+ cel.getId();
    }
}
