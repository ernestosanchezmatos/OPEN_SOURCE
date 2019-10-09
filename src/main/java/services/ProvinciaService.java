package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IProvinciaRepository;
import entity.Provincia;

@Named
public class ProvinciaService implements IProvinciaService,Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IProvinciaRepository cdao; 
	
	@Override
	public boolean insert(Provincia Provincia) {
		return cdao.insert(Provincia);
	}

	@Override
	public boolean update(Provincia Provincia) {
		// TODO Auto-generated method stub
		return cdao.update(Provincia);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return cdao.delete(id);
	}

	@Override
	public List<Provincia> ListAll() {
		// TODO Auto-generated method stub
		return cdao.ListAll();
	}

	@Override
	public Provincia FinbyId(int id) {
		// TODO Auto-generated method stub
		return cdao.FinbyId(id);
	}

	@Override
	public List<Provincia> findbyname(Provincia Provincia) {
		// TODO Auto-generated method stub
		return cdao.findbyname(Provincia);
	}

	
}
