package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Lugar;

public class LugarRepository implements ILugarRepository,Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	public LugarRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean insert(Lugar Lugar) {
		try {
			em.persist(Lugar);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Lugar Lugar) {
		/*try {
			em.merge(Lugar);
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
		/*Lugar cat = new Lugar();
		
		try {
			cat = em.getReference(Lugar.class, id);
			em.remove(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} */
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Lugar> ListAll() {
	List<Lugar> lista= new ArrayList<Lugar>();
	try {
		Query q = em.createQuery("select c from Lugar c");
		lista= (List<Lugar>)q.getResultList();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return lista;
	}

	@Override
	public Lugar FinbyId(int id) {
		Lugar cat = new Lugar();
		try {
			cat = em.find(Lugar.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lugar> findbyname(Lugar Lugar) {
		List<Lugar> lista= new ArrayList<Lugar>();
		/*List<Lugar> lista= new ArrayList<Lugar>();
		try {
			Query q = em.createQuery("select c from Lugar c where c.nameLugar like ?1");
			q.setParameter(1, "%"+Lugar.getNameLugar()+"%");
			lista= (List<f>)q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
			return lista;
	}

}
