package upc.spring.MyE.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Personas")
public class Persona  implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PersonaId",nullable = false)
	private Integer PersonaId; 
	
	@Column(name="NPersona",nullable = false,length = 40)
	private String NPersona;
	
	@Column(name="NumContacto",nullable = false,length = 40)
	private Integer NumContacto;
	
	public Persona(Integer PersonaId, String NPersona, Integer NumContacto) {
		super();
		this.PersonaId = PersonaId;
		this.NPersona = NPersona;
		this.NumContacto = NumContacto;
	}
	
	public Persona()
	{
		super();
	}
	public Integer getPersonaId() {
		return PersonaId;
	}

	public void setPersonaId(Integer PersonaId) {
		this.PersonaId = PersonaId;
	}

	public String getNPersona() {
		return NPersona;
	}

	public void setNPersona(String nPersona) {
		this.NPersona = nPersona;
	}
	public Integer getNumContacto() {
		return NumContacto;
	}

	public void setNumContacto(Integer NumContacto) {
		this.NumContacto = NumContacto;
	}	

}
