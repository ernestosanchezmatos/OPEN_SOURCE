package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IEjemplarRepository;
import entity.Ejemplar;

@Named
public class EjemplarService implements IEjemplarService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEjemplarRepository cpdao;
	
	@Override
	public boolean insert(Ejemplar Ejemplar) {
		
		return cpdao.insert(Ejemplar);	
		}

	@Override
	public boolean update(Ejemplar Ejemplar) {
		return cpdao.update(Ejemplar);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Ejemplar> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Ejemplar FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Ejemplar> findbyname(Ejemplar Ejemplar) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Ejemplar);
	}

}
