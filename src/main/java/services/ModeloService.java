package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IModeloRepository;
import entity.Modelo;

@Named
public class ModeloService implements IModeloService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IModeloRepository cpdao;
	
	@Override
	public boolean insert(Modelo Modelo) {
		
		return cpdao.insert(Modelo);	
		}

	@Override
	public boolean update(Modelo Modelo) {
		return cpdao.update(Modelo);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Modelo> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Modelo FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Modelo> findbyname(Modelo Modelo) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Modelo);
	}

}
