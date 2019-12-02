package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Distrito;

public class DistritoRepository implements IDistritoRepository,Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	public DistritoRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean insert(Distrito Distrito) {
		try {
			em.persist(Distrito);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Distrito Distrito) {
		/*try {
			em.merge(Distrito);
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
		/*Distrito cat = new Distrito();
		
		try {
			cat = em.getReference(Distrito.class, id);
			em.remove(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} */
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Distrito> ListAll() {
	List<Distrito> lista= new ArrayList<Distrito>();
	try {
		Query q = em.createQuery("select c from Distrito c");
		lista= (List<Distrito>)q.getResultList();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return lista;
	}

	@Override
	public Distrito FinbyId(int id) {
		Distrito cat = new Distrito();
		try {
			cat = em.find(Distrito.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Distrito> findbyname(Distrito Distrito) {
		List<Distrito> lista= new ArrayList<Distrito>();
		/*List<Distrito> lista= new ArrayList<Distrito>();
		try {
			Query q = em.createQuery("select c from Distrito c where c.nameDistrito like ?1");
			q.setParameter(1, "%"+Distrito.getNameDistrito()+"%");
			lista= (List<Distrito>)q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
			return lista;
	}

}
