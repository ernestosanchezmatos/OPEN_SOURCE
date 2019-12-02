package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Orden;

public class OrdenRepository implements IOrdenRepository,Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	public OrdenRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean insert(Orden Orden) {
		try {
			em.persist(Orden);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Orden Orden) {
		/*try {
			em.merge(Orden);
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
		/*Orden cat = new Orden();
		
		try {
			cat = em.getReference(Orden.class, id);
			em.remove(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} */
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Orden> ListAll() {
	List<Orden> lista= new ArrayList<Orden>();
	try {
		Query q = em.createQuery("select c from Orden c");
		lista= (List<Orden>)q.getResultList();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return lista;
	}

	@Override
	public Orden FinbyId(int id) {
		Orden cat = new Orden();
		try {
			cat = em.find(Orden.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orden> findbyname(Orden Orden) {
		List<Orden> lista= new ArrayList<Orden>();
		/*List<Orden> lista= new ArrayList<Orden>();
		try {
			Query q = em.createQuery("select c from Orden c where c.nameOrden like ?1");
			q.setParameter(1, "%"+Orden.getNameOrden()+"%");
			lista= (List<Orden>)q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
			return lista;
	}

}
