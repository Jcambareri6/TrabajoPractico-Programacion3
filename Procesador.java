



public class Procesador {
    private String id;
    private String codigo;
    private boolean EstaRefrigerado;
    private int añoFuncionamiento;

    public Procesador(String id, String codigo, boolean estaRefrigerado, int añoFuncionamiento) {
        this.id = id;
        this.codigo = codigo;
        this.EstaRefrigerado = estaRefrigerado;
        this.añoFuncionamiento = añoFuncionamiento;
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
    
    
  
}
