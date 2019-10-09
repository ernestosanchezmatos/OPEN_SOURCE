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
	@JoinColumn(name="DistritoId",nullable = false)
	private Distrito Distrito;

	public Reporte(int ReporteId, String FechaEjecucion,String FechaGeneracion,Distrito Distrito) {
		super();
		this.ReporteId = ReporteId;
		this.FechaEjecucion = FechaEjecucion;		
		this.FechaGeneracion = FechaGeneracion;		
		this.Distrito = Distrito;
	}

	public Reporte() {
		super();
		// TODO Auto-generated constructor stub
	}




	

}
