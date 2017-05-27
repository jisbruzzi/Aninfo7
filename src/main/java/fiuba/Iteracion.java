package fiuba;

import java.util.ArrayList;
import java.util.List;

public class Iteracion {
	private String nombre;
	private List<Tarea> tareas;

	public Iteracion(String nombre) {
		this.nombre = nombre;
		tareas = new ArrayList<Tarea>();
	}

	public Tarea agregarTarea(String nTarea) {
		Tarea t = new Tarea(nTarea);
		tareas.add(t);
		return t;
	}
	
	
}
