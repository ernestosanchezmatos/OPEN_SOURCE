package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Orden_Detalle;

public class Orden_DetalleRepository implements IOrden_DetalleRepository,Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	public Orden_DetalleRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean insert(Orden_Detalle Orden_Detalle) {
		try {
			em.persist(Orden_Detalle);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Orden_Detalle Orden_Detalle) {
		/*try {
			em.merge(Orden_Detalle);
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
		/*Orden_Detalle cat = new Orden_Detalle();
		
		try {
			cat = em.getReference(Orden_Detalle.class, id);
			em.remove(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} */
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Orden_Detalle> ListAll() {
	List<Orden_Detalle> lista= new ArrayList<Orden_Detalle>();
	try {
		Query q = em.createQuery("select c from Orden_Detalle c");
		lista= (List<Orden_Detalle>)q.getResultList();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return lista;
	}

	@Override
	public Orden_Detalle FinbyId(int id) {
		Orden_Detalle cat = new Orden_Detalle();
		try {
			cat = em.find(Orden_Detalle.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orden_Detalle> findbyname(Orden_Detalle Orden_Detalle) {
		List<Orden_Detalle> lista= new ArrayList<Orden_Detalle>();
		/*List<Orden_Detalle> lista= new ArrayList<Orden_Detalle>();
		try {
			Query q = em.createQuery("select c from Orden_Detalle c where c.nameOrden_Detalle like ?1");
			q.setParameter(1, "%"+Orden_Detalle.getNameOrden_Detalle()+"%");
			lista= (List<Orden_Detalle>)q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
			return lista;
	}

}
