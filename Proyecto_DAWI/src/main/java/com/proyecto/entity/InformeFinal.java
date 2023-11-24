package com.proyecto.entity;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_fin_informe")
public class InformeFinal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idd_fininf")
	private Integer codigo;
	
	@Column(name="conclusion")
	private String conclusion;
	
	@ManyToOne
	@JoinColumn (name = "id_eva")
	private InformeEvaluacion informeEvaluacion;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public InformeEvaluacion getInformeEvaluacion() {
		return informeEvaluacion;
	}

	public void setInformeEvaluacion(InformeEvaluacion informeEvaluacion) {
		this.informeEvaluacion = informeEvaluacion;
	}

	
}
