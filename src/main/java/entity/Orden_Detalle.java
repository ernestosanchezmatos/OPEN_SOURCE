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
@Table(name="Orden_Detalle")
public class Orden_Detalle implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Orden_DetalleId",nullable = false)
	private int Orden_DetalleId; 
	
	
	
	@ManyToOne
	@JoinColumn(name="ServicioId",nullable = false)
	private Servicio Servicio;
	
	@ManyToOne
	@JoinColumn(name="OrdenId",nullable = false)
	private Orden Orden;
	
	@ManyToOne
	@JoinColumn(name="EjemplarId",nullable = false)
	private Ejemplar Ejemplar;

	public Orden_Detalle(int Orden_DetalleId,Servicio Servicio, Orden Orden, Ejemplar Ejemplar) {
		super();
		this.Orden_DetalleId = Orden_DetalleId;
		this.Orden = Orden;
		this.Ejemplar = Ejemplar;			
		this.Servicio = Servicio;
	}

	public Orden_Detalle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrden_DetalleId() {
		return Orden_DetalleId;
	}

	public void setOrden_DetalleId(int orden_DetalleId) {
		Orden_DetalleId = orden_DetalleId;
	}

	public Servicio getServicio() {
		return Servicio;
	}

	public void setServicio(Servicio servicio) {
		Servicio = servicio;
	}

	public Orden getOrden() {
		return Orden;
	}

	public void setOrden(Orden orden) {
		Orden = orden;
	}

	public Ejemplar getEjemplar() {
		return Ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		Ejemplar = ejemplar;
	}


	
	


	

}
