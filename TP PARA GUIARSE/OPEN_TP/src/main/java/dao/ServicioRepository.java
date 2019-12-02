package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Servicio;

public class ServicioRepository implements IServicioRepository,Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	@Override
	@Transactional
	public boolean insert(Servicio Servicio) {
		
		try {
			em.persist(Servicio);
			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return false;
	}

	@Override
	@Transactional
	public boolean update(Servicio Servicio) {
		/*try {
			em.merge(Servicio);
			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}*/
		return false;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		/*
		Servicio prod = new Servicio();
		try {
			
		prod = em.find(Servicio.class,id);
		em.remove(prod);
		return true; 
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}*/
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> ListAll() {
		List<Servicio> lista= new ArrayList<Servicio>();
		try {
			Query q = em.createQuery("select c from Servicio c");
			lista = (List<Servicio>)q.getResultList();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public Servicio FinbyId(int id) {
		Servicio pr = new Servicio();
		try {
			pr= em.find(Servicio.class, id);
		
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return pr;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> findbyname(Servicio Servicio) {
		List<Servicio> lista= new ArrayList<Servicio>();
		/*List<Servicio> lista= new ArrayList<Servicio>();
		try {
			Query q = em.createQuery("select c from Servicio c where c.nameServicio like ?1");
			q.setParameter(1, "%"+Servicio.getNameServicio()+"%");
			lista = (List<Servicio>)q.getResultList();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		*/
		return lista;
	}


}
