package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="Departamento")

public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DepartamentoId",nullable = false)
	private int DepartamentoId; 
	
	@Column(name="NDepartamento",nullable = false,length = 40)
	private String NDepartamento;

	public Departamento(int DepartamentoId, String NDepartamento) {
		super();
		this.DepartamentoId = DepartamentoId;
		this.NDepartamento = NDepartamento;
	}
	
	public Departamento()
	{
		super();
	}
	public int getDepartamentoId() {
		return DepartamentoId;
	}

	public void setDepartamentoId(int departamentoId) {
		DepartamentoId = departamentoId;
	}

	public String getNDepartamento() {
		return NDepartamento;
	}

	public void setNDepartamento(String nDepartamento) {
		NDepartamento = nDepartamento;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + DepartamentoId;
		result = prime * result + ((NDepartamento == null) ? 0 : NDepartamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (DepartamentoId != other.DepartamentoId)
			return false;
		if (NDepartamento == null) {
			if (other.NDepartamento != null)
				return false;
		} else if (!NDepartamento.equals(other.NDepartamento))
			return false;
		return true;
	}
	
	

}
