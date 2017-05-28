package fiuba;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String nombre;
	private List<EventoTrabajo> eventosDeTrabajo;

	Empleado(String nombre) {
		this.nombre = nombre;
		eventosDeTrabajo=new ArrayList<EventoTrabajo>();
	}

	public void registrarTrabajo(EventoTrabajo ev) {
		eventosDeTrabajo.add(ev);
	}
	
	

}
