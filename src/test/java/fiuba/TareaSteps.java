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
    private Exception last_exception;
    
    
    @Dado("^hay una empresa y un proyecto$")
    public void que_hay_una_empresa_y_un_proyecto() throws Throwable {
        empresa = new Empresa();
        proyecto=empresa.crearProyecto("Hacer Manaos");
        proyecto.cambiarEstado(Estado.EnProgreso);
        fases = new HashMap<String,Fase>();
        requerimientos = new HashMap<String,Requerimiento>();
        tareas = new HashMap<String,Tarea>();
    }
    
    
    @Dado("^existe la iteración (vacía )?\"(.*?)\"$")
    public void que_existe_la_iteración(String vacia, String arg1) throws Throwable {
    	//la nueva iteración siempre está vacía, el "vacía" se agrega para hacer más legibles las pruebas
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
        try {
        	proyecto.registrarTrabajo(e,t,hs);
        } catch (Exception ex){
            this.last_exception = ex;
        }        
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

    @Dado("^la tarea \"(.*?)\" está terminada$")
    public void la_tarea_está_terminada(String arg1) throws Throwable {
        tareas.get(arg1).terminar();
    }

    @Entonces("la operacion falla porque no se puede registrar trabajo en un proyecto que no esté en progreso")
    public void fallaPorProyectoNoEnProgreso() throws Throwable {
        assertTrue(this.last_exception.getClass()==ProyectoNoEnProgresoException.class); 
    }
    
    @Entonces("la operacion falla porque no se puede registrar trabajo en una tarea terminada")
    public void fallaPorTareaTerminada() throws Throwable {
        assertTrue(this.last_exception.getClass()==TareaTerminadaException.class); 
    }

    @Dado("^la tarea \"(.*?)\" tiene una estimacion de (\\d+) horas$")
    public void la_tarea_tiene_una_estimacion_de_horas(String ntarea, int horas) throws Throwable {
        this.tareas.get(ntarea).setHorasEstimadas(horas);
    }


    @Entonces("^la tarea \"(.*?)\" se estima (\\d+)% completada$")
    public void la_tarea_se_estima_completada(String ntarea, int porcentaje) throws Throwable {
        assertEquals(porcentaje, this.tareas.get(ntarea).porcentajeCompletado());
    }

    
    @Entonces("^la cantidad de tareas en de la iteración \"(.*?)\" es (\\d+)$")
    public void la_cantidad_de_tareas_en_de_la_iteración_es(String arg1, int arg2) throws Throwable {
    	Fase i = fases.get(arg1);
    	assertTrue(i.cantidadDeTareas()==arg2);
    }
    
    @Dado("^el proyecto está en estado (.*?)$")
    public void el_proyecto_está_en_estado(String nEstado) throws Throwable {
    	Estado estado=Estado.NoIniciado;
        switch(nEstado){
        	case "en progreso":estado=Estado.EnProgreso;break;
        	case "terminado":estado=Estado.Terminado;break;
        	case "suspendido":estado=Estado.Suspendido;break;
        	case "no iniciado":estado=Estado.NoIniciado;break;
        	default: estado=Estado.NoIniciado;break;
        }
        proyecto.cambiarEstado(estado);
    }
    
    @Cuando("^se mueve la tarea \"(.*?)\" de \"(.*?)\" a \"(.*?)\"$")
    public void se_mueve_la_tarea_de_a(String nTarea, String nFDesde, String nFHasta) throws Throwable {
        Tarea t=this.tareas.get(nTarea);
        Fase fDesde = this.fases.get(nFDesde);
        Fase fHasta = this.fases.get(nFHasta);
        this.proyecto.moverTarea(t,fDesde,fHasta);
    }
}
