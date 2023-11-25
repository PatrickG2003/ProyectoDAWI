package com.proyecto.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.dto.Detalle;
import com.proyecto.entity.Cronograma;
import com.proyecto.entity.Inspecciones;
import com.proyecto.entity.InspeccionesCronograma;
import com.proyecto.entity.Solicitud;
import com.proyecto.service.CronogramaService;
import com.proyecto.service.InspeccionesService;
import com.proyecto.service.SolicitudService;
import com.proyecto.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cronograma")
public class CronogramaController {

	@Autowired
	private InspeccionesService servicioInspecciones;
	@Autowired
	private CronogramaService servicioCronograma;
	@Autowired
	private SolicitudService servicioSolicitud;
	@Autowired
	private UsuarioService servicioUsuario;
	
	@RequestMapping("/registrar")
	public String lista(Model model ){
		model.addAttribute("inspecciones",servicioInspecciones.listarTodos());
		model.addAttribute("usuarios",servicioUsuario.listarUsuarioVecino());

		return "registro-cronograma";
	}
	
	@RequestMapping("/registrarCronograma")
	public String listaConId(Model model, @RequestParam("codigo") int cod, HttpServletRequest request){
		model.addAttribute("inspecciones",servicioInspecciones.listarTodos());
		request.getSession().setAttribute("Codigo",cod);

		
		return "registro-cronograma";
	}

	@RequestMapping("/adicionar")
	@ResponseBody
	public List<Detalle> adicionar(@RequestParam("codigo") int cod,
						    @RequestParam("descripcion") String des, 
						    @RequestParam("detalle") String deta,
						    @RequestParam("fecha") String fec,
						    HttpServletRequest request) {
		List<Detalle> lista=null;
		if(request.getSession().getAttribute("datos")==null)//no existe
			lista=new ArrayList<Detalle>();
		else
			
			lista=(List<Detalle>) request.getSession().getAttribute("datos");
		
		Detalle det=new Detalle();
		det.setCodigo(cod);
		det.setDescripcion(des);
		det.setDetalle(deta);
		det.setFecha(LocalDate.parse(fec));
		lista.add(det);
		request.getSession().setAttribute("datos",lista);
		return lista;
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("solicitud") int soli,@RequestParam("inicio") String ini,@RequestParam("fin") String fin,@RequestParam("rendimiento") String ren,
						HttpServletRequest request,RedirectAttributes redirect){
		try {
			//crear objeto de la entidad Requerimiento
			Cronograma bean=new Cronograma();
			bean.setInicio(LocalDate.parse(ini));
			bean.setFin(LocalDate.parse(fin));
			bean.setRendimiento(ren);
			Solicitud sol=new Solicitud();
			
			sol.setCodigo(soli);
			bean.setSolicitud(sol);
			
			List<Detalle> lista=(List<Detalle>) request.getSession().getAttribute("datos");
			List<InspeccionesCronograma> detalles=new ArrayList<InspeccionesCronograma>();
			//bucle
			for(Detalle de:lista) {
				//crear objeto de la ebtidad BienRequerimiento
				InspeccionesCronograma br=new InspeccionesCronograma();
				Inspecciones b=new Inspecciones();
				b.setCodigo(de.getCodigo());
				br.setInspecciones(b);
				br.setDetalle(de.getDetalle());
				br.setFecha(de.getFecha());
				detalles.add(br);
			}
			//enviar arreglo "detalles" dentro de "bean"
			bean.setListaInspeccionesCronograma(detalles);
			//
			servicioCronograma.registrarCronograma(bean);
			//
			lista.clear();
			request.getSession().setAttribute("datos",lista);
			redirect.addFlashAttribute("MENSAJE","Requerimiento registrado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en el registro");
			e.printStackTrace();
		}
		return "redirect:/cronograma/registrar";
	}
	
	@RequestMapping("/consultaSolicitud")
	@ResponseBody
	public List<Solicitud>consultaSolicitud(@RequestParam("codigo") int cod){
		return servicioSolicitud.listarSolicitudporUsuario(cod);
	}
	
	
}

