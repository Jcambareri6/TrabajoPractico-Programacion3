import java.util.ArrayList;

public class SolucionBacktracking {
    private ArrayList<Procesador> procesadores;
    private int tiempoPeorProcesador;

    public SolucionBacktracking(){
        this.procesadores=new ArrayList<>();
        this.tiempoPeorProcesador=0;
    }


    public void addProcesador(Procesador p){
        this.procesadores.add(p);
    }

    public void getProcesadores(){
        for (Procesador procesador : procesadores) {
            System.out.println(procesador.toString());
        }
    }

    public void deleteProcesadores(){
        this.procesadores = new ArrayList<>();
    }
    public void getTareasDeProcesadores(){
        for (Procesador procesador : procesadores) {
            System.out.println(procesador.getTareas());
        }
    }

    public int getTiempoPeorProcesador() {
        return this.tiempoPeorProcesador;
    }
    public void setTiempoPeorProcesador(int tiempoPeorProcesador) {
        this.tiempoPeorProcesador = tiempoPeorProcesador;
    }


    @Override
    public String toString() {
        return "SolucionBacktracking [procesadores=" + procesadores + ", tiempoPeorProcesador=" + tiempoPeorProcesador
                + "]";
    }

    
}
