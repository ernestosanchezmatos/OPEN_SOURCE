package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Category;

public class CategoryRepository implements ICategoryRepository,Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="Semana7")
	private EntityManager em;
	
	public CategoryRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean insert(Category category) {
		try {
			em.persist(category);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean update(Category category) {
		try {
			em.merge(category);
			return true; 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		Category cat = new Category();
		
		try {
			cat = em.getReference(Category.class, id);
			em.remove(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> ListAll() {
	List<Category> lista= new ArrayList<Category>();
	try {
		Query q = em.createQuery("select c from Category c");
		lista= (List<Category>)q.getResultList();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		return lista;
	}

	@Override
	public Category FinbyId(int id) {
		Category cat = new Category();
		try {
			cat = em.find(Category.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findbyname(Category category) {
		List<Category> lista= new ArrayList<Category>();
		try {
			Query q = em.createQuery("select c from Category c where c.nameCategory like ?1");
			q.setParameter(1, "%"+category.getNameCategory()+"%");
			lista= (List<Category>)q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			return lista;
	}

}
