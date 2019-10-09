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
@Table(name="Lugar")
public class Lugar implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LugarId",nullable = false)
	private int LugarId; 
	
	@Column(name="NLugar",nullable = false,length = 40)
	private String NLugar;	
	
	@ManyToOne
	@JoinColumn(name="DistritoId",nullable = false)
	private Distrito Distrito;

	public Lugar(int LugarId, String NLugar,Distrito Distrito) {
		super();
		this.LugarId = LugarId;
		this.NLugar = NLugar;		
		this.Distrito = Distrito;
	}

	public Lugar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLugarId() {
		return LugarId;
	}

	public void setLugarId(int LugarId) {
		this.LugarId = LugarId;
	}

	public String getNLugar() {
		return NLugar;
	}

	public void setNLugar(String nLugar) {
		this.NLugar = nLugar;
	}

	public Distrito getDistrito() {
		return Distrito;
	}

	public void setDistrito(Distrito Distrito) {
		this.Distrito = Distrito;
	}


	

}
