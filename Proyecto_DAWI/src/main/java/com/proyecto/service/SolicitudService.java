package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.SolicitudRepository;
import com.proyecto.entity.Solicitud;

@Service
public class SolicitudService {
	@Autowired
	private SolicitudRepository repo;
	
	public void registrar(Solicitud m) {
		repo.save(m);
	}
	public void actualizar(Solicitud m) {
		repo.save(m);
	}
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	public Solicitud buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Solicitud> listarTodos(){
		return repo.findAll();
	}
	public List<Solicitud> listarSolicitudporUsuario(Integer cod) {
		return repo.listarSolicitudporUsuario(cod);
	}
	
}
