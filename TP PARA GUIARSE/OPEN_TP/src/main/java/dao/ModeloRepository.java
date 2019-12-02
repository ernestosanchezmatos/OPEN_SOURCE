package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Modelo;

public class ModeloRepository implements IModeloRepository,Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	public ModeloRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean insert(Modelo Modelo) {
		try {
			em.persist(Modelo);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Modelo Modelo) {
		/*try {
			em.merge(Modelo);
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
		/*Modelo cat = new Modelo();
		
		try {
			cat = em.getReference(Modelo.class, id);
			em.remove(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} */
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Modelo> ListAll() {
	List<Modelo> lista= new ArrayList<Modelo>();
	try {
		Query q = em.createQuery("select c from Modelo c");
		lista= (List<Modelo>)q.getResultList();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return lista;
	}

	@Override
	public Modelo FinbyId(int id) {
		Modelo cat = new Modelo();
		try {
			cat = em.find(Modelo.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Modelo> findbyname(Modelo Modelo) {
		List<Modelo> lista= new ArrayList<Modelo>();
		/*List<Modelo> lista= new ArrayList<Modelo>();
		try {
			Query q = em.createQuery("select c from Modelo c where c.nameModelo like ?1");
			q.setParameter(1, "%"+Modelo.getNameModelo()+"%");
			lista= (List<Modelo>)q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
			return lista;
	}

}
