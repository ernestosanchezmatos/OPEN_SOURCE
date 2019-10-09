package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Departamento;
import services.IDepartamentoService;

@Named
@SessionScoped
public class DepartamentoController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IDepartamentoService cService;
	private List<Departamento> ListDepartamento;
	private Departamento Departamento; 

	@PostConstruct
	public void init() {
		ListDepartamento= new ArrayList<Departamento>();
		Departamento= new Departamento();
		this.findall();
	}

	public String newDepartamento()
	{
		this.setDepartamento(new Departamento());
		return "Departamento.xhmtl";
	}
	
	public void updateInsert()
	{
		try {
			if(Departamento.getDepartamentoId()>0)
			{
				cService.update(Departamento);
				clean();
			}else {
				cService.insert(Departamento);
				clean();
			}
				this.findall();
		} catch (Exception e) {
			e.getMessage();
		}	
	}
	
	public void delete(Departamento Departamento)
	{
		try {
			cService.delete(Departamento.getDepartamentoId());
			findall();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public void findall() {
		try {
			ListDepartamento= cService.ListAll();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void findbyid(Departamento cat)
	{
		try {
			Departamento=cService.FinbyId(cat.getDepartamentoId());
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void findbyname()
	{/*
		try {
			if(Departamento.getNameDepartamento().isEmpty()) this.findall();
			else ListDepartamento=cService.findbyname(this.getDepartamento());
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
	
	public List<Departamento> getListDepartamento() {
		return ListDepartamento;
	}

	public void setListDepartamento(List<Departamento> listDepartamento) {
		ListDepartamento = listDepartamento;
	}

	public Departamento getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(Departamento Departamento) {
		this.Departamento = Departamento;
	}

	
	
}
