package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Departamento;

public class ProductRepository implements IProductRepository,Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="Semana7")
	private EntityManager em;
	
	@Override
	@Transactional
	public boolean insert(Departamento product) {
		
		try {
			em.persist(product);
			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return false;
	}

	@Override
	@Transactional
	public boolean update(Departamento product) {
		try {
			em.merge(product);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		Departamento prod = new Departamento();
		try {
			
		prod = em.find(Departamento.class,id);
		em.remove(prod);
		return true; 
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> ListAll() {
		List<Departamento> lista= new ArrayList<Departamento>();
		try {
			Query q = em.createQuery("select c from Product c");
			lista = (List<Departamento>)q.getResultList();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public Departamento FinbyId(int id) {
		Departamento pr = new Departamento();
		try {
			pr= em.find(Departamento.class, id);
		
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return pr;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findbyname(Departamento product) {
		List<Departamento> lista= new ArrayList<Departamento>();
		try {
			Query q = em.createQuery("select c from Product c where c.nameProduct like ?1");
			q.setParameter(1, "%"+product.getNameProduct()+"%");
			lista = (List<Departamento>)q.getResultList();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return lista;
	}


}
