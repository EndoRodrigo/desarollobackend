package com.rodriguez.fullcell.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodriguez.fullcell.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
