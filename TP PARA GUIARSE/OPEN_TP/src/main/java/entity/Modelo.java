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
@Table(name="Modelo")
public class Modelo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ModeloId",nullable = false)
	private int ModeloId; 
	
	@Column(name="SerieModelo",nullable = false,length = 40)
	private String SerieModelo;	
	
	@ManyToOne
	@JoinColumn(name="EquipoId",nullable = false)
	private Equipo Equipo;

	public Modelo(int ModeloId, String SerieModelo,Equipo Equipo) {
		super();
		this.ModeloId = ModeloId;
		this.SerieModelo = SerieModelo;		
		this.Equipo = Equipo;
	}

	public Modelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getModeloId() {
		return ModeloId;
	}

	public void setModeloId(int ModeloId) {
		this.ModeloId = ModeloId;
	}

	public String getSerieModelo() {
		return SerieModelo;
	}

	public void setSerieModelo(String SerieModelo) {
		this.SerieModelo = SerieModelo;
	}

	public Equipo getEquipo() {
		return Equipo;
	}

	public void setEquipo(Equipo Equipo) {
		this.Equipo = Equipo;
	}


	

}
