package fiuba;

import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Created by pepenacho
 */
public class TareaSteps {

    private Proyecto proyecto;
    private Map<String,Iteracion> iteraciones;
    private Map<String,Requerimiento> requerimientos;
    private Map<String,Tarea> tareas;
    private Empresa empresa;
    
    
    @Dado("^que hay una empresa y un proyecto$")
    public void que_hay_una_empresa_y_un_proyecto() throws Throwable {
        empresa = new Empresa();
        proyecto=empresa.crearProyecto("Hacer Manaos");
        iteraciones = new HashMap<String,Iteracion>();
        requerimientos = new HashMap<String,Requerimiento>();
        tareas = new HashMap<String,Tarea>();
    }
    
    
    @Dado("^que existe la iteración \"(.*?)\"$")
    public void que_existe_la_iteración(String arg1) throws Throwable {
    	String k = proyecto.obtenerNombre();
    	Iteracion i =proyecto.agregarIteracion(arg1);
        iteraciones.put(arg1,i);
    }

    @Dado("^que el proyecto tiene el requisito \"(.*?)\"$")
    public void que_el_proyecto_tiene_el_requisito(String arg1) throws Throwable {
    	requerimientos.put(arg1, proyecto.agregarRequerimiento(arg1));
    }

    @Dado("^que (.*?) es un empleado$")
    public void que_es_un_empleado(String nombre) throws Throwable {
        empresa.agregarEmpleado(nombre);
    }

    @Dado("^que existe una tarea llamada \"(.*?)\" de la iteración \"(.*?)\"$")
    public void que_existe_una_tarea_llamada_de_la_iteración(String nTarea, String nIteracion) throws Throwable {
    	Iteracion iteracion = iteraciones.get(nIteracion);
        tareas.put(nTarea,iteracion.agregarTarea(nTarea));
    }

    @Dado("^que a la tarea \"(.*?)\" le corresponde el requisito \"(.*?)\"$")
    public void que_a_la_tarea_le_corresponde_el_requisito(String tarea, String req) throws Throwable {
        Tarea t = tareas.get(tarea);
        Requerimiento r = requerimientos.get(req);
        t.agregarRequerimiento(r);
    }

    @Cuando("^(.*?) trabaja (\\d+) horas sobre \"(.*?)\"$")
    public void trabaja_horas_sobre(String nEmpleado, float hs, String nTarea) throws Throwable {
    	Empleado e = empresa.obtenerEmpleado(nEmpleado);
        Tarea t = tareas.get(nTarea);
        t.registrarTrabajo(e,hs);
    }

    @Entonces("^el requerimiento \"(.*?)\" tiene (\\d+) horas de trabajo$")
    public void el_requerimiento_tiene_horas_de_trabajo(String req, float hs) throws Throwable {
    	Requerimiento r = requerimientos.get(req);
        assertTrue(r.obtenerHorasInvertidas()==hs);
    }

    @Entonces("^la tarea \"(.*?)\" tiene (\\d+) horas de trabajo$")
    public void la_tarea_tiene_horas_de_trabajo(String arg1, int arg2) throws Throwable {
    	Tarea t = tareas.get(arg1);
    	assertTrue(t.obtenerHorasInvertidas()==arg2);
    }
}
