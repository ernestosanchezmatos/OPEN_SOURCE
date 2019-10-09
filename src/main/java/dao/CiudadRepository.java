package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Ciudad;

public class CiudadRepository implements ICiudadRepository,Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	public CiudadRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean insert(Ciudad Ciudad) {
		try {
			em.persist(Ciudad);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Ciudad Ciudad) {
		/*try {
			em.merge(Ciudad);
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
		/*Ciudad cat = new Ciudad();
		
		try {
			cat = em.getReference(Ciudad.class, id);
			em.remove(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} */
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> ListAll() {
	List<Ciudad> lista= new ArrayList<Ciudad>();
	try {
		Query q = em.createQuery("select c from Ciudad c");
		lista= (List<Ciudad>)q.getResultList();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return lista;
	}

	@Override
	public Ciudad FinbyId(int id) {
		Ciudad cat = new Ciudad();
		try {
			cat = em.find(Ciudad.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> findbyname(Ciudad Ciudad) {
		List<Ciudad> lista= new ArrayList<Ciudad>();
		/*List<Ciudad> lista= new ArrayList<Ciudad>();
		try {
			Query q = em.createQuery("select c from Ciudad c where c.nameCiudad like ?1");
			q.setParameter(1, "%"+Ciudad.getNameCiudad()+"%");
			lista= (List<Ciudad>)q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
			return lista;
	}

}
