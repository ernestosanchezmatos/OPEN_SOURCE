package upc.spring.MyE.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ejemplar")
public class Ejemplar  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer EjemplarId;
	
	@Column(name="NEjemplar",nullable = false,length = 40)
	private String NEjemplar;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ModeloId", nullable = false)	
	private Modelo Modelo;

	public Integer getEjemplarId() {
		return EjemplarId;
	}

	public void setEjemplarId(Integer ejemplarId) {
		EjemplarId = ejemplarId;
	}

	public String getNEjemplar() {
		return NEjemplar;
	}

	public void setNEjemplar(String nEjemplar) {
		NEjemplar = nEjemplar;
	}

	public Modelo getModelo() {
		return Modelo;
	}

	public void setModelo(Modelo modelo) {
		Modelo = modelo;
	}

	public Ejemplar(Integer ejemplarId, String nEjemplar, upc.spring.MyE.model.entity.Modelo modelo) {
		super();
		EjemplarId = ejemplarId;
		NEjemplar = nEjemplar;
		Modelo = modelo;
	}
	
	
}