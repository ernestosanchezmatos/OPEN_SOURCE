package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name="ClienteId",nullable = false)
	private int ClienteId; 
	
	@Column(name="NSector",nullable = false)
	private String NSector;	
	
	@OneToOne
	@JoinColumn(name="PersonaId",nullable = false)
	private Persona Persona;

	public Cliente(int ClienteId, String NSector,Persona Persona) {
		super();
		this.ClienteId = ClienteId;
		this.NSector = NSector;		
		this.Persona = Persona;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getClienteId() {
		return ClienteId;
	}

	public void setClienteId(int ClienteId) {
		this.ClienteId = ClienteId;
	}

	public String getNSector() {
		return NSector;
	}

	public void setNSector(String NSector) {
		this.NSector = NSector;
	}

	public Persona getPersona() {
		return Persona;
	}

	public void setPersona(Persona Persona) {
		this.Persona = Persona;
	}


	

}
