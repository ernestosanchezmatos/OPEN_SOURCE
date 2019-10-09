package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Category;
import entity.Departamento;
import services.ICategoryService;
import services.IProductService;

@Named
@SessionScoped
public class ProductController implements Serializable{

		private static final long serialVersionUID = 1L;

		@Inject
		private ICategoryService categoryService;

		@Inject
		private IProductService productService;

		private Category category;
		private List<Category> listaCategorias;

		private Departamento product;
		private List<Departamento> listaProductos;

		@PostConstruct
		public void init() {
			category = new Category();
			product = new Departamento();
			listaCategorias = new ArrayList<Category>();
			listaProductos = new ArrayList<Departamento>();
			this.listarProducto();
			this.listarCategoria();
		}

		public String nuevoProducto() {
			this.setProduct(new Departamento());
			return "product.xhtml";
		}

		
		public void insertarActualizar() {
			try {
				if (product.getIdProduct() > 0) {
					productService.update(product);
					limpiarProducto();
				} else {
					productService.insert(product);
					limpiarProducto();
				}
				this.listarProducto();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void eliminar(Departamento product) {
			try {
				productService.delete(product.getIdProduct());
				listarProducto();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void listarProducto() {
			try {
				listaProductos = productService.ListAll();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void listarCategoria() {
			try {
				listaCategorias = categoryService.ListAll();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void mostrar(Departamento p) {
			try {
				this.category.setIdCategory(p.getCategory().getIdCategory());
				this.category.setNameCategory(p.getCategory().getNameCategory());

				this.product.setIdProduct(p.getIdProduct());
				this.product.setNameProduct(p.getNameProduct());
				this.product.setPriceProduct(p.getPriceProduct());
				this.product.setCategory(category);

			} catch (Exception e) {
				e.getStackTrace();
			}
		}

		public void buscarProductNombre() {
			try {
				if (product.getNameProduct().isEmpty()) {
					this.listarProducto();
				} else {
					listaProductos = this.productService.findbyname(this.getProduct());
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void limpiarProducto() {
			this.init();
		}

		
		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public List<Category> getListaCategorias() {
			return listaCategorias;
		}

		public void setListaCategorias(List<Category> listaCategorias) {
			this.listaCategorias = listaCategorias;
		}

		public Departamento getProduct() {
			return product;
		}

		public void setProduct(Departamento product) {
			this.product = product;
		}

		public List<Departamento> getListaProductos() {
			return listaProductos;
		}

		public void setListaProductos(List<Departamento> listaProductos) {
			this.listaProductos = listaProductos;
		}

}
