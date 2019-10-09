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
@Table(name="Ciudad")
public class Ciudad implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CiudadId",nullable = false)
	private int CiudadId; 
	
	@Column(name="NCiudad",nullable = false,length = 40)
	private String NCiudad;	
	
	@ManyToOne
	@JoinColumn(name="ProvinciaId",nullable = false)
	private Provincia Provincia;

	public Ciudad(int CiudadId, String NCiudad,Provincia Provincia) {
		super();
		this.CiudadId = CiudadId;
		this.NCiudad = NCiudad;		
		this.Provincia = Provincia;
	}

	public Ciudad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCiudadId() {
		return CiudadId;
	}

	public void setCiudadId(int CiudadId) {
		this.CiudadId = CiudadId;
	}

	public String getNCiudad() {
		return NCiudad;
	}

	public void setNCiudad(String nCiudad) {
		this.NCiudad = nCiudad;
	}

	public Provincia getProvincia() {
		return Provincia;
	}

	public void setProvincia(Provincia Provincia) {
		this.Provincia = Provincia;
	}


	

}
