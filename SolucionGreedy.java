
import java.util.ArrayList;
import java.util.LinkedList;

public class SolucionGreedy {

    private ArrayList<Procesador> Solucion;
    private ArrayList<Procesador> ProcesadorCSV;
    private LinkedList<Tarea> tareasSinAsignar;
    private int TiempoMejorSolucion;
    private int metrica;

    public SolucionGreedy(String pathProcesadores, String pathTareas) {
        CSVReader readerCSV = new CSVReader();
        this.Solucion = new ArrayList<>();
        this.ProcesadorCSV = readerCSV.readProcessors(pathProcesadores);
        this.tareasSinAsignar = readerCSV.readTasks(pathTareas);
        this.TiempoMejorSolucion = Integer.MAX_VALUE;

        this.metrica = 0;

    }

    // El criterio de solucion greedy fue elegir las tareas con mayor tiempo de
    // ejecucion
    // e ir asignandolas primero ya que esto permite balancear de manera mas eficaz
    // las tareas a los procesadores

    public Tarea GetMejorCandidato() {
        int Max = 0;
        Tarea tCandidata = null;
        for (Tarea t : this.tareasSinAsignar) {
            if (t.getTiempoEjecucion() > Max) {
                Max = t.getTiempoEjecucion();
                tCandidata = t;
            }
        }

        this.incrementarMetrica();
        return tCandidata;
    }
  
    /*
     * para aplicar greedy la estrategia utilizada fue asignar la tarea de mayor tiempo de ejecucion 
     * primeramente, esto permite balancear la carga de cada procesador obteniendo asi la solucion mas optima
     * por el momento 
     */
    public SolucionGreedy AsignarTareasConGreedy(int x) {

        if (tareasSinAsignar.isEmpty()) {
            return null;
        } else {

            this.SolucionarGreedy(x);
            if (tareasSinAsignar.isEmpty()) {
                return this;
            }
            return null;

        }
    }

    private void SolucionarGreedy(int x) {
        int TMaxTemporal = 0;
        while (!this.tareasSinAsignar.isEmpty()) {
            for (Procesador p : this.ProcesadorCSV) {

                Tarea t = this.GetMejorCandidato();

                if (comprobar(p, t, x)) {
                    this.tareasSinAsignar.remove(t);

                    p.setTiempoMax(p.getTiempoMax() + t.getTiempoEjecucion());

                    p.agregarTarea(t);

                    if (p.getTiempoMax() > TMaxTemporal) {
                        TMaxTemporal = p.getTiempoMax();
                    }
                    this.Solucion.add(p.getCopia());
                    if (this.tareasSinAsignar.isEmpty()) { // si me quede sin tareas corto la ejecucion del for para que
                                                           // no vuelva a entrar
                        break;
                    }
                }
            }

        }
        if (this.TiempoMejorSolucion == Integer.MAX_VALUE || TMaxTemporal < this.TiempoMejorSolucion) {
            this.setTiempoMejorSolucion(TMaxTemporal);
            this.Solucion = new ArrayList<Procesador>();
            this.Solucion = this.getProcesadores();
        }
    }

    public void incrementarMetrica() {
        this.metrica++;
    }

    private ArrayList<Procesador> getProcesadores() {
        ArrayList<Procesador> procesadores = new ArrayList<Procesador>();
        for (Procesador P : this.ProcesadorCSV) {
            procesadores.add(P.getCopia());
        }
        return procesadores;
    }

    private boolean comprobar(Procesador p, Tarea t, int x) {
        return p.puedeAsignarTarea(t, x) && !p.tieneDosCriticas();
    }

    public int getTiempoMejorSolucion() {
        return TiempoMejorSolucion;
    }

    public void setTiempoMejorSolucion(int TiempoMejorSolucion) {
        this.TiempoMejorSolucion = TiempoMejorSolucion;
    }

    @Override
    public String toString() {
        return "SolucionGreedy [Solucion=" + Solucion + ", TiempoMejorSolucion=" + TiempoMejorSolucion + ", metrica="
                + metrica + "]";
    }

}
