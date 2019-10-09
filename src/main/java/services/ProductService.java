package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IDepartamentoRepository;
import entity.Departamento;

@Named
public class ProductService implements IProductService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDepartamentoRepository cpdao;
	
	@Override
	public boolean insert(Departamento product) {
		
		return cpdao.insert(product);	
		}

	@Override
	public boolean update(Departamento product) {
		return cpdao.update(product);
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
	public List<Departamento> findbyname(Departamento product) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(product);
	}

}
