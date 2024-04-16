package com.app.SpringSecurity.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.SpringSecurity.repositories.entities.UsuarioEntity;


public interface UserRepository extends CrudRepository<UsuarioEntity, Long>{
    
    Optional<UsuarioEntity> findUsuarioEntityByNombreUsuario(String nombreUsuario);
} 
