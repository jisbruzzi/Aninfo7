package fiuba;

import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

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
    private Map<String,Fase> fases;
    private Map<String,Requerimiento> requerimientos;
    private Map<String,Tarea> tareas;
    private Empresa empresa;
    
    
    @Dado("^hay una empresa y un proyecto$")
    public void que_hay_una_empresa_y_un_proyecto() throws Throwable {
        empresa = new Empresa();
        proyecto=empresa.crearProyecto("Hacer Manaos");
        fases = new HashMap<String,Fase>();
        requerimientos = new HashMap<String,Requerimiento>();
        tareas = new HashMap<String,Tarea>();
    }
    
    
    @Dado("^existe la iteración \"(.*?)\"$")
    public void que_existe_la_iteración(String arg1) throws Throwable {
        fases.put(arg1, proyecto.agregarIteracion(arg1));
    }

    @Dado("^el proyecto tiene el requisito \"(.*?)\"$")
    public void que_el_proyecto_tiene_el_requisito(String arg1) throws Throwable {
    	requerimientos.put(arg1, proyecto.agregarRequerimiento(arg1));
    }

    @Dado("^(.*?) es un empleado$")
    public void que_es_un_empleado(String nombre) throws Throwable {
        empresa.agregarEmpleado(nombre);
    }

    @Dado("^existe una tarea llamada \"(.*?)\" de la iteración \"(.*?)\"$")
    public void que_existe_una_tarea_llamada_de_la_iteración(String nTarea, String nIteracion) throws Throwable {
    	Fase iteracion = fases.get(nIteracion);
        tareas.put(nTarea,iteracion.agregarTarea(nTarea));
    }

    @Dado("^a la tarea \"(.*?)\" le corresponde el requisito \"(.*?)\"$")
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
/*
    @Dado("^mi backlog se encuentra vacio$")
	public void que_mi_backlog_se_encuentra_vacio() throws Throwable {
	    this.backlog = new ProductBacklog();
	    //throw new PendingException();
	}
    
    @Cuando("^agrego una tarea$")
	public void agrego_una_tarea() throws Throwable {
		//Tarea tarea = new Tarea(0);
		Tarea tarea = this.backlog.crearTarea();
	    this.backlog.agregarTarea(tarea);
	    //throw new PendingException();
	}
    
    @Entonces("^la cantidad de tareas en el backlog es (\\d+)$")
	public void la_cantidad_de_tareas_en_el_backlog_es(int tamanioEsperado) throws Throwable {
	    assertEquals(tamanioEsperado, this.backlog.tamanio());
	    //throw new PendingException();
	}

	@Dado("^mi backlog posee (\\d+) tareas$")
	public void que_mi_backlog_posee_tareas(int arg1) throws Throwable {
	    //Tarea tarea = new Tarea(0);
	    //Tarea tarea = this.backlog.crearTarea();
	    //this.backlog.agregarTarea(tarea);
	    //throw new PendingException();
	}

	@Cuando("^quito una tarea$")
	public void quito_una_tarea() throws Throwable {
	    //this.backlog.quitarTarea(0);
	    //throw new PendingException();
	}
	*/
    
    @Entonces("^la cantidad de tareas en de la iteración \"(.*?)\" es (\\d+)$")
    public void la_cantidad_de_tareas_en_de_la_iteración_es(String arg1, int arg2) throws Throwable {
    	Fase i = fases.get(arg1);
    	assertTrue(i.cantidadDeTareas()==arg2);
    }
}
