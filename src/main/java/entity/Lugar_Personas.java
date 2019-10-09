package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Lugar_Personas")
public class Lugar_Personas implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Lugar_PersonasId",nullable = false)
	private int Lugar_PersonasId; 	
	
	
	@ManyToOne
	@JoinColumn(name="LugarId",nullable = false)
	private Lugar Lugar;
	
	@ManyToOne
	@JoinColumn(name="PersonaId",nullable = false)
	private Persona Persona;

	public Lugar_Personas(int Lugar_PersonasId, Lugar Lugar,Persona Persona) {
		super();
		this.Lugar_PersonasId = Lugar_PersonasId;		
		this.Lugar = Lugar;
		this.Persona = Persona;
	}

	public Lugar_Personas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLugar_PersonasId() {
		return Lugar_PersonasId;
	}

	public void setLugar_PersonasId(int Lugar_PersonasId) {
		this.Lugar_PersonasId = Lugar_PersonasId;
	}
	public Lugar getLugar() {
		return Lugar;
	}

	public void setLugar(Lugar Lugar) {
		this.Lugar = Lugar;
	}
	
	public Persona getPersona() {
		return Persona;
	}

	public void setPersona(Persona Persona) {
		this.Persona = Persona;
	}



	

}
