package fiuba;

import java.util.ArrayList;
import java.util.List;

public class Tarea {
	private String nombre;
	private List<Requerimiento> requerimientos;
	private List<EventoTrabajo> eventosDeTrabajo;
	
	private String prioridad;
    private boolean terminada;
    private float horasEstimadas;
    private int id;

	public Tarea(String nTarea,int id) {
		this.nombre = nTarea;
		requerimientos = new ArrayList<Requerimiento>();
		eventosDeTrabajo=new ArrayList<EventoTrabajo>();
		this.prioridad = "";
    	this.terminada = false;
    	this.horasEstimadas = 0.0f;
        this.id = id;
	}

	public void agregarRequerimiento(Requerimiento r) {
		requerimientos.add(r);
	}

	public void registrarTrabajo(Empleado e, float hs) throws TareaTerminadaException {
		if (this.terminada())
			throw new TareaTerminadaException("No se puede registrar trabajo en una tarea terminada");

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

	public int porcentajeCompletado() {
		return (int)(this.obtenerHorasInvertidas()*100/this.horasEstimadas);
	}
	
	public int getId(){
		return this.id;
	}

	public void terminar() {
		this.terminada = true;
	}

	public boolean terminada() {
		return this.terminada;
	}

	public void setHorasEstimadas(float horas) {
		this.horasEstimadas = horas;
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