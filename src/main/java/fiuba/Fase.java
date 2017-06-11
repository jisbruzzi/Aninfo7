package fiuba;

import java.util.ArrayList;
import java.util.List;

public class Fase {
	private String nombre;
	private List<Tarea> tareas;
	private int proximoId;

	Fase(String nombre) {
		this.nombre = nombre;
		tareas = new ArrayList<Tarea>();
		proximoId=0;
	}

	public Tarea agregarTarea(String nTarea) {
		Tarea t = new Tarea(nTarea,proximoId);
		proximoId+=1;
		tareas.add(t);
		return t;
	}
	
	void quitarTarea(int id){
		for( Tarea t : tareas){
			if(t.getId()==id){
				tareas.remove(t);
				break;
			}
		}
    }
	
	public int cantidadDeTareas(){
		return tareas.size();
	}

	public void quitarTarea(Tarea t) {
		tareas.remove(t);
	}

	void agregarTarea(Tarea t) {
		tareas.add(t);
	}
	
	
}
