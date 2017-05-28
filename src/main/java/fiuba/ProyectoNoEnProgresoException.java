package fiuba;

import java.lang.Exception;

public class ProyectoNoEnProgresoException extends Exception {
	ProyectoNoEnProgresoException() {
        super("No se puede registrar trabajo en un proyecto que no esté en progreso");
    }
}