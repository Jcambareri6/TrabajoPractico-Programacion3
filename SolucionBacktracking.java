import java.util.ArrayList;

public class SolucionBacktracking {
    private ArrayList<Procesador> procesadores;
    private int tiempoPeorProcesador;
    private int metrica;

    public SolucionBacktracking(){
        this.procesadores=new ArrayList<>();
        this.tiempoPeorProcesador=0;
        this.metrica=0;
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
        this.procesadores = new ArrayList<Procesador>();
    }
    
    public int getTiempoPeorProcesador() {
        int maxTiempoProcesador =0;
        for (Procesador p : this.procesadores) {
             maxTiempoProcesador = Math.max(maxTiempoProcesador, p.getTiempoMax());
             //System.out.println(maxTiempoProcesador);
             
        }
        return maxTiempoProcesador;
    }

    public void setTiempoPeorProcesador(int tiempoPeorProcesador) {
        this.tiempoPeorProcesador = tiempoPeorProcesador;
    }

    public int getMetrica() {
        return metrica;
    }

    public void setMetrica(int metrica) {
        this.metrica = metrica;
    }


    @Override
    public String toString() {
        return "SolucionBacktracking [procesadores=" + procesadores + ", tiempoPeorProcesador=" + tiempoPeorProcesador
                + " Metrica " + metrica + "]";
    }
    public SolucionBacktracking getCopia(){
        SolucionBacktracking copia = new SolucionBacktracking();
        copia.setTiempoPeorProcesador(tiempoPeorProcesador);
        copia.setMetrica(metrica);

        for (Procesador p : this.procesadores) {
            copia.addProcesador(p.getCopia());
        }
    
        return copia;
    }
}
