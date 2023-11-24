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
@Table(name="tb_solicitud")
public class Solicitud {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="id_soli")
	private Integer codigo ;

	@Column(name="razon")
	private String razon ;

	@Column(name="descripcion")
	private String descripcion ;

	@Column(name="posolucion")
	private String posolucion ;
		
	@Column(name="recomendacion")
	private String recomendacion ;
	
	@Column(name="recurrencia")
	private String recurrencia ;
	
	@Column(name="estado")
	private String estado ;
	@Column(name="lugar_hecho")
	private String lugar ;
	
	@ManyToOne
	@JoinColumn (name = "id_usuario")
	private Usuario usuario;
	
	@JsonIgnore
	@OneToMany (mappedBy = "solicitud") 
	private List<Cronograma> listaCronogramas;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPosolucion() {
		return posolucion;
	}

	public void setPosolucion(String posolucion) {
		this.posolucion = posolucion;
	}

	public String getRecomendacion() {
		return recomendacion;
	}

	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}

	public String getRecurrencia() {
		return recurrencia;
	}

	public void setRecurrencia(String recurrencia) {
		this.recurrencia = recurrencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Cronograma> getListaCronogramas() {
		return listaCronogramas;
	}

	public void setListaCronogramas(List<Cronograma> listaCronogramas) {
		this.listaCronogramas = listaCronogramas;
	}
	
	
}
