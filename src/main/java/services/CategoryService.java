package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IProvinciaRepository;
import entity.Category;

@Named
public class CategoryService implements ICategoryService,Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IProvinciaRepository cdao; 
	
	@Override
	public boolean insert(Category category) {
		return cdao.insert(category);
	}

	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return cdao.update(category);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return cdao.delete(id);
	}

	@Override
	public List<Category> ListAll() {
		// TODO Auto-generated method stub
		return cdao.ListAll();
	}

	@Override
	public Category FinbyId(int id) {
		// TODO Auto-generated method stub
		return cdao.FinbyId(id);
	}

	@Override
	public List<Category> findbyname(Category category) {
		// TODO Auto-generated method stub
		return cdao.findbyname(category);
	}

	
}
