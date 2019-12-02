package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.ILugar_PersonasRepository;
import entity.Lugar_Personas;

@Named
public class Lugar_PersonasService implements ILugar_PersonasService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ILugar_PersonasRepository cpdao;
	
	@Override
	public boolean insert(Lugar_Personas Lugar_Personas) {
		
		return cpdao.insert(Lugar_Personas);	
		}

	@Override
	public boolean update(Lugar_Personas Lugar_Personas) {
		return cpdao.update(Lugar_Personas);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Lugar_Personas> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Lugar_Personas FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Lugar_Personas> findbyname(Lugar_Personas Lugar_Personas) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Lugar_Personas);
	}

}
