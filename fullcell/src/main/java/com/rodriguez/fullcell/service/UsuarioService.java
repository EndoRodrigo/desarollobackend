package com.rodriguez.fullcell.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.rodriguez.fullcell.model.Usuario;
import com.rodriguez.fullcell.repositoy.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    
    public List<Usuario> getlista(){
        return usuarioRepository.findAll();
    }

    public Usuario crearCelular(Usuario cel){
        return usuarioRepository.save(cel);
    }

    public Usuario updatCelular(Usuario cel){
        return  usuarioRepository.save(cel);
    }

    public String  eliminarCelular(Usuario cel){
        usuarioRepository.delete(cel);
        return "Usuario eliminadio "+ cel.getId();
    }
}
