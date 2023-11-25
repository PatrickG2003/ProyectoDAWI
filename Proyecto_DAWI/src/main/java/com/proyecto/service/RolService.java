package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.RolRepository;
import com.proyecto.entity.Rol;

@Service
public class RolService {
	@Autowired
	private RolRepository repo;
	
	public List<Rol> listarTodos(){
		return repo.findAll();
	}
}
