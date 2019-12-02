package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.ILugarRepository;
import entity.Lugar;

@Named
public class LugarService implements ILugarService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ILugarRepository cpdao;
	
	@Override
	public boolean insert(Lugar Lugar) {
		
		return cpdao.insert(Lugar);	
		}

	@Override
	public boolean update(Lugar Lugar) {
		return cpdao.update(Lugar);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Lugar> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Lugar FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Lugar> findbyname(Lugar Lugar) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Lugar);
	}

}
