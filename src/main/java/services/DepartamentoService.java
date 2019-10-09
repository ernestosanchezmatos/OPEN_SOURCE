package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IDepartamentoRepository;
import entity.Departamento;

@Named
public class DepartamentoService implements IDepartamentoService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDepartamentoRepository cpdao;
	
	@Override
	public boolean insert(Departamento Departamento) {
		
		return cpdao.insert(Departamento);	
		}

	@Override
	public boolean update(Departamento Departamento) {
		return cpdao.update(Departamento);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Departamento> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Departamento FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Departamento> findbyname(Departamento Departamento) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Departamento);
	}

}
