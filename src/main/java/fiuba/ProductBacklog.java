package fiuba;

import java.util.ArrayList;
import java.util.List;

public class ProductBacklog {
    private ArrayList<Tarea> listaTareas; 
    private int id;

    public ProductBacklog() {
        this.listaTareas = new ArrayList<Tarea>();
        this.id = 0;
    }

    public Tarea crearTarea(){
        Tarea tarea = new Tarea(this.id);
        this.id += 1;
        return tarea;
    }

    public void agregarTarea(Tarea tarea) {
        this.listaTareas.add(tarea);
    }

    public void quitarTarea(int id){
        for(int i=0;i<this.tamanio();i++){
            if(this.listaTareas.get(i).getId() == id){
                this.listaTareas.remove(i);
                break;
            }
        }
    }

    public int tamanio(){
        return this.listaTareas.size();
    }
}