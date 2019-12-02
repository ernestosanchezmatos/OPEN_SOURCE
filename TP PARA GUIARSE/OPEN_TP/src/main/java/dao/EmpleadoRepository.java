package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Empleado;

public class EmpleadoRepository implements IEmpleadoRepository,Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	@Override
	@Transactional
	public boolean insert(Empleado Empleado) {
		
		try {
			em.persist(Empleado);
			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return false;
	}

	@Override
	@Transactional
	public boolean update(Empleado Empleado) {
		/*try {
			em.merge(Empleado);
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
		Empleado prod = new Empleado();
		try {
			
		prod = em.find(Empleado.class,id);
		em.remove(prod);
		return true; 
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}*/
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> ListAll() {
		List<Empleado> lista= new ArrayList<Empleado>();
		try {
			Query q = em.createQuery("select c from Empleado c");
			lista = (List<Empleado>)q.getResultList();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public Empleado FinbyId(int id) {
		Empleado pr = new Empleado();
		try {
			pr= em.find(Empleado.class, id);
		
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return pr;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> findbyname(Empleado Empleado) {
		List<Empleado> lista= new ArrayList<Empleado>();
		/*List<Empleado> lista= new ArrayList<Empleado>();
		try {
			Query q = em.createQuery("select c from Empleado c where c.nameEmpleado like ?1");
			q.setParameter(1, "%"+Empleado.getNameEmpleado()+"%");
			lista = (List<Empleado>)q.getResultList();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		*/
		return lista;
	}


}
