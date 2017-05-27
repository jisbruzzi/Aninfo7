package fiuba;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	private List<Iteracion> iteraciones;
	private List<Requerimiento> requerimientos;
	private String nombre;

	public Proyecto(String nombre) {
		iteraciones = new ArrayList<Iteracion>();
		requerimientos = new ArrayList<Requerimiento>();
		this.nombre = nombre;
	}

	public Iteracion agregarIteracion(String nombre) {
		Iteracion i = new Iteracion(nombre);
		iteraciones.add(i);
		
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
