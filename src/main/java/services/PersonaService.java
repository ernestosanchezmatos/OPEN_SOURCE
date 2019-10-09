package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IPersonaRepository;
import entity.Persona;

@Named
public class PersonaService implements IPersonaService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPersonaRepository cpdao;
	
	@Override
	public boolean insert(Persona Persona) {
		
		return cpdao.insert(Persona);	
		}

	@Override
	public boolean update(Persona Persona) {
		return cpdao.update(Persona);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Persona> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Persona FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Persona> findbyname(Persona Persona) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Persona);
	}

}
