package fiuba;

import java.util.ArrayList;
import java.util.List;

public class Requerimiento {
	private String nombre;
	private List<EventoTrabajo> eventosDeTrabajo;

	public Requerimiento(String nombre) {
		this.nombre = nombre;
		eventosDeTrabajo=new ArrayList<EventoTrabajo>();
	}

	public float obtenerHorasInvertidas() {
		float ret = 0;
		for(EventoTrabajo e: eventosDeTrabajo){
			ret+=e.obtenerHoras();
		}
		return ret;
	}

	public void registrarTrabajo(Empleado e, float hs) {
		eventosDeTrabajo.add(new EventoTrabajo(e,hs));
	}

}
