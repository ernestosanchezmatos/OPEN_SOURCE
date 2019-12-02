package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.ICiudadRepository;
import entity.Ciudad;

@Named
public class CiudadService implements ICiudadService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICiudadRepository cpdao;
	
	@Override
	public boolean insert(Ciudad Ciudad) {
		
		return cpdao.insert(Ciudad);	
		}

	@Override
	public boolean update(Ciudad Ciudad) {
		return cpdao.update(Ciudad);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Ciudad> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Ciudad FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Ciudad> findbyname(Ciudad Ciudad) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Ciudad);
	}

}
