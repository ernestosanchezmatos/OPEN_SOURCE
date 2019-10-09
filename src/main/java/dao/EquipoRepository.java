package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Equipo;

public class EquipoRepository implements IEquipoRepository,Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	@Override
	@Transactional
	public boolean insert(Equipo Equipo) {
		
		try {
			em.persist(Equipo);
			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return false;
	}

	@Override
	@Transactional
	public boolean update(Equipo Equipo) {
		/*try {
			em.merge(Equipo);
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
		Equipo prod = new Equipo();
		try {
			
		prod = em.find(Equipo.class,id);
		em.remove(prod);
		return true; 
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}*/
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipo> ListAll() {
		List<Equipo> lista= new ArrayList<Equipo>();
		try {
			Query q = em.createQuery("select c from Equipo c");
			lista = (List<Equipo>)q.getResultList();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public Equipo FinbyId(int id) {
		Equipo pr = new Equipo();
		try {
			pr= em.find(Equipo.class, id);
		
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return pr;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipo> findbyname(Equipo Equipo) {
		List<Equipo> lista= new ArrayList<Equipo>();
		/*List<Equipo> lista= new ArrayList<Equipo>();
		try {
			Query q = em.createQuery("select c from Equipo c where c.nameEquipo like ?1");
			q.setParameter(1, "%"+Equipo.getNameEquipo()+"%");
			lista = (List<Equipo>)q.getResultList();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		*/
		return lista;
	}


}
