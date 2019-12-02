package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Equipo;
import services.IEquipoService;

@Named
@SessionScoped
public class EquipoController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IEquipoService cService;
	private List<Equipo> ListEquipo;
	private Equipo Equipo; 

	@PostConstruct
	public void init() {
		ListEquipo= new ArrayList<Equipo>();
		Equipo= new Equipo();
		this.findall();
	}

	public String newEquipo()
	{
		this.setEquipo(new Equipo());
		return "Equipo.xhmtl";
	}
	
	public void updateInsert()
	{
		try {
			if(Equipo.getEquipoId()>0)
			{
				cService.update(Equipo);
				clean();
			}else {
				cService.insert(Equipo);
				clean();
			}
				this.findall();
		} catch (Exception e) {
			e.getMessage();
		}	
	}
	
	public void delete(Equipo Equipo)
	{
		try {
			cService.delete(Equipo.getEquipoId());
			findall();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public void findall() {
		try {
			ListEquipo= cService.ListAll();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void findbyid(Equipo cat)
	{
		try {
			Equipo=cService.FinbyId(cat.getEquipoId());
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void findbyname()
	{/*
		try {
			if(Equipo.getNameEquipo().isEmpty()) this.findall();
			else ListEquipo=cService.findbyname(this.getEquipo());
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
	
	public List<Equipo> getListEquipo() {
		return ListEquipo;
	}

	public void setListEquipo(List<Equipo> listEquipo) {
		ListEquipo = listEquipo;
	}

	public Equipo getEquipo() {
		return Equipo;
	}

	public void setEquipo(Equipo Equipo) {
		this.Equipo = Equipo;
	}

	
	
}
