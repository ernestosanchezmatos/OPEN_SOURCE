package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Ejemplar;

public class EjemplarRepository implements IEjemplarRepository,Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	public EjemplarRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean insert(Ejemplar Ejemplar) {
		try {
			em.persist(Ejemplar);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Ejemplar Ejemplar) {
		/*try {
			em.merge(Ejemplar);
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
		/*Ejemplar cat = new Ejemplar();
		
		try {
			cat = em.getReference(Ejemplar.class, id);
			em.remove(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} */
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ejemplar> ListAll() {
	List<Ejemplar> lista= new ArrayList<Ejemplar>();
	try {
		Query q = em.createQuery("select c from Ejemplar c");
		lista= (List<Ejemplar>)q.getResultList();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return lista;
	}

	@Override
	public Ejemplar FinbyId(int id) {
		Ejemplar cat = new Ejemplar();
		try {
			cat = em.find(Ejemplar.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ejemplar> findbyname(Ejemplar Ejemplar) {
		List<Ejemplar> lista= new ArrayList<Ejemplar>();
		/*List<Ejemplar> lista= new ArrayList<Ejemplar>();
		try {
			Query q = em.createQuery("select c from Ejemplar c where c.nameEjemplar like ?1");
			q.setParameter(1, "%"+Ejemplar.getNameEjemplar()+"%");
			lista= (List<Ejemplar>)q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
			return lista;
	}

}
