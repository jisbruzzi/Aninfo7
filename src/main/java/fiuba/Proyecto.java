package fiuba;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	private List<Fase> fases;
	private List<Requerimiento> requerimientos;
	private String nombre;
	private Estado estado;
	private List<EventoTrabajo> eventosDeTrabajo;

	Proyecto(String nombre) {
		fases = new ArrayList<Fase>();
		requerimientos = new ArrayList<Requerimiento>();
		this.nombre = nombre;
		eventosDeTrabajo = new ArrayList<EventoTrabajo>();
	}

	public Fase agregarIteracion(String nombre) {
		Fase i = new Fase(nombre);
		fases.add(i);
		
		return i;
	}

	public Requerimiento agregarRequerimiento(String nombre) {
		Requerimiento r = new Requerimiento(nombre);
		requerimientos.add(r);
		return r;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public Estado obtenerEstado() {
		return estado;
	}

	public void cambiarEstado(Estado estado2) {
		estado=estado2;
	}

	public void registrarTrabajo(Empleado e, Tarea t, float hs) throws Exception {
		
		if(estado==Estado.EnProgreso){
			EventoTrabajo ev = new EventoTrabajo(e,hs);
			eventosDeTrabajo.add(ev);
			t.registrarTrabajo(ev);
			e.registrarTrabajo(ev);
		}else{
			throw new ProyectoNoEnProgresoException();
		}
		
	}
	

}
