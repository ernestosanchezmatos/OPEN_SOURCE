package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IOrden_DetalleRepository;
import entity.Orden_Detalle;

@Named
public class Orden_DetalleService implements IOrden_DetalleService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IOrden_DetalleRepository cpdao;
	
	@Override
	public boolean insert(Orden_Detalle Orden_Detalle) {
		
		return cpdao.insert(Orden_Detalle);	
		}

	@Override
	public boolean update(Orden_Detalle Orden_Detalle) {
		return cpdao.update(Orden_Detalle);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Orden_Detalle> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Orden_Detalle FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Orden_Detalle> findbyname(Orden_Detalle Orden_Detalle) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Orden_Detalle);
	}

}
