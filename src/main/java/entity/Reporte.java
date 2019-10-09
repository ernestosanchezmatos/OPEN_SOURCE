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
@Table(name="Reporte")
public class Reporte implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ReporteId",nullable = false)
	private int ReporteId; 
	
	@Column(name="FechaGeneracion",nullable = false,length = 40)
	private String FechaGeneracion;	
	
	@Column(name="FechaEjecucion",nullable = false,length = 40)
	private String FechaEjecucion;	
	
	@ManyToOne
	@JoinColumn(name="Orden_DetalleId",nullable = false)
	private Orden_Detalle Orden_Detalle;

	public Reporte(int ReporteId, String FechaEjecucion,String FechaGeneracion,Orden_Detalle Orden_Detalle) {
		super();
		this.ReporteId = ReporteId;
		this.FechaEjecucion = FechaEjecucion;		
		this.FechaGeneracion = FechaGeneracion;		
		this.Orden_Detalle = Orden_Detalle;
	}

	public Reporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReporteId() {
		return ReporteId;
	}

	public void setReporteId(int reporteId) {
		ReporteId = reporteId;
	}

	public String getFechaGeneracion() {
		return FechaGeneracion;
	}

	public void setFechaGeneracion(String fechaGeneracion) {
		FechaGeneracion = fechaGeneracion;
	}

	public String getFechaEjecucion() {
		return FechaEjecucion;
	}

	public void setFechaEjecucion(String fechaEjecucion) {
		FechaEjecucion = fechaEjecucion;
	}

	public Orden_Detalle getOrden_Detalle() {
		return Orden_Detalle;
	}

	public void setOrden_Detalle(Orden_Detalle orden_Detalle) {
		Orden_Detalle = orden_Detalle;
	}




	

}
