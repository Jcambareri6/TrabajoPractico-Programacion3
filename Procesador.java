import java.util.ArrayList;

public class Procesador implements Comparable<Procesador>{
    private String id;
    private String codigo;
    private boolean EstaRefrigerado;
    private int añoFuncionamiento;
    private ArrayList<Tarea> tareas;

    public Procesador(String id, String codigo, boolean estaRefrigerado, int añoFuncionamiento) {
        this.id = id;
        this.codigo = codigo;
        this.EstaRefrigerado = estaRefrigerado;
        this.añoFuncionamiento = añoFuncionamiento;
        tareas = new ArrayList<>();
    }
    public void agregarTarea(Tarea t){
        tareas.add(t);
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

    @Override
    public int compareTo(Procesador o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    
    
  
}
