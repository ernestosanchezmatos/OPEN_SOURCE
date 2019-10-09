package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Reporte;

public class ReporteRepository implements IReporteRepository,Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	public ReporteRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean insert(Reporte Reporte) {
		try {
			em.persist(Reporte);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Reporte Reporte) {
		/*try {
			em.merge(Reporte);
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
		/*Reporte cat = new Reporte();
		
		try {
			cat = em.getReference(Reporte.class, id);
			em.remove(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} */
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Reporte> ListAll() {
	List<Reporte> lista= new ArrayList<Reporte>();
	try {
		Query q = em.createQuery("select c from Reporte c");
		lista= (List<Reporte>)q.getResultList();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return lista;
	}

	@Override
	public Reporte FinbyId(int id) {
		Reporte cat = new Reporte();
		try {
			cat = em.find(Reporte.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reporte> findbyname(Reporte Reporte) {
		List<Reporte> lista= new ArrayList<Reporte>();
		/*List<Reporte> lista= new ArrayList<Reporte>();
		try {
			Query q = em.createQuery("select c from Reporte c where c.nameReporte like ?1");
			q.setParameter(1, "%"+Reporte.getNameReporte()+"%");
			lista= (List<Reporte>)q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
			return lista;
	}

}
