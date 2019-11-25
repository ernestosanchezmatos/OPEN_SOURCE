package upc.spring.MyE.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{		
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer ClienteId; 	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ClienteId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PersonaId",unique=true)		
	private Persona PersonaId;
	
	@Column(name="DNI",nullable = false)
	private Integer DNI;

	public Integer getClienteId() {
		return ClienteId;
	}

	public void setClienteId(Integer clienteId) {
		ClienteId = clienteId;
	}

	public Persona getPersonaId() {
		return PersonaId;
	}

	public void setPersonaId(Persona personaId) {
		PersonaId = personaId;
	}

	public Integer getDNI() {
		return DNI;
	}

	public void setDNI(Integer dNI) {
		DNI = dNI;
	}

	public Cliente(Integer clienteId, Persona personaId, Integer dNI) {
		super();
		ClienteId = clienteId;
		PersonaId = personaId;
		DNI = dNI;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
