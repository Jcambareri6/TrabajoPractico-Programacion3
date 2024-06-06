
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Servicios {

	private LinkedList<Tarea> tareasCSV;
	private ArrayList<Procesador> procesadoresCSV;

	//Estructuras para guardar las tareas
	private HashMap<String, Tarea> tareasPorId;
	LinkedList<Tarea> tareasPrioridadCritica;
	LinkedList<Tarea> tareasSinPrioridadCritica;

	//Atributos para implementar Backtracking
	private int MejorSolucion =Integer.MAX_VALUE;
	private SolucionBacktracking SolucionBacktrackingTemporal;
	private SolucionBacktracking SolucionBacktrackingFinal;
	

	// Expresar la complejidad temporal del constructor.
	// complejidad?
	public Servicios(String pathProcesadores, String pathTareas) {
		CSVReader reader = new CSVReader();
		this.tareasCSV = reader.readTasks(pathTareas);
		this.procesadoresCSV = reader.readProcessors(pathProcesadores);
		
		//Inicializacion de estructuras para tareas
		this.tareasPrioridadCritica = new LinkedList<Tarea>();
		this.tareasSinPrioridadCritica = new LinkedList<Tarea>();
		this.tareasPorId = new HashMap<String, Tarea>();
		this.AgregarTareas();

		//Inicializacion de atributos de Bacltracking
		this.SolucionBacktrackingTemporal = new SolucionBacktracking();
		this.SolucionBacktrackingFinal = new SolucionBacktracking();
	}

	private void AgregarTareas() {
		for (Tarea tarea : this.tareasCSV) {
			this.tareasPorId.put(tarea.getId(), tarea);
			if (tarea.isEsCritica()) {
				this.tareasPrioridadCritica.add(tarea);
			} else {
				this.tareasSinPrioridadCritica.add(tarea);
			}
		}
	}


	// Expresar la complejidad temporal del servicio 1.

	// Servicio 1: Dado un identificador de tarea obtener toda la información de la tarea asociada.

	// complejidad O(1)
	public Tarea servicio1(String ID) { 
		return this.tareasPorId.get(ID);
	}

	// Expresar la complejidad temporal del servicio 2.

	// Servicio 2: Permitir que el usuario decida si quiere ver todas las tareas críticas o no críticas 
	// y generar el listado apropiado resultante.

	// complejidad O(1)
	public List<Tarea> servicio2(boolean esCritica) { 
		if (esCritica) {
			return this.tareasPrioridadCritica;
		} else {
			return this.tareasSinPrioridadCritica;
		}
	}

	// Expresar la complejidad temporal del servicio 3.

	// Servicio 3: Obtener todas las tareas entre 2 niveles de prioridad indicados.

	// complejidad o (n) + o(m) donde N es la cantidad de tareas con prioridad true y m es la cantidad de tareas 
	// con prioridad false en total suma la entrada total de tareas pero estas se recorren separadas
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
		List<Tarea> tareaEntreNiveles = new LinkedList<>();
		for (Tarea tarea : this.tareasPrioridadCritica) {

			if (tarea.entrePrioridades(prioridadInferior, prioridadSuperior)) {
				tareaEntreNiveles.add(tarea);
			}
		}
		for (Tarea tarea : this.tareasSinPrioridadCritica) {
			if (tarea.entrePrioridades(prioridadInferior, prioridadSuperior)) {
				tareaEntreNiveles.add(tarea);
			}
		}
		return tareaEntreNiveles;
	}


	
	public SolucionBacktracking AsignarTareasConBacktracking(int tiempoMaximo) {
		if (tareasCSV.isEmpty()) {
			return null;
		} else {
			
			resolverBacktracking(0, tiempoMaximo);
			return this.SolucionBacktrackingFinal;
			
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
				SolucionBacktrackingTemporal.setTiempoPeorProcesador(MejorSolucion);
				this.SolucionBacktrackingFinal.deleteProcesadores();
				this.SolucionBacktrackingFinal = this.SolucionBacktrackingTemporal.getCopia();
			}
			
		    this.SolucionBacktrackingTemporal.deleteProcesadores();

		} else {
			Tarea t = this.tareasCSV.removeFirst();

			for (Procesador pr : procesadoresCSV) {
				if (pr.puedeAsignarTarea(t, tiempoMaximo) && !pr.tieneDosCriticas()) {
					int tiempoMaxPrevio = pr.getTiempoMax();
					pr.agregarTarea(t);
					pr.setTiempoMax(tiempoMaxPrevio + t.getTiempoEjecucion());
					
					if (MejorSolucion == Integer.MAX_VALUE || pr.getTiempoMax() <= MejorSolucion) {
						this.SolucionBacktrackingTemporal.addProcesador(pr.getCopia());
						int i = SolucionBacktrackingTemporal.getMetrica();
						this.SolucionBacktrackingTemporal.setMetrica(i+1);
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
}