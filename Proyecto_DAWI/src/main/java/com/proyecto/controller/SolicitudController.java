package com.proyecto.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Solicitud;
import com.proyecto.entity.Usuario;
import com.proyecto.service.SolicitudService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/solicitud")
public class SolicitudController {
	@Autowired
	private SolicitudService servicioSol;
	
	@RequestMapping("/registrar")
	public String registrar(Model model){
		
		return "registro-solicitud";
	}
	
	@RequestMapping("/grabar")
	public String grabar(
						 @RequestParam("razon") String raz,
						 @RequestParam("descripcion") String des,
						 @RequestParam("recurrencia") String rec,
						 @RequestParam("lugar") String lug,
						 @RequestParam("posolucion") String pos,
						 @RequestParam("recomendacion") String reco,
						 RedirectAttributes redirect,HttpServletRequest request) {		
		try {
			Solicitud sol=new Solicitud();
			sol.setCodigo(0);
			sol.setRazon(raz);
			sol.setDescripcion(des);
			sol.setRecurrencia(rec);
			sol.setLugar(lug);
			sol.setPosolucion(pos);
			sol.setRecomendacion(reco);
			sol.setEstado("Activo");
			int codUsu=(int) request.getSession().getAttribute("IDUSUARIO");

			Usuario u=new Usuario();
			u.setCodigo(codUsu);
			sol.setUsuario(u);

			servicioSol.registrar(sol);
			
			redirect.addFlashAttribute("MENSAJE","Medicamento registrado");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/solicitud/registrar";
	}
	
	
	
	
	@RequestMapping("/consultaPorUsuario")
	public String consultaPorUsuario(Model model,HttpServletRequest request){
		
		int codUsu=(int) request.getSession().getAttribute("IDUSUARIO");
		
		model.addAttribute("solicitudes",servicioSol.listarSolicitudporUsuario(codUsu));
		
		return "consultausuario-solicitud";
	}
	
	@RequestMapping("/listarSolicitudes")
	public String listarSolicitudes(Model model){
		model.addAttribute("solicitudesCompletas",servicioSol.listarTodos());
		
		return "listar-solicitudes";
	}
	
	
	
}
