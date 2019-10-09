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
@Table(name="Ejemplar")
public class Ejemplar implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EjemplarId",nullable = false)
	private int EjemplarId; 
	
	@Column(name="NumSerie",nullable = false,length = 40)
	private String NumSerie;	
	
	@ManyToOne
	@JoinColumn(name="ModeloId",nullable = false)
	private Modelo Modelo;

	public Ejemplar(int EjemplarId, String NumSerie,Modelo Modelo) {
		super();
		this.EjemplarId = EjemplarId;
		this.NumSerie = NumSerie;		
		this.Modelo = Modelo;
	}

	public Ejemplar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEjemplarId() {
		return EjemplarId;
	}

	public void setEjemplarId(int EjemplarId) {
		this.EjemplarId = EjemplarId;
	}

	public String getNumSerie() {
		return NumSerie;
	}

	public void setNumSerie(String NumSerie) {
		this.NumSerie = NumSerie;
	}

	public Modelo getModelo() {
		return Modelo;
	}

	public void setModelo(Modelo Modelo) {
		this.Modelo = Modelo;
	}


	

}
