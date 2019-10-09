package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Persona;

public class PersonaRepository implements IPersonaRepository,Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	@Override
	@Transactional
	public boolean insert(Persona Persona) {
		
		try {
			em.persist(Persona);
			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return false;
	}

	@Override
	@Transactional
	public boolean update(Persona Persona) {
		/*try {
			em.merge(Persona);
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
		Persona prod = new Persona();
		try {
			
		prod = em.find(Persona.class,id);
		em.remove(prod);
		return true; 
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}*/
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> ListAll() {
		List<Persona> lista= new ArrayList<Persona>();
		try {
			Query q = em.createQuery("select c from Persona c");
			lista = (List<Persona>)q.getResultList();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public Persona FinbyId(int id) {
		Persona pr = new Persona();
		try {
			pr= em.find(Persona.class, id);
		
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return pr;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> findbyname(Persona Persona) {
		List<Persona> lista= new ArrayList<Persona>();
		/*List<Persona> lista= new ArrayList<Persona>();
		try {
			Query q = em.createQuery("select c from Persona c where c.namePersona like ?1");
			q.setParameter(1, "%"+Persona.getNamePersona()+"%");
			lista = (List<Persona>)q.getResultList();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		*/
		return lista;
	}


}
