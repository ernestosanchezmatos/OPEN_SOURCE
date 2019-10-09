package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Departamento;
import entity.Provincia;
import services.IProvinciaService;
import services.IDepartamentoService;

@Named
@SessionScoped
public class ProvinciaController implements Serializable{

		private static final long serialVersionUID = 1L;

		@Inject
		private IDepartamentoService DepartamentoService;

		@Inject
		private IProvinciaService ProvinciaService;

		private Departamento Departamento;
		private List<Departamento> listaDepartamentos;

		private Provincia Provincia;
		private List<Provincia> listaProvincias;

		@PostConstruct
		public void init() {
			Departamento = new Departamento();
			Provincia = new Provincia();
			listaDepartamentos = new ArrayList<Departamento>();
			listaProvincias = new ArrayList<Provincia>();
			this.listarProvincia();
			this.listarDepartamento();
		}

		public String nuevoProvincia() {
			this.setProvincia(new Provincia());
			return "Provincia.xhtml";
		}

		
		public void insertarActualizar() {
			try {
				if (Provincia.getProvinciaId() > 0) {
					ProvinciaService.update(Provincia);
					limpiarProvincias();
				} else {
					ProvinciaService.insert(Provincia);
					limpiarProvincias();
				}
				this.listarProvincia();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void eliminar(Provincia Provincia) {
			try {
				ProvinciaService.delete(Provincia.getProvinciaId());
				listarProvincia();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void listarProvincia() {
			try {
				listaProvincias = ProvinciaService.ListAll();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void listarDepartamento() {
			try {
				listaDepartamentos = DepartamentoService.ListAll();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void mostrar(Provincia p) {
			try {
				this.Departamento.setDepartamentoId(p.getDepartamento().getDepartamentoId());
				this.Departamento.setNDepartamento(p.getDepartamento().getNDepartamento());

				this.Provincia.setProvinciaId(p.getProvinciaId());
				this.Provincia.setNProvincia(p.getNProvincia());
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

		public void buscarProvinciaNombre() {
			try {
				if (Provincia.getNProvincia().isEmpty()) {
					this.listarProvincia();
				} else {
					listaProvincias = this.ProvinciaService.findbyname(this.getProvincia());
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void limpiarProvincias() {
			this.init();
		}

		public IDepartamentoService getDepartamentoService() {
			return DepartamentoService;
		}

		public void setDepartamentoService(IDepartamentoService departamentoService) {
			DepartamentoService = departamentoService;
		}

		public IProvinciaService getProvinciaService() {
			return ProvinciaService;
		}

		public void setProvinciaService(IProvinciaService provinciaService) {
			ProvinciaService = provinciaService;
		}

		public Departamento getDepartamento() {
			return Departamento;
		}

		public void setDepartamento(Departamento departamento) {
			Departamento = departamento;
		}

		public List<Departamento> getListaDepartamentos() {
			return listaDepartamentos;
		}

		public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
			this.listaDepartamentos = listaDepartamentos;
		}

		public Provincia getProvincia() {
			return Provincia;
		}

		public void setProvincia(Provincia provincia) {
			Provincia = provincia;
		}

		public List<Provincia> getListaProvincias() {
			return listaProvincias;
		}

		public void setListaProvincias(List<Provincia> listaProvincias) {
			this.listaProvincias = listaProvincias;
		}	
		

}
