package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IServicioRepository;
import entity.Servicio;

@Named
public class ServicioService implements IServicioService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IServicioRepository cpdao;
	
	@Override
	public boolean insert(Servicio Servicio) {
		
		return cpdao.insert(Servicio);	
		}

	@Override
	public boolean update(Servicio Servicio) {
		return cpdao.update(Servicio);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Servicio> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Servicio FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Servicio> findbyname(Servicio Servicio) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Servicio);
	}

}
