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
@Table(name="Distrito")
public class Distrito implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DistritoId",nullable = false)
	private int DistritoId; 
	
	@Column(name="NDistrito",nullable = false,length = 40)
	private String NDistrito;	
	
	@ManyToOne
	@JoinColumn(name="CiudadId",nullable = false)
	private Ciudad Ciudad;

	public Distrito(int DistritoId, String NDistrito,Ciudad Ciudad) {
		super();
		this.DistritoId = DistritoId;
		this.NDistrito = NDistrito;		
		this.Ciudad = Ciudad;
	}

	public Distrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDistritoId() {
		return DistritoId;
	}

	public void setDistritoId(int DistritoId) {
		this.DistritoId = DistritoId;
	}

	public String getNDistrito() {
		return NDistrito;
	}

	public void setNDistrito(String nDistrito) {
		this.NDistrito = nDistrito;
	}

	public Ciudad getCiudad() {
		return Ciudad;
	}

	public void setCiudad(Ciudad Ciudad) {
		this.Ciudad = Ciudad;
	}


	

}
