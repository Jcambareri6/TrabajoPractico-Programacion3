

public class Tarea {
    private String id;
    private int tiempoEjecucion;
    private String nombre;
    private boolean esCritica;
   
    private int nivelDePrioridad;

    public Tarea(String id,int tiempoEjecucion,String nombre, boolean esCritica, int nivelDePrioridad) {
        this.id = id;
        this.tiempoEjecucion= tiempoEjecucion;
        this.nombre = nombre;
        this.esCritica = esCritica;
        if (nivelDePrioridad >= 0 && nivelDePrioridad <= 100) {
            this.nivelDePrioridad = nivelDePrioridad;
        } else {
            this.nivelDePrioridad = 0; // Establecer a 0 si está fuera de rango
        }
    
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEsCritica() {
        return esCritica;
    }

    public void setEsCritica(boolean esCritica) {
        this.esCritica = esCritica;
    }


    public int getNivelDePrioridad() {
        return nivelDePrioridad;
    }

    public void setNivelDePrioridad(int nivelDePrioridad) {
        if (nivelDePrioridad > 0 && nivelDePrioridad < 101) {
            this.nivelDePrioridad = nivelDePrioridad;
        }

    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    @Override
    public String toString() {
        return "Tarea [id=" + id + ", tiempoEjecucion=" + tiempoEjecucion + ", nombre=" + nombre + ", esCritica="
                + esCritica + ", nivelDePrioridad=" + nivelDePrioridad + "]";
    }

}
