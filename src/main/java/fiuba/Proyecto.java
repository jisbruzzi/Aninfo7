package fiuba;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	private List<Fase> fases;
	private List<Requerimiento> requerimientos;
	private String nombre;

	public Proyecto(String nombre) {
		fases = new ArrayList<Fase>();
		requerimientos = new ArrayList<Requerimiento>();
		this.nombre = nombre;
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

}
