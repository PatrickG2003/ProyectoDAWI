package com.proyecto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Usuario;
import com.proyecto.entity.Enlace;
import com.proyecto.entity.Rol;
import com.proyecto.entity.Solicitud;
import com.proyecto.service.RolService;
import com.proyecto.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sesion")
@SessionAttributes({"ENLACES","DATOSDELUSUARIO","IDUSUARIO"})
public class UsuarioController {
	@Autowired
	private UsuarioService servicioUsu;
	
	@Autowired
	private RolService servicioRol;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/principal")
	public String intranet(Authentication auth,Model model) {
		String nomRol=auth.getAuthorities().stream()
			      .map(GrantedAuthority::getAuthority)
			      .collect(Collectors.joining(","));
		List<Enlace> enlaces=servicioUsu.enlacesDelUsuario(nomRol);
		
		Usuario usu=servicioUsu.sesionUsuario(auth.getName());

		//atributo
		model.addAttribute("ENLACES",enlaces);
		model.addAttribute("DATOSDELUSUARIO",usu.getNombre()+" "+ usu.getApellido());
		model.addAttribute("IDUSUARIO", usu.getCodigo());
		return "principal";
	}
	
	
	
	@RequestMapping("/registrarVecino")
	public String registrarVecino(
						 @RequestParam("nombre") String nom,
						 @RequestParam("apellido") String ape,
						 @RequestParam("dni") String dni,
						 @RequestParam("celular") String cel,
						 @RequestParam("correo") String cor,
						 @RequestParam("usuario") String usu,
						 @RequestParam("password") String pas,

						 RedirectAttributes redirect,HttpServletRequest request) {		
		try {
			
			String var;
			var = encoder.encode(pas);
			Usuario usuario=new Usuario();
			usuario.setNombre(nom);
			usuario.setApellido(ape);
			usuario.setDni(dni);
			usuario.setCelular(cel);
			usuario.setCorreo(cor);
			usuario.setUsuario(usu);
			usuario.setPassword(var);
			
			Rol rol=new Rol();
			rol.setCodigo(1);
			usuario.setRol(rol);
		
			servicioUsu.registrar(usuario);
			
			redirect.addFlashAttribute("MENSAJE","Usuario registrado");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/sesion/login";
	}
	
	@RequestMapping("/registrarUsuario")
	public String registrarUsuario(
						 @RequestParam("nombre") String nom,
						 @RequestParam("apellido") String ape,
						 @RequestParam("dni") String dni,
						 @RequestParam("celular") String cel,
						 @RequestParam("correo") String cor,
						 @RequestParam("usuario") String usu,
						 @RequestParam("password") String pas,
						 @RequestParam("idrol") int idrol,

						 RedirectAttributes redirect) {		
		try {
			
			String var;
			var = encoder.encode(pas);
			Usuario usuario=new Usuario();
			usuario.setNombre(nom);
			usuario.setApellido(ape);
			usuario.setDni(dni);
			usuario.setCelular(cel);
			usuario.setCorreo(cor);
			usuario.setUsuario(usu);
			usuario.setPassword(var);
			
			Rol rol=new Rol();
			rol.setCodigo(idrol);
			usuario.setRol(rol);
		
			servicioUsu.registrar(usuario);
			
			redirect.addFlashAttribute("MENSAJE","Usuario registrado");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/sesion/listaUsuario";
	}
	
	@RequestMapping("/listaUsuario")
	public String listaUsuario(Model model){
		
		model.addAttribute("usuarios",servicioUsu.listarTodos());
		model.addAttribute("roles",servicioRol.listarTodos());
			
		
		return "mantenimiento-usuario";
	}
	
	
}



