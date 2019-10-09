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
@Table(name="Provincia")
public class Provincia implements SeriaSlizable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ProvinciaId",nullable = false)
	private int ProvinciaId; 
	
	@Column(name="NProvincia",nullable = false,length = 40)
	private String NProvincia;	
	
	@ManyToOne
	@JoinColumn(name="DepartamentoId",nullable = false)
	private Departamento Departamento;

	public Provincia(int ProvinciaId, String NProvincia,Departamento Departamento) {
		super();
		this.ProvinciaId = ProvinciaId;
		this.NProvincia = NProvincia;		
		this.Departamento = Departamento;
	}

	public Provincia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProvinciaId() {
		return ProvinciaId;
	}

	public void setProvinciaId(int provinciaId) {
		this.ProvinciaId = provinciaId;
	}

	public String getNProvincia() {
		return NProvincia;
	}

	public void setNProvincia(String nProvincia) {
		this.NProvincia = nProvincia;
	}

	public Departamento getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.Departamento = departamento;
	}


	

}
