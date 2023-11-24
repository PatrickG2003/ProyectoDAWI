package com.proyecto.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_inspecciones")
public class Inspecciones {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_insp")
	private Integer codigo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	
	
	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public List<InspeccionesCronograma> getListaInspeccionesCronograma() {
		return listaInspeccionesCronograma;
	}



	public void setListaInspeccionesCronograma(List<InspeccionesCronograma> listaInspeccionesCronograma) {
		this.listaInspeccionesCronograma = listaInspeccionesCronograma;
	}



	@JsonIgnore
	@OneToMany (mappedBy = "inspecciones") 
	private List<InspeccionesCronograma> listaInspeccionesCronograma;
}
