package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IEquipoRepository;
import entity.Equipo;

@Named
public class EquipoService implements IEquipoService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEquipoRepository cpdao;
	
	@Override
	public boolean insert(Equipo Equipo) {
		
		return cpdao.insert(Equipo);	
		}

	@Override
	public boolean update(Equipo Equipo) {
		return cpdao.update(Equipo);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Equipo> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Equipo FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Equipo> findbyname(Equipo Equipo) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Equipo);
	}

}
