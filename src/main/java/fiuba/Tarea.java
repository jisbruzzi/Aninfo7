package fiuba;

public class Tarea {
    private String nombre;
    private String prioridad;
    private boolean terminada;

    public Tarea(){
    	this.nombre = "Tarea vacia";
    	this.prioridad = "";
    	this.terminada = false;
    }

    public Tarea(String nombreInicial, String prioridad, boolean terminada) {
        this.nombre = nombreInicial;
        this.prioridad = prioridad;
        this.terminada = terminada;
    }
}