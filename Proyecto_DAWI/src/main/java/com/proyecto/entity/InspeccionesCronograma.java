package com.proyecto.entity;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Table(name="tb_inspecciones_cronograma")
@Entity
public class InspeccionesCronograma {
	@EmbeddedId
	private InspeccionesCronogramaPK pk;
	
	@ManyToOne
	@JoinColumn(name = "id_insp",insertable = false,
		updatable = false,referencedColumnName ="id_insp")
	private Inspecciones inspecciones;

	@ManyToOne
	@JoinColumn(name = "id_crono",insertable = false,
		updatable = false,referencedColumnName ="id_crono")
	private Cronograma cronograma;
	
	@Column(name = "detalle")
	private String  detalle;
	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	public InspeccionesCronogramaPK getPk() {
		return pk;
	}

	public void setPk(InspeccionesCronogramaPK pk) {
		this.pk = pk;
	}

	public Inspecciones getInspecciones() {
		return inspecciones;
	}

	public void setInspecciones(Inspecciones inspecciones) {
		this.inspecciones = inspecciones;
	}

	public Cronograma getCronograma() {
		return cronograma;
	}

	public void setCronograma(Cronograma cronograma) {
		this.cronograma = cronograma;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


}
