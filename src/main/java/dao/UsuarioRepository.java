package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Usuario;

public class UsuarioRepository implements IUsuarioRepository,Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	public UsuarioRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean insert(Usuario Usuario) {
		try {
			em.persist(Usuario);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Usuario Usuario) {
		/*try {
			em.merge(Usuario);
			return true; 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		return false;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		/*Usuario cat = new Usuario();
		
		try {
			cat = em.getReference(Usuario.class, id);
			em.remove(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} */
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> ListAll() {
	List<Usuario> lista= new ArrayList<Usuario>();
	try {
		Query q = em.createQuery("select c from Usuario c");
		lista= (List<Usuario>)q.getResultList();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return lista;
	}

	@Override
	public Usuario FinbyId(int id) {
		Usuario cat = new Usuario();
		try {
			cat = em.find(Usuario.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findbyname(Usuario Usuario) {
		List<Usuario> lista= new ArrayList<Usuario>();
		/*List<Usuario> lista= new ArrayList<Usuario>();
		try {
			Query q = em.createQuery("select c from Usuario c where c.nameUsuario like ?1");
			q.setParameter(1, "%"+Usuario.getNameUsuario()+"%");
			lista= (List<Usuario>)q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
			return lista;
	}

}
