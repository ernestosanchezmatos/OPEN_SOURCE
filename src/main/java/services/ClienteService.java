package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IClienteRepository;
import entity.Cliente;

@Named
public class ClienteService implements IClienteService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IClienteRepository cpdao;
	
	@Override
	public boolean insert(Cliente Cliente) {
		
		return cpdao.insert(Cliente);	
		}

	@Override
	public boolean update(Cliente Cliente) {
		return cpdao.update(Cliente);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Cliente> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Cliente FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Cliente> findbyname(Cliente Cliente) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Cliente);
	}

}
