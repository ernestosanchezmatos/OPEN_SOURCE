package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Lugar_Personas;

public class Lugar_PersonasRepository implements ILugar_PersonasRepository,Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	public Lugar_PersonasRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean insert(Lugar_Personas Lugar_Personas) {
		try {
			em.persist(Lugar_Personas);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Lugar_Personas Lugar_Personas) {
		/*try {
			em.merge(Lugar_Personas);
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
		/*Lugar_Personas cat = new Lugar_Personas();
		
		try {
			cat = em.getReference(Lugar_Personas.class, id);
			em.remove(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} */
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Lugar_Personas> ListAll() {
	List<Lugar_Personas> lista= new ArrayList<Lugar_Personas>();
	try {
		Query q = em.createQuery("select c from Lugar_Personas c");
		lista= (List<Lugar_Personas>)q.getResultList();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return lista;
	}

	@Override
	public Lugar_Personas FinbyId(int id) {
		Lugar_Personas cat = new Lugar_Personas();
		try {
			cat = em.find(Lugar_Personas.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lugar_Personas> findbyname(Lugar_Personas Lugar_Personas) {
		List<Lugar_Personas> lista= new ArrayList<Lugar_Personas>();
		/*List<Lugar_Personas> lista= new ArrayList<Lugar_Personas>();
		try {
			Query q = em.createQuery("select c from Lugar_Personas c where c.nameLugar_Personas like ?1");
			q.setParameter(1, "%"+Lugar_Personas.getNameLugar_Personas()+"%");
			lista= (List<Lugar_Personas>)q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
			return lista;
	}

}
