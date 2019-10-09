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
@Table(name="Orden")
public class Orden implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OrdenId",nullable = false)
	private int OrdenId; 
	
	@Column(name="FechaGeneracion",nullable = true,length = 40)
	private String FechaGeneracion;	
	
	@Column(name="FechaEjecucion",nullable = true,length = 40)
	private String FechaEjecucion;	
	
	@ManyToOne
	@JoinColumn(name="EmpleadoId",nullable = false)
	private Empleado Empleado;


	@ManyToOne
	@JoinColumn(name="Lugar_PersonasId",nullable = false)
	private Lugar_Personas Lugar_Personas;
	
	
	public Orden(int OrdenId, String FechaGeneracion,String FechaEjecucion,Empleado Empleado, Lugar_Personas Lugar_Personas) {
		super();
		this.OrdenId = OrdenId;
		this.FechaGeneracion = FechaGeneracion;		
		this.Empleado = Empleado;	
		this.FechaEjecucion=FechaEjecucion;
		this.Lugar_Personas=Lugar_Personas;
	}

	public Orden() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrdenId() {
		return OrdenId;
	}

	public void setOrdenId(int OrdenId) {
		this.OrdenId = OrdenId;
	}

	public String getFechaGeneracion() {
		return FechaGeneracion;
	}

	public void setFechaGeneracion(String FechaGeneracion) {
		this.FechaGeneracion = FechaGeneracion;
	}
	
	public String getFechaEjecucion() {
		return FechaEjecucion;
	}

	public void setFechaEjecucion(String FechaEjecucion) {
		this.FechaEjecucion = FechaEjecucion;
	}

	public Empleado getEmpleado() {
		return Empleado;
	}

	public void setEmpleado(Empleado Empleado) {
		this.Empleado = Empleado;
	}

	public Lugar_Personas getLugar_Personas() {
		return Lugar_Personas;
	}

	public void setLugar_Personas(Lugar_Personas Lugar_Personas) {
		this.Lugar_Personas = Lugar_Personas;
	}
	
	

}
