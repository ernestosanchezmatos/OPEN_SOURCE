package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="Equipo")

public class Equipo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EquipoId",nullable = false)
	private int EquipoId; 
	
	@Column(name="NEquipo",nullable = false,length = 40)
	private String NEquipo;

	public Equipo(int EquipoId, String NEquipo) {
		super();
		this.EquipoId = EquipoId;
		this.NEquipo = NEquipo;
	}
	
	public Equipo()
	{
		super();
	}
	public int getEquipoId() {
		return EquipoId;
	}

	public void setEquipoId(int EquipoId) {
		this.EquipoId = EquipoId;
	}

	public String getNEquipo() {
		return NEquipo;
	}

	public void setNEquipo(String nEquipo) {
		this.NEquipo = nEquipo;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + EquipoId;
		result = prime * result + ((NEquipo == null) ? 0 : NEquipo.hashCode());
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
		Equipo other = (Equipo) obj;
		if (EquipoId != other.EquipoId)
			return false;
		if (NEquipo == null) {
			if (other.NEquipo != null)
				return false;
		} else if (!NEquipo.equals(other.NEquipo))
			return false;
		return true;
	}
	
	

}
