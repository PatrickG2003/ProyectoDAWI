package com.proyecto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer>{
	
	@Query("select s from Solicitud s where s.usuario.codigo=?1 and s.estado='Activo' ")
	public List<Solicitud> listarSolicitudporUsuario(int codTipo);
}
