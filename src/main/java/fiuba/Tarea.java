package fiuba;

public class Tarea {
    private String nombre;
    private String prioridad;
    private boolean terminada;
    private int id;

    public Tarea(int id){
    	this.nombre = "Tarea vacia";
    	this.prioridad = "";
    	this.terminada = false;
        this.id = id;
    }

    public Tarea(String nombreInicial, String prioridad, boolean terminada) {
        this.nombre = nombreInicial;
        this.prioridad = prioridad;
        this.terminada = terminada;
    }

    public int getId(){
        return this.id;
    }
}