import java.util.ArrayList;
import java.util.LinkedList;

public class SolucionBacktracking {
    private ArrayList<Procesador> procesadores;
    private ArrayList<Procesador> procesadoresFinal;
    private ArrayList<Procesador> procesadoresCSV;
    private LinkedList<Tarea> tareasCSV;
    private int tiempoPeorProcesador;
    private int metrica;
    private int MejorSolucion = Integer.MAX_VALUE;

    public SolucionBacktracking(String pathProcesadores, String pathTareas) {
        CSVReader readerCSV = new CSVReader();
        this.procesadoresCSV = readerCSV.readProcessors(pathProcesadores);
        this.tareasCSV = readerCSV.readTasks(pathTareas);
        this.procesadores = new ArrayList<>();
        this.tiempoPeorProcesador = 0;
        this.metrica = 0;
    }

    /*
     * para la solucion backtracking utilizamos una lista de procesadores parcial
     *  que va llevando todas las soluciones
     *  una lista procesadores csv que obtiene los procesadores del reader 
     * y la lista de procesadores finales que solo guarda la mejor solucion que encontro (se va actualizando)
     * ademas pudimos realizar una estrategia de poda donde verifica que la suma de la ejecucion de cada procesador
     * sea menor al tiempo actual, cuando las tareas ya fueron asignadas ademas de verificar que sea la 
     * mejor solucion, previamente seteamos el tiempo del peor procesador para poder comprobarlo 
     * 
     */
    public SolucionBacktracking AsignarTareasConBacktracking(int tiempoMaximo) {
        if (tareasCSV.isEmpty()) {
            return null;
        } else {
            resolverBacktracking(tiempoMaximo);
            return this;
        }
    }

    private void resolverBacktracking(int tiempoMaximo) {

        if (this.tareasCSV.isEmpty()) {
            int maxTiempoProcesador = 0;
            for (Procesador p : this.procesadoresCSV) {
                maxTiempoProcesador = Math.max(maxTiempoProcesador, p.getTiempoMax()); // encuentra el tiempo del peor
                                                                                       // procesador de la solucion
                // System.out.println(maxTiempoProcesador);

            }

            if (MejorSolucion == Integer.MAX_VALUE || maxTiempoProcesador < MejorSolucion) {
                MejorSolucion = maxTiempoProcesador;
                this.setTiempoPeorProcesador(maxTiempoProcesador);

                procesadoresFinal = new ArrayList<>();
                this.procesadoresFinal = this.getProcesadores();
            }
            this.deleteProcesadores();
        } else {
            Tarea t = this.tareasCSV.removeFirst();

            for (Procesador pr : procesadoresCSV) {
                if (pr.puedeAsignarTarea(t, tiempoMaximo) && !pr.tieneDosCriticas()) {
                    int tiempoMaxPrevio = pr.getTiempoMax();
                    pr.agregarTarea(t);
                    pr.setTiempoMax(tiempoMaxPrevio + t.getTiempoEjecucion());

                    if (MejorSolucion == Integer.MAX_VALUE || pr.getTiempoMax() <= MejorSolucion) { 
                        this.addProcesador(pr.getCopia());

                        this.incrementarMetrica(); 
                        resolverBacktracking(tiempoMaximo);
                    }

                    pr.borrarTarea(t);
                    pr.setTiempoMax(tiempoMaxPrevio);
                }
            }
            tareasCSV.addFirst(t);
        }
    }

    public int getMejorSolucion() {
        return MejorSolucion;
    }

    public void setMejorSolucion(int mejorSolucion) {
        MejorSolucion = mejorSolucion;
    }

    public void addProcesador(Procesador p) {
        this.procesadores.add(p);
    }

    public ArrayList<Procesador> getProcesadores() {
        ArrayList<Procesador> copia = new ArrayList<>();
        for (Procesador procesador : procesadoresCSV) {
            copia.add(procesador.getCopia());
        }
        return copia;
    }

    public void deleteProcesadores() {
        this.procesadores = new ArrayList<Procesador>();
    }

    public void setTiempoPeorProcesador(int tiempoPeorProcesador) {
        this.tiempoPeorProcesador = tiempoPeorProcesador;
    }

    public int getTiempoPeorProcesador() {
        return tiempoPeorProcesador;

    }

    public void incrementarMetrica() {
        this.metrica++;
    }

    @Override
    public String toString() {
        return "SolucionBacktracking [procesadores=" + procesadoresFinal + ", tiempoPeorProcesador="
                + getTiempoPeorProcesador()
                + " Metrica " + metrica + "]";
    }
}
