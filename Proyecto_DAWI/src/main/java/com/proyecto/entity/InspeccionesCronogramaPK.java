package com.proyecto.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class InspeccionesCronogramaPK {

	private int id_insp;
	private int id_crono;
	
	@Override
	public int hashCode() {
		return Objects.hash(id_crono, id_insp);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InspeccionesCronogramaPK other = (InspeccionesCronogramaPK) obj;
		return id_crono == other.id_crono && id_insp == other.id_insp;
	}
	public int getId_insp() {
		return id_insp;
	}
	public void setId_insp(int id_insp) {
		this.id_insp = id_insp;
	}
	public int getId_crono() {
		return id_crono;
	}
	public void setId_crono(int id_crono) {
		this.id_crono = id_crono;
	}
	

}
