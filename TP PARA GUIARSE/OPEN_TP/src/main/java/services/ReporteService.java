package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IReporteRepository;
import entity.Reporte;

@Named
public class ReporteService implements IReporteService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IReporteRepository cpdao;
	
	@Override
	public boolean insert(Reporte Reporte) {
		
		return cpdao.insert(Reporte);	
		}

	@Override
	public boolean update(Reporte Reporte) {
		return cpdao.update(Reporte);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Reporte> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Reporte FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Reporte> findbyname(Reporte Reporte) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Reporte);
	}

}
