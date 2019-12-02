package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="Servicio")

public class Servicio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ServicioId",nullable = false)
	private int ServicioId; 
	
	@Column(name="NServicio",nullable = false,length = 40)
	private String NServicio;

	public Servicio(int ServicioId, String NServicio) {
		super();
		this.ServicioId = ServicioId;
		this.NServicio = NServicio;
	}
	
	public Servicio()
	{
		super();
	}
	public int getServicioId() {
		return ServicioId;
	}

	public void setServicioId(int ServicioId) {
		this.ServicioId = ServicioId;
	}

	public String getNServicio() {
		return NServicio;
	}

	public void setNServicio(String nServicio) {
		this.NServicio = nServicio;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ServicioId;
		result = prime * result + ((NServicio == null) ? 0 : NServicio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		if (ServicioId != other.ServicioId)
			return false;
		if (NServicio == null) {
			if (other.NServicio != null)
				return false;
		} else if (!NServicio.equals(other.NServicio))
			return false;
		return true;
	}
	
	

}
