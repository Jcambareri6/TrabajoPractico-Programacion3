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

    public SolucionBacktracking(String pathProcesadores, String pathTareas){
        CSVReader readerCSV = new CSVReader();
        this.procesadoresCSV= readerCSV.readProcessors(pathProcesadores);
        this.tareasCSV = readerCSV.readTasks(pathTareas);
        this.procesadores=new ArrayList<>();
        this.tiempoPeorProcesador=0;
        this.metrica=0;
    }


	
	public SolucionBacktracking AsignarTareasConBacktracking(int tiempoMaximo) {
		if (tareasCSV.isEmpty()) {
			return null;
		} else {
			resolverBacktracking(0, tiempoMaximo);
			return this;
		}
	}

	private void resolverBacktracking(int EstadoActual, int tiempoMaximo) {
	
		if (this.tareasCSV.isEmpty()) {
			int maxTiempoProcesador = 0;
			
			for (Procesador p: procesadoresCSV) {
				maxTiempoProcesador = Math.max(maxTiempoProcesador,p.getTiempoMax());
			}

			if (MejorSolucion == Integer.MAX_VALUE || maxTiempoProcesador < MejorSolucion) {
				MejorSolucion = maxTiempoProcesador;
                
				this.setTiempoPeorProcesador(MejorSolucion);
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
						int i = this.getMetrica();
						this.setMetrica(i+1);
						resolverBacktracking(pr.getTiempoMax(), tiempoMaximo);
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
    public void addProcesador(Procesador p){
        this.procesadores.add(p);
    }

    public ArrayList<Procesador> getProcesadores(){
        ArrayList<Procesador> copia = new ArrayList<>();
        for (Procesador procesador : procesadoresCSV) {
            copia.add(procesador.getCopia());
        }
        return copia;
    }

    public void deleteProcesadores(){
        this.procesadores = new ArrayList<Procesador>();
    }
    
    public int getTiempoPeorProcesador() {
        int maxTiempoProcesador =0;
        for (Procesador p : this.procesadores) {
             maxTiempoProcesador = Math.max(maxTiempoProcesador, p.getTiempoMax());
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
        return "SolucionBacktracking [procesadores=" + procesadoresFinal + ", tiempoPeorProcesador=" + tiempoPeorProcesador
                + " Metrica " + metrica + "]";
    }
}
