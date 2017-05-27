package fiuba;

import java.util.ArrayList;
import java.util.List;

public class Tarea {
	private String nombre;
	private List<Requerimiento> requerimientos;
	private List<EventoTrabajo> eventosDeTrabajo;
	
	private String prioridad;
    private boolean terminada;
    private int id;

	public Tarea(String nTarea,int id) {
		this.nombre = nTarea;
		requerimientos = new ArrayList<Requerimiento>();
		eventosDeTrabajo=new ArrayList<EventoTrabajo>();
		this.prioridad = "";
    	this.terminada = false;
        this.id = id;
	}

	public void agregarRequerimiento(Requerimiento r) {
		requerimientos.add(r);
	}

	public void registrarTrabajo(Empleado e, float hs) {
		eventosDeTrabajo.add(new EventoTrabajo(e,hs));
		for (Requerimiento r : requerimientos){
			r.registrarTrabajo(e,hs);
		}
	}

	public float obtenerHorasInvertidas() {
		float ret = 0;
		for(EventoTrabajo e: eventosDeTrabajo){
			ret+=e.obtenerHoras();
		}
		return ret;
	}
	
	public int getId(){
		 return this.id;
	}

}
/*
 * ESTE CONSTRUCTOR LO DEJO AFUERA PORQUE LA IDEA MIA ES QUE TODAS 
 * LAS TAREAS ESTÁN ASOCIADAS A ALGUNA ITERACIÓN
 */
/*
public class Tarea {
    private String nombre;


    public Tarea(String nombreInicial, String prioridad, boolean terminada) {
        this.nombre = nombreInicial;
        this.prioridad = prioridad;
        this.terminada = terminada;
    }

   
}
*/