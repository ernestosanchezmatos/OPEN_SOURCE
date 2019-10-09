package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="Persona")

public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PersonaId",nullable = false)
	private int PersonaId; 
	
	@Column(name="NPersona",nullable = false,length = 40)
	private String NPersona;
	
	@Column(name="NumContacto",nullable = false,length = 40)
	private int NumContacto;
	
	public Persona(int PersonaId, String NPersona, int NumContacto) {
		super();
		this.PersonaId = PersonaId;
		this.NPersona = NPersona;
		this.NumContacto = NumContacto;
	}
	
	public Persona()
	{
		super();
	}
	public int getPersonaId() {
		return PersonaId;
	}

	public void setPersonaId(int PersonaId) {
		this.PersonaId = PersonaId;
	}

	public String getNPersona() {
		return NPersona;
	}

	public void setNPersona(String nPersona) {
		this.NPersona = nPersona;
	}
	public int getNumContacto() {
		return NumContacto;
	}

	public void setNumContacto(int NumContacto) {
		this.NumContacto = NumContacto;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + PersonaId;
		result = prime * result + ((NPersona == null) ? 0 : NPersona.hashCode());
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
		Persona other = (Persona) obj;
		if (PersonaId != other.PersonaId)
			return false;
		if (NPersona == null) {
			if (other.NPersona != null)
				return false;
		} else if (!NPersona.equals(other.NPersona))
			return false;
		return true;
	}
	
	

}
