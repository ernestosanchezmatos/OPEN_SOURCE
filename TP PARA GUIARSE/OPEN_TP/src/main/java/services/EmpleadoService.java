package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IEmpleadoRepository;
import entity.Empleado;

@Named
public class EmpleadoService implements IEmpleadoService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEmpleadoRepository cpdao;
	
	@Override
	public boolean insert(Empleado Empleado) {
		
		return cpdao.insert(Empleado);	
		}

	@Override
	public boolean update(Empleado Empleado) {
		return cpdao.update(Empleado);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Empleado> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Empleado FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Empleado> findbyname(Empleado Empleado) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Empleado);
	}

}
