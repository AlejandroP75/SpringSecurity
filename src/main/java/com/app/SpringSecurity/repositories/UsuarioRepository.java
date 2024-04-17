package com.app.SpringSecurity.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.SpringSecurity.repositories.entities.UsuarioEntity;


public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long>{
    
    Optional<UsuarioEntity> findUsuarioEntityByNombreUsuario(String nombreUsuario);

    //@Query("SELECT u FROM UserEntity u WHERE u.username = ?")
    //Optional<UserEntity> findUser();
} 
 