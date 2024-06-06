
import java.util.ArrayList;
import java.util.LinkedList;

public class SolucionGreedy {
    private ArrayList<Procesador>Solucion;
    private ArrayList<Procesador>ProcesadorCSV;
    private LinkedList<Tarea> tareasSinAsignar;
    private int TiempoMax;
    private int metrica;
    public SolucionGreedy (String pathProcesadores, String pathTareas){
        CSVReader readerCSV = new CSVReader();
        this.Solucion= new ArrayList<>();
        this.ProcesadorCSV= readerCSV.readProcessors(pathProcesadores);
        this.tareasSinAsignar = readerCSV.readTasks(pathTareas);
        this.TiempoMax= Integer.MAX_VALUE;
        this.metrica =0;

    }
    public Tarea GetMejorCandidato(){
        int Max=0;
        Tarea tCandidata= null;
        for (Tarea t : this.tareasSinAsignar) {
            if(t.getTiempoEjecucion()>Max){
                Max= t.getTiempoEjecucion();
                tCandidata=t; 
         
            }
        }
       
        this.tareasSinAsignar.remove(tCandidata);
        this.incrementarMetrica();
        return tCandidata;
    }
    public String Solucionar (int x){
        if(tareasSinAsignar.isEmpty()){
            return "no hay solucion";
        }else{
            this.SolucionarGreedy(x);
            return this.toString();
        }
    }
    private void SolucionarGreedy(int x){
       
        int TMax =0;
 
        while(!this.tareasSinAsignar.isEmpty() ){
            for (Procesador p : this.ProcesadorCSV) {
                Tarea  t = this.GetMejorCandidato();
                
                if(comprobar(p,t,x)){
                p.setTiempoMax(p.getTiempoMax()+t.getTiempoEjecucion());
                p.agregarTarea(t);
                if(p.getTiempoMax()>TMax){
                    TMax=p.getTiempoMax();
                }
                //TMax= p.getTiempoMax()+t.getTiempoEjecucion();
                //p.setTiempoMax(TMax);
                 this.Solucion.add(p.getCopia());
                }
            }
           
        }
       
            if(this.TiempoMax == Integer.MAX_VALUE || TMax<this.TiempoMax){
                this.setTiempoMax(TMax);
                this.Solucion = new ArrayList<Procesador>();
                this.Solucion = this.getProcesadores();
               
                
            }
    }
    public void incrementarMetrica(){
        this.metrica++;
    }
    private ArrayList<Procesador> getProcesadores(){
        ArrayList<Procesador> procesadores = new ArrayList <Procesador> ();
        for (Procesador P : this.ProcesadorCSV) {
            procesadores.add(P.getCopia());
        }
        return procesadores;
    }
    private boolean comprobar(Procesador p, Tarea t, int x) {
      return p.puedeAsignarTarea(t, x) && !p.tieneDosCriticas(); 
    }
    public int getTiempoMax() {
        return TiempoMax;
    }
    public void setTiempoMax(int tiempoMax) {
        TiempoMax = tiempoMax;
    }
    @Override
    public String toString() {
        return "SolucionGreedy [Solucion=" + Solucion + ", TiempoMax=" + TiempoMax + ", metrica=" + metrica + "]";
    }
    
    
}
