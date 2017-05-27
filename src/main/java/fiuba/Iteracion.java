package fiuba;

import java.util.ArrayList;
import java.util.List;

public class Iteracion {
	private String nombre;
	private List<Tarea> tareas;
	private int proximoId;

	public Iteracion(String nombre) {
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
	
	public void quitarTarea(int id){
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
	
	
}
