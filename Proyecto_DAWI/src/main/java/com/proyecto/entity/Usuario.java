package com.proyecto.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;



@Entity
@Table(name="tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int codigo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="dni")
	private String dni;
	@Column(name="celular")
	private String celular;
	@Column(name="correo")
	private String correo;
	@Column(name="usuario")
	private String usuario;
	@Column(name = "psswrd")
	private String password;
	
	
	
	@ManyToOne
	@JoinColumn(name="idrol")
	private Rol rol;

	@JsonIgnore
	@OneToMany (mappedBy = "usuario") 
	private List<Solicitud> listaSolicitudes;
	
	public List<Solicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}
	public void setListaSolicitudes(List<Solicitud> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Usuario(int codUsuario) {
		codigo=codUsuario;
	}
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public Rol getRol() {
		return rol;
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
}
