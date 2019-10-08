package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Category;
import services.ICategoryService;

@Named
@SessionScoped
public class CategoryController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService cService;
	private List<Category> ListCategory;
	private Category category; 

	@PostConstruct
	public void init() {
		ListCategory= new ArrayList<Category>();
		category= new Category();
		this.findall();
	}

	public String newCategory()
	{
		this.setCategory(new Category());
		return "category.xhmtl";
	}
	
	public void updateInsert()
	{
		try {
			if(category.getIdCategory()>0)
			{
				cService.update(category);
				clean();
			}else {
				cService.insert(category);
				clean();
			}
				this.findall();
		} catch (Exception e) {
			e.getMessage();
		}	
	}
	
	public void delete(Category category)
	{
		try {
			cService.delete(category.getIdCategory());
			findall();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public void findall() {
		try {
			ListCategory= cService.ListAll();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void findbyid(Category cat)
	{
		try {
			category=cService.FinbyId(cat.getIdCategory());
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	public void findbyname()
	{
		try {
			if(category.getNameCategory().isEmpty()) this.findall();
			else ListCategory=cService.findbyname(this.getCategory());
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	public void clean()
	{
		this.init();
	}
	
	//get y set
	
	public List<Category> getListCategory() {
		return ListCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		ListCategory = listCategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	
}
