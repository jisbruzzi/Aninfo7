package fiuba;

import java.util.ArrayList;
import java.util.List;

public class Tarea {
	private String nombre;
	private List<Requerimiento> requerimientos;
	private List<EventoTrabajo> eventosDeTrabajo;

	public Tarea(String nTarea) {
		this.nombre = nTarea;
		requerimientos = new ArrayList<Requerimiento>();
		eventosDeTrabajo=new ArrayList<EventoTrabajo>();
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

}
