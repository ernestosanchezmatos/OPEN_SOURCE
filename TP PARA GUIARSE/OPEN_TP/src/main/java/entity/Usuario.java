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
@Table(name="Usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UsuarioId",nullable = false)
	private int UsuarioId; 
	
	@Column(name="nombreusuario",nullable = false,length = 40)
	private String nombreusuario;	
	
	@Column(name="psw",nullable = false,length = 40)
	private String psw;	
	
	@ManyToOne
	@JoinColumn(name="PersonaId",nullable = false)
	private Persona Persona;

	public Usuario(int UsuarioId, String nombreusuario,Persona Persona, String psw) {
		super();
		this.UsuarioId = UsuarioId;
		this.nombreusuario = nombreusuario;		
		this.Persona = Persona;
		this.psw= psw;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUsuarioId() {
		return UsuarioId;
	}

	public void setUsuarioId(int UsuarioId) {
		this.UsuarioId = UsuarioId;
	}

	public String getnombreusuario() {
		return nombreusuario;
	}

	public void setnombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public Persona getPersona() {
		return Persona;
	}

	public void setPersona(Persona Persona) {
		this.Persona = Persona;
	}

	public String getpsw() {
		return psw;
	}

	public void setpsw(String psw) {
		this.psw = psw;
	}


	

}
