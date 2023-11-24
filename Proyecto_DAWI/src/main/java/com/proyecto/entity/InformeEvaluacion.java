package com.proyecto.entity;

import java.util.List;

import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_info_evaluacion")
public class InformeEvaluacion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_eva")
	private Integer codigo;
	
	@Column(name="resultado")
	private String resultado;
	
	@Column(name="aprobacion")
	private String aprobacion;
	
	@Column(name="actividadesAprobadas")
	private String actividades;
	
	@ManyToOne
	@JoinColumn (name = "id_crono")
	private Cronograma cronograma;

	@JsonIgnore
	@OneToMany (mappedBy = "informeEvaluacion") 
	private List<InformeFinal> listaInformesFinales;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getAprobacion() {
		return aprobacion;
	}

	public void setAprobacion(String aprobacion) {
		this.aprobacion = aprobacion;
	}

	public String getActividades() {
		return actividades;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	public Cronograma getCronograma() {
		return cronograma;
	}

	public void setCronograma(Cronograma cronograma) {
		this.cronograma = cronograma;
	}

	public List<InformeFinal> getListaInformesFinales() {
		return listaInformesFinales;
	}

	public void setListaInformesFinales(List<InformeFinal> listaInformesFinales) {
		this.listaInformesFinales = listaInformesFinales;
	}
	
	
}
