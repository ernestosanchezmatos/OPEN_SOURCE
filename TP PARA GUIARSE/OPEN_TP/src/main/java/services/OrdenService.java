package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IOrdenRepository;
import entity.Orden;

@Named
public class OrdenService implements IOrdenService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IOrdenRepository cpdao;
	
	@Override
	public boolean insert(Orden Orden) {
		
		return cpdao.insert(Orden);	
		}

	@Override
	public boolean update(Orden Orden) {
		return cpdao.update(Orden);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Orden> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Orden FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Orden> findbyname(Orden Orden) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Orden);
	}

}
