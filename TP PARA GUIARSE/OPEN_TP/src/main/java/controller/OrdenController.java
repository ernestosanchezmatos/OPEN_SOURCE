package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Departamento;
import entity.Lugar_Personas;
import entity.Empleado;
import entity.Orden;
import services.IOrdenService;
import services.IDepartamentoService;
import services.IEmpleadoService;
import services.ILugar_PersonasService;

@Named
@SessionScoped
public class OrdenController implements Serializable{

		private static final long serialVersionUID = 1L;

		@Inject
		private IEmpleadoService EmpleadoService ;
		private ILugar_PersonasService Lugar_PersonasService ;

		@Inject
		private IOrdenService OrdenService;

		private Empleado Empleado;
		private List<Empleado> listaEmpleados;
		
		private Lugar_Personas Lugar_Personas;
		private List<Lugar_Personas> listaLugar_Personas;

		private Orden Orden;
		private List<Orden> listaOrdenes;

		@PostConstruct
		public void init() {
			Empleado = new Empleado();
			Lugar_Personas = new Lugar_Personas();
			Orden = new Orden();
			listaEmpleados = new ArrayList<Empleado>();
			listaLugar_Personas = new ArrayList<Lugar_Personas>();
			listaOrdenes = new ArrayList<Orden>();
			this.listarOrden();
			this.listarEmpleado();
			this.listarLugar_Personas();
		}

		public String nuevoOrden() {
			this.setOrden(new Orden());
			return "Orden.xhtml";
		}

		
		public void insertarActualizar() {
			try {
				if (Orden.getOrdenId() > 0) {
					OrdenService.update(Orden);
					limpiarOrdens();
				} else {
					OrdenService.insert(Orden);
					limpiarOrdens();
				}
				this.listarOrden();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void eliminar(Orden Orden) {
			try {
				OrdenService.delete(Orden.getOrdenId());
				listarOrden();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void listarOrden() {
			try {
				listaOrdenes = OrdenService.ListAll();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void listarEmpleado() {
			try {
				listaEmpleados = EmpleadoService.ListAll();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		
		public void listarLugar_Personas() {
			try {
				listaLugar_Personas = Lugar_PersonasService.ListAll();
			} catch (Exception e) {
				e.getMessage();
			}
		}

		public void mostrar(Orden p) {
			try {
				this.Empleado.setEmpleadoId(p.getEmpleado().getEmpleadoId());
				this.Empleado.setDNI(p.getEmpleado().getDNI());
				
				this.Lugar_Personas.setLugar_PersonasId(p.getLugar_Personas().getLugar_PersonasId());
				

				this.Orden.setOrdenId(p.getOrdenId());
				this.Orden.setFechaEjecucion(p.getFechaEjecucion());
				this.Orden.setFechaGeneracion(p.getFechaGeneracion());
				this.Orden.setEmpleado(Empleado);
				this.Orden.setLugar_Personas(Lugar_Personas);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

		public void buscarOrdenNombre() {
			/*
			try {
				if (Orden.getNOrden().isEmpty()) {
					this.listarOrden();
				} else {
					listaOrdenes = this.OrdenService.findbyname(this.getOrden());
				}
			} catch (Exception e) {
				e.getMessage();
			}
			*/
		}

		public void limpiarOrdens() {
			this.init();
		}

		public Empleado getEmpleado() {
			return Empleado;
		}

		public void setEmpleado(Empleado asignatura) {
			this.Empleado = asignatura;
		}

		public List<Empleado> getListaEmpleado() {
			return listaEmpleados;
		}

		public void setListaEmpleado(List<Empleado> listaEmpleado) {
			this.listaEmpleados = listaEmpleado;
		}

		public Orden getOrden() {
			return Orden;
		}

		public void setOrden(Orden curso) {
			this.Orden = curso;
		}

		public List<Orden> getListaOrden() {
			return listaOrdenes;
		}

		public void setListaOrden(List<Orden> listaOrden) {
			this.listaOrdenes = listaOrden;
		}

}
