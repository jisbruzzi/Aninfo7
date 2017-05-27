package fiuba;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TareaSteps {
	public ProductBacklog backlog;

	@Dado("^que mi backlog se encuentra vacio$")
	public void que_mi_backlog_se_encuentra_vacio() throws Throwable {
	    this.backlog = new ProductBacklog();
	    //throw new PendingException();
	}

	@Cuando("^agrego una tarea$")
	public void agrego_una_tarea() throws Throwable {
	    Tarea tarea = new Tarea();
	    this.backlog.agregarTarea(tarea);
	    //throw new PendingException();
	}

	@Entonces("^la cantidad de tareas en el backlog es (\\d+)$")
	public void la_cantidad_de_tareas_en_el_backlog_es(int tamanioEsperado) throws Throwable {
	    assertEquals(tamanioEsperado, this.backlog.tamanio());
	    //throw new PendingException();
	}

}
