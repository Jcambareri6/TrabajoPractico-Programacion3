
import java.util.ArrayList;
import java.util.HashMap;

import java.util.LinkedList;
import java.util.List;

/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	private HashMap<String, Tarea> tareasPorId;// GUARDA POR ID
	private LinkedList<Tarea> tareasCSV;
	private ArrayList<Procesador> procesadoresCSV;
	LinkedList<Tarea> tareasPrioridadCritica;
	LinkedList<Tarea> tareasSinPrioridadCritica;
	private int MejorSolucion = 0;
	private SolucionBacktracking SolucionBacktracking;

	/*
	 * Expresar la complejidad temporal del constructor.
	 */
	public Servicios(String pathProcesadores, String pathTareas) {
		CSVReader reader = new CSVReader();
		this.tareasCSV = reader.readTasks(pathTareas);

		this.procesadoresCSV = reader.readProcessors(pathProcesadores);
		
		this.tareasPrioridadCritica = new LinkedList<Tarea>();
		this.tareasSinPrioridadCritica = new LinkedList<Tarea>();
		this.tareasPorId = new HashMap<String, Tarea>();
		this.AgregarTarea();

		this.SolucionBacktracking = new SolucionBacktracking();
		// reader.readTasks(pathTareas);
		// reader.readTasks(pathTareas);
	}

	public void agregarProcesadores(Procesador p) {
		this.procesadoresCSV.add(p);
	}

	private void AgregarTarea() {
		for (Tarea tarea : this.tareasCSV) {
			this.tareasPorId.put(tarea.getId(), tarea);
			if (tarea.isEsCritica()) {
				this.tareasPrioridadCritica.add(tarea);
			} else {
				this.tareasSinPrioridadCritica.add(tarea);
			}
		}
	}

	// /*
	// * Expresar la complejidad temporal del servicio 1.

	// Servicio 1: Dado un identificador de tarea obtener toda la información de la
	// tarea asociada.
	public Tarea servicio1(String ID) { // complejidad O(1)
		return this.tareasPorId.get(ID);
	}

	// *-Expresar la complejidad temporal del servicio 2.
	// -Permitir que el usuario decida si quiere ver
	// todas las tareas críticas o no críticas y generar
	// el listado apropiado resultante.*/

	public List<Tarea> servicio2(boolean esCritica) { // complejidad o(1)
		if (esCritica) {
			return this.tareasPrioridadCritica;
		} else {
			return this.tareasSinPrioridadCritica;
		}

	}

	// /*
	// * Expresar la complejidad temporal del servicio 3.
	// complejidad o (n) + o(m) donde N es la cantidad de tareas con prioridad true
	// y
	// m es la cantidad de tareas con prioridad false en total suma la entrada total
	// de tareas
	// pero estas se recorren separadas
	// * Obtener todas las tareas entre 2 niveles de prioridad indicados.
	// */
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

	public SolucionBacktracking AsignarTareas(int tiempoMaximo) {
		if (tareasCSV.isEmpty()) {
			return null;
		} else {
			this.resolverBacktracking(null,tiempoMaximo);
			return SolucionBacktracking;
		}
	}

	private void resolverBacktracking(Procesador EstadoActual, int tiempoMaximo) {
		if (this.tareasCSV.isEmpty()) {
			if(MejorSolucion==0||EstadoActual.getTiempoMax() <= MejorSolucion){
				MejorSolucion=EstadoActual.getTiempoMax();

				//guardar los procesadores	
				SolucionBacktracking.setTiempoPeorProcesador(MejorSolucion);
			} else{
				SolucionBacktracking.deleteProcesadores();
			}
		} else {
			Tarea t = tareasCSV.pop();
			for (Procesador pr : procesadoresCSV) {
				if (pr.puedeAsignarTarea(t, tiempoMaximo) && !pr.tieneDosCriticas()) {
					pr.agregarTarea(t);
					pr.setTiempoMax(pr.getTiempoMax()+t.getTiempoEjecucion()); 
					SolucionBacktracking.addProcesador(pr);

					resolverBacktracking(pr,tiempoMaximo);
					
					pr.borrarTarea(t);
					pr.setTiempoMax(pr.getTiempoMax()-t.getTiempoEjecucion()); 
						
					}			
			}
			tareasCSV.addFirst(t);	
		}
	}

	public void tareasDeProcesadores(){
		for (Procesador p: procesadoresCSV) {
			System.out.println(p + " " + p.getTareas());
		}
	}

	public int getMejorSolucion() {
		return MejorSolucion;
	}

	public void setMejorSolucion(int mejorSolucion) {
		MejorSolucion = mejorSolucion;
	}

	

	

}