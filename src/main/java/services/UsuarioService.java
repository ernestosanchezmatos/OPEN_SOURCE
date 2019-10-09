package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IUsuarioRepository;
import entity.Usuario;

@Named
public class UsuarioService implements IUsuarioService,Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUsuarioRepository cpdao;
	
	@Override
	public boolean insert(Usuario Usuario) {
		
		return cpdao.insert(Usuario);	
		}

	@Override
	public boolean update(Usuario Usuario) {
		return cpdao.update(Usuario);
		}

	@Override
	public boolean delete(int id) {
		return cpdao.delete(id);
	}

	@Override
	public List<Usuario> ListAll() {
		return cpdao.ListAll();
	}

	@Override
	public Usuario FinbyId(int id) {
		
		return cpdao.FinbyId(id);
	}

	@Override
	public List<Usuario> findbyname(Usuario Usuario) {
		// TODO Auto-generated method stub
		return cpdao.findbyname(Usuario);
	}

}
