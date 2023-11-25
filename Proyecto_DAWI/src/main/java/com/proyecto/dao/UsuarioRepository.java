package com.proyecto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Enlace;
import com.proyecto.entity.Solicitud;
import com.proyecto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	//método para iniciar sesión
		//select *from tb_usuario where login='anita' and clave='la huerfanita'
		//select u from Usuario u where u.login=?1
		@Query("select u from Usuario u where u.usuario=?1")
		public Usuario iniciarSesion(String vLogin);
		
		//método para traer los enlaces según el código de rol del usuario
		//select e.idenlace,e.descripcion,e.ruta from tb_enlace e join tb_rol_enlace re on 
		//e.idenlace=re.idenlace where re.idrol=1;
		
		@Query("select e from RolEnlace re join re.enlace e where re.rol.descripcion=?1")
		public List<Enlace> traerEnlacesDelUsuario(String desRol);
		
		@Query("select u from Usuario u where u.rol.codigo=1")
		public List<Usuario> listarUsuariosPorRolVecino();
}
