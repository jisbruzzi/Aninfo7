package fiuba;

import java.util.ArrayList;
import java.util.List;

public class ProductBacklog {
    private List<Tarea> listaTareas; 

    public ProductBacklog() {
        this.listaTareas = new ArrayList<Tarea>();
    }

    public void agregarTarea(Tarea tarea) {
        this.listaTareas.add(tarea);
    }

    public int tamanio(){
        return this.listaTareas.size();
    }
}