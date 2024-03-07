package com.coorporation.sistema_de_ventas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coorporation.sistema_de_ventas.Model.UserModel;

public interface UserRepositiry extends JpaRepository<UserModel, Long>{

    
} 
