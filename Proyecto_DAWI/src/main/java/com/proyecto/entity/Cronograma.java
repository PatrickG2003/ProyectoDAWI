package com.proyecto.entity;

import java.time.LocalDate;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_cronograma")
public class Cronograma {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_crono")
	private Integer codigo ;

	@Column(name="inicio")
	private LocalDate inicio;
	
	@Column(name="fin")
	private LocalDate fin;
	
	@Column(name="rendimiento")
	private String rendimiento;

	@ManyToOne
	@JoinColumn (name = "id_soli")
	private Solicitud solicitud;
	
	@JsonIgnore
	@OneToMany (mappedBy = "cronograma") 
	private List<InformeEvaluacion> listaInformes;

	@JsonIgnore
	@OneToMany (mappedBy = "cronograma") 
	private List<InspeccionesCronograma> listaInspeccionesCronograma;
	public Integer getCodigo() {
		return codigo;
	}

	public List<InspeccionesCronograma> getListaInspeccionesCronograma() {
		return listaInspeccionesCronograma;
	}

	public void setListaInspeccionesCronograma(List<InspeccionesCronograma> listaInspeccionesCronograma) {
		this.listaInspeccionesCronograma = listaInspeccionesCronograma;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public String getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(String rendimiento) {
		this.rendimiento = rendimiento;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public List<InformeEvaluacion> getListaInformes() {
		return listaInformes;
	}

	public void setListaInformes(List<InformeEvaluacion> listaInformes) {
		this.listaInformes = listaInformes;
	}
	
	
}	
