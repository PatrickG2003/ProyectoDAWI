package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.InspeccionesRepository;
import com.proyecto.entity.Inspecciones;

@Service
public class InspeccionesService {

	@Autowired
	private InspeccionesRepository repo;
	
	public List<Inspecciones> listarTodos(){
		return repo.findAll();
	}
	
}
