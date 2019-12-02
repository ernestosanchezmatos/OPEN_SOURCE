package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IDistritoRepository;
import entity.Distrito;

@Named
public class DistritoService implements IDistritoService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDistritoRepository cpdao;
	
	@Override
	public boolean insert(Distrito Distrito) {
		
		return cpdao.insert(Distrito);	
		}

	@Override
	public boolean update(Distrito Distrito) {
		return cpdao.update(Distrito);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Distrito> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Distrito FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Distrito> findbyname(Distrito Distrito) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Distrito);
	}

}
