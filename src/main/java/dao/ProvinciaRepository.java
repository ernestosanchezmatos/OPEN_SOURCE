package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Provincia;

public class ProvinciaRepository implements IProvinciaRepository,Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	public ProvinciaRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean insert(Provincia Provincia) {
		try {
			em.persist(Provincia);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Provincia Provincia) {
		/*try {
			em.merge(Provincia);
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
		/*Provincia cat = new Provincia();
		
		try {
			cat = em.getReference(Provincia.class, id);
			em.remove(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} */
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> ListAll() {
	List<Provincia> lista= new ArrayList<Provincia>();
	try {
		Query q = em.createQuery("select c from Provincia c");
		lista= (List<Provincia>)q.getResultList();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return lista;
	}

	@Override
	public Provincia FinbyId(int id) {
		Provincia cat = new Provincia();
		try {
			cat = em.find(Provincia.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> findbyname(Provincia Provincia) {
		List<Provincia> lista= new ArrayList<Provincia>();
		/*List<Provincia> lista= new ArrayList<Provincia>();
		try {
			Query q = em.createQuery("select c from Provincia c where c.nameProvincia like ?1");
			q.setParameter(1, "%"+Provincia.getNameProvincia()+"%");
			lista= (List<Provincia>)q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
			return lista;
	}

}
