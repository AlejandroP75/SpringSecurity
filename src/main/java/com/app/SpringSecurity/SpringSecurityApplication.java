package com.app.SpringSecurity;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.SpringSecurity.repositories.UsuarioRepository;
import com.app.SpringSecurity.repositories.entities.PermisoEntity;
import com.app.SpringSecurity.repositories.entities.RolEntity;
import com.app.SpringSecurity.repositories.entities.RolEnum;
import com.app.SpringSecurity.repositories.entities.UsuarioEntity;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UsuarioRepository userRepository) {
		return args -> {
			PermisoEntity crearPermiso = PermisoEntity.builder()
					.nombre("CREATE")
					.build();

			PermisoEntity leerPermiso = PermisoEntity.builder()
					.nombre("READ")
					.build();

			PermisoEntity actualizarPermiso = PermisoEntity.builder()
					.nombre("UPDATE")
					.build();

			PermisoEntity eliminarPermiso = PermisoEntity.builder()
					.nombre("DELETE")
					.build();

			PermisoEntity refactorPermiso = PermisoEntity.builder()
					.nombre("REFACTOR")
					.build();

			RolEntity adminRol = RolEntity.builder()
					.rolEnum(RolEnum.ADMIN)
					.permisos(Set.of(crearPermiso, leerPermiso, actualizarPermiso, eliminarPermiso))
					.build();

			RolEntity usuarioRol = RolEntity.builder()
					.rolEnum(RolEnum.USER)
					.permisos(Set.of(crearPermiso, leerPermiso))
					.build();

			RolEntity invitadoRol = RolEntity.builder()
					.rolEnum(RolEnum.INVITED)
					.permisos(Set.of(leerPermiso))
					.build();

			RolEntity desarrolladorRol = RolEntity.builder()
					.rolEnum(RolEnum.DEVELOPER)
					.permisos(Set.of(crearPermiso, leerPermiso, actualizarPermiso, eliminarPermiso, refactorPermiso))
					.build();

			UsuarioEntity santiagoUser = UsuarioEntity.builder()
					.nombreUsuario("Santiago")
					.contraseña("$2a$10$qVg/euVlqdIP9jz2OG0/W.v5uuTO/I8glxDDDS7UGBpirsvPXKn.i")
					.activo(true)
					.cuentaNoExpirada(true)
					.cuentaNoBloqueada(true)
					.credencialesNoExpiradas(true)
					.roles(Set.of(adminRol))
					.build();

			UsuarioEntity danielUser = UsuarioEntity.builder()
					.nombreUsuario("Daniel")
					.contraseña("$2a$10$qVg/euVlqdIP9jz2OG0/W.v5uuTO/I8glxDDDS7UGBpirsvPXKn.i")
					.activo(true)
					.cuentaNoExpirada(true)
					.cuentaNoBloqueada(true)
					.credencialesNoExpiradas(true)
					.roles(Set.of(usuarioRol))
					.build();

			UsuarioEntity andreaUser = UsuarioEntity.builder()
					.nombreUsuario("Andrea")
					.contraseña("$2a$10$qVg/euVlqdIP9jz2OG0/W.v5uuTO/I8glxDDDS7UGBpirsvPXKn.i")
					.activo(true)
					.cuentaNoExpirada(true)
					.cuentaNoBloqueada(true)
					.credencialesNoExpiradas(true)
					.roles(Set.of(invitadoRol))
					.build();

			UsuarioEntity angyUser = UsuarioEntity.builder()
					.nombreUsuario("Angy")
					.contraseña("$2a$10$qVg/euVlqdIP9jz2OG0/W.v5uuTO/I8glxDDDS7UGBpirsvPXKn.i")
					.activo(true)
					.cuentaNoExpirada(true)
					.cuentaNoBloqueada(true)
					.credencialesNoExpiradas(true)
					.roles(Set.of(desarrolladorRol))
					.build();

			userRepository.saveAll(List.of(santiagoUser, danielUser, andreaUser, angyUser));
		};
	}
}
