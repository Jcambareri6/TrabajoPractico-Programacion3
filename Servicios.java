
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Servicios {

	private LinkedList<Tarea> tareasCSV;
	

	//Estructuras para guardar las tareas
	private HashMap<String, Tarea> tareasPorId;
	LinkedList<Tarea> tareasPrioridadCritica;
	LinkedList<Tarea> tareasSinPrioridadCritica;

	// Expresar la complejidad temporal del constructor.
	// complejidad o(n)
	public Servicios(String pathProcesadores, String pathTareas) {
		CSVReader reader = new CSVReader();
		this.tareasCSV = reader.readTasks(pathTareas); // o(n)
	
		
		//Inicializacion de estructuras para tareas
		this.tareasPrioridadCritica = new LinkedList<Tarea>(); //o(1)
		this.tareasSinPrioridadCritica = new LinkedList<Tarea>();//o(1)
		this.tareasPorId = new HashMap<String, Tarea>();//o(1)
		this.AgregarTareas(); //o(n)
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
}