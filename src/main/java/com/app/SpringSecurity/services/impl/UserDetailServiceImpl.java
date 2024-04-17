package com.app.SpringSecurity.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.SpringSecurity.repositories.UsuarioRepository;
import com.app.SpringSecurity.repositories.entities.UsuarioEntity;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UsuarioEntity usuarioEntity = usuarioRepository.findUsuarioEntityByNombreUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe"));
        
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        usuarioEntity.getRoles()
                .forEach(rol -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(rol.getRolEnum().name()))));
          
        usuarioEntity.getRoles().stream()
                .flatMap(rol -> rol.getPermisos().stream())
                .forEach(permiso -> authorityList.add(new SimpleGrantedAuthority(permiso.getNombre())));

        return new User(usuarioEntity.getNombreUsuario(),
                        usuarioEntity.getContraseña(),
                        usuarioEntity.isActivo(),
                        usuarioEntity.isCuentaNoExpirada(),
                        usuarioEntity.isCuentaNoBloqueada(),
                        usuarioEntity.isCredencialesNoExpiradas(),
                        authorityList);
    }
    
}
