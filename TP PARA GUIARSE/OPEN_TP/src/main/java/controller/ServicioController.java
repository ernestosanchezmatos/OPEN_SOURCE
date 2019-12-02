package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Servicio;
import services.IServicioService;

@Named
@SessionScoped
public class ServicioController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IServicioService cService;
	private List<Servicio> ListServicio;
	private Servicio Servicio; 

	@PostConstruct
	public void init() {
		ListServicio= new ArrayList<Servicio>();
		Servicio= new Servicio();
		this.findall();
	}

	public String newServicio()
	{
		this.setServicio(new Servicio());
		return "Servicio.xhmtl";
	}
	
	public void updateInsert()
	{
		try {
			if(Servicio.getServicioId()>0)
			{
				cService.update(Servicio);
				clean();
			}else {
				cService.insert(Servicio);
				clean();
			}
				this.findall();
		} catch (Exception e) {
			e.getMessage();
		}	
	}
	
	public void delete(Servicio Servicio)
	{
		try {
			cService.delete(Servicio.getServicioId());
			findall();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public void findall() {
		try {
			ListServicio= cService.ListAll();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void findbyid(Servicio cat)
	{
		try {
			Servicio=cService.FinbyId(cat.getServicioId());
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void findbyname()
	{/*
		try {
			if(Servicio.getNameServicio().isEmpty()) this.findall();
			else ListServicio=cService.findbyname(this.getServicio());
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
	
	public List<Servicio> getListServicio() {
		return ListServicio;
	}

	public void setListServicio(List<Servicio> listServicio) {
		ListServicio = listServicio;
	}

	public Servicio getServicio() {
		return Servicio;
	}

	public void setServicio(Servicio Servicio) {
		this.Servicio = Servicio;
	}

	
	
}
