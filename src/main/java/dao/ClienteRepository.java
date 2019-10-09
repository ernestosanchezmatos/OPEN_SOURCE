package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Cliente;

public class ClienteRepository implements IClienteRepository,Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="OPEN_SOURCE")
	private EntityManager em;
	
	@Override
	@Transactional
	public boolean insert(Cliente Cliente) {
		
		try {
			em.persist(Cliente);
			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return false;
	}

	@Override
	@Transactional
	public boolean update(Cliente Cliente) {
		/*try {
			em.merge(Cliente);
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
		Cliente prod = new Cliente();
		try {
			
		prod = em.find(Cliente.class,id);
		em.remove(prod);
		return true; 
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}*/
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> ListAll() {
		List<Cliente> lista= new ArrayList<Cliente>();
		try {
			Query q = em.createQuery("select c from Cliente c");
			lista = (List<Cliente>)q.getResultList();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public Cliente FinbyId(int id) {
		Cliente pr = new Cliente();
		try {
			pr= em.find(Cliente.class, id);
		
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return pr;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findbyname(Cliente Cliente) {
		List<Cliente> lista= new ArrayList<Cliente>();
		/*List<Cliente> lista= new ArrayList<Cliente>();
		try {
			Query q = em.createQuery("select c from Cliente c where c.nameCliente like ?1");
			q.setParameter(1, "%"+Cliente.getNameCliente()+"%");
			lista = (List<Cliente>)q.getResultList();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		*/
		return lista;
	}


}
