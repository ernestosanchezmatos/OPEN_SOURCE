package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Persona;
import services.IPersonaService;

@Named
@SessionScoped
public class PersonaController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IPersonaService cService;
	private List<Persona> ListPersona;
	private Persona Persona; 

	@PostConstruct
	public void init() {
		ListPersona= new ArrayList<Persona>();
		Persona= new Persona();
		this.findall();
	}

	public String newPersona()
	{
		this.setPersona(new Persona());
		return "Persona.xhmtl";
	}
	
	public void updateInsert()
	{
		try {
			if(Persona.getPersonaId()>0)
			{
				cService.update(Persona);
				clean();
			}else {
				cService.insert(Persona);
				clean();
			}
				this.findall();
		} catch (Exception e) {
			e.getMessage();
		}	
	}
	
	public void delete(Persona Persona)
	{
		try {
			cService.delete(Persona.getPersonaId());
			findall();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public void findall() {
		try {
			ListPersona= cService.ListAll();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void findbyid(Persona cat)
	{
		try {
			Persona=cService.FinbyId(cat.getPersonaId());
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void findbyname()
	{/*
		try {
			if(Persona.getNamePersona().isEmpty()) this.findall();
			else ListPersona=cService.findbyname(this.getPersona());
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		*/
	}
	public void clean()
	{
		this.init();
	}
	
	//get y set
	
	public List<Persona> getListPersona() {
		return ListPersona;
	}

	public void setListPersona(List<Persona> listPersona) {
		ListPersona = listPersona;
	}

	public Persona getPersona() {
		return Persona;
	}

	public void setPersona(Persona Persona) {
		this.Persona = Persona;
	}

	
	
}
