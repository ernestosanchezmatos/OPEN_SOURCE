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
@Table(name="Empleado")
public class Empleado implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name="EmpleadoId",nullable = false)
	private int EmpleadoId; 
	
	@Column(name="DNI",nullable = false)
	private String DNI;	
	
	@OneToOne
	@JoinColumn(name="PersonaId",nullable = false)
	private Persona Persona;

	public Empleado(int EmpleadoId, String DNI,Persona Persona) {
		super();
		this.EmpleadoId = EmpleadoId;
		this.DNI = DNI;		
		this.Persona = Persona;
	}

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmpleadoId() {
		return EmpleadoId;
	}

	public void setEmpleadoId(int EmpleadoId) {
		this.EmpleadoId = EmpleadoId;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public Persona getPersona() {
		return Persona;
	}

	public void setPersona(Persona Persona) {
		this.Persona = Persona;
	}


	

}
