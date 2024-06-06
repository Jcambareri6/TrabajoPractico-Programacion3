import java.util.ArrayList;

public class Procesador {
    private String id;
    private String codigo;
    private boolean EstaRefrigerado;
    private int añoFuncionamiento;
    private int TiempoMax;
    private ArrayList<Tarea> tareas;

    public Procesador(String id, String codigo, boolean estaRefrigerado, int añoFuncionamiento) {
        this.id = id;
        this.codigo = codigo;
        this.EstaRefrigerado = estaRefrigerado;
        this.añoFuncionamiento = añoFuncionamiento;
        this.TiempoMax=0;
        tareas = new ArrayList<>();
    }
    
    public int getTiempoMax() {
        return TiempoMax;
    }
    public void setTiempoMax(int tiempoMax) {
        TiempoMax = tiempoMax;
    }

    public void deleteTareas(){
        this.tareas = new ArrayList<>();
    }
    
    public boolean puedeAsignarTarea(Tarea t,int x){
        
        if (!this.isEstaRefrigerado() && this.getTiempoMax() + t.getTiempoEjecucion() > x) {
            return false;
        }
        return true;
    }
    public boolean tieneDosCriticas(){
        int n=0;
        for (Tarea tarea : tareas) {
            if (tarea.isEsCritica()){
                n++;
            }
        }
        return n>=2;
    }

    public void agregarTarea(Tarea t){
        tareas.add(t);
    }

    public void borrarTarea(Tarea t){
        tareas.remove(t);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isEstaRefrigerado() {
        return EstaRefrigerado;
    }

    public void setEstaRefrigerado(boolean estaRefrigerado) {
        EstaRefrigerado = estaRefrigerado;
    }

    public int getAñoFuncionamiento() {
        return añoFuncionamiento;
    }

    public void setAñoFuncionamiento(int añoFuncionamiento) {
        this.añoFuncionamiento = añoFuncionamiento;
    }

   
    public boolean esMejorSolucion(int estadoSolucion) {
        return estadoSolucion<this.getTiempoMax();
    }
    @Override
    public String toString() {
        return "Procesador [id=" + id + ", codigo=" + codigo + ", EstaRefrigerado=" + EstaRefrigerado
                + ", añoFuncionamiento=" + añoFuncionamiento + ", TiempoMax=" + TiempoMax + ", tareas=" + tareas + "]";
    }

    public ArrayList<Tarea> getTareas(){
        ArrayList<Tarea> copia = new ArrayList<>(tareas);
        return copia;
    }
    public Procesador getCopia() {
        Procesador copia = new Procesador(this.id, this.codigo, this.isEstaRefrigerado(), this.añoFuncionamiento);
        for (Tarea t : this.tareas) {
            copia.agregarTarea(t.getCopia());
        }
        copia.setTiempoMax(this.getTiempoMax());
        return copia;
    }
    
    
  
}
