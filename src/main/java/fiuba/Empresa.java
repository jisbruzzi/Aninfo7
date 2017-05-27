package fiuba;

import java.util.HashMap;
import java.util.Map;

public class Empresa {
	private Map<String,Empleado> empleados;
	private Map<String,Proyecto> proyectos;
	
	public Empresa() {
		this.empleados = new HashMap<String,Empleado>();
		this.proyectos = new HashMap<String,Proyecto>();
	}
	public void agregarEmpleado(String nombre) {
		empleados.put(nombre,new Empleado(nombre));
	}

	public Empleado obtenerEmpleado(String nEmpleado) {
		return empleados.get(nEmpleado);
	}
	public Proyecto crearProyecto(String nombre) {
		Proyecto p = new Proyecto(nombre);
		proyectos.put(nombre,p);
		return p;
	}

}
