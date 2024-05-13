

import java.util.ArrayList;
import java.util.List;


/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	private Tree <Tarea> tareas;
	private Tree <Procesador> procesadores;
	
	/*
     * Expresar la complejidad temporal del constructor.
     */
	public Servicios(String pathProcesadores, String pathTareas)
	{
		CSVReader reader = new CSVReader();
		tareas = reader.readTasks(pathTareas);
		procesadores = reader.readProcessors(pathProcesadores);															
	}

	// /*
    //  * Expresar la complejidad temporal del servicio 1.
    //  */
	// //Servicio 1: Dado un identificador de tarea obtener toda la información de la tarea asociada.
	public Tarea servicio1(String ID) {	
		Tarea tarea = tareas.HasElement(ID);
	}
    
    // /*
    //  *-Expresar la complejidad temporal del servicio 2.
	// -Permitir que el usuario decida si quiere ver
	// todas las tareas críticas o no críticas y generar
	// el listado apropiado resultante.*/

	// public List<Tarea> servicio2(boolean esCritica) {}

    // /*
    //  * Expresar la complejidad temporal del servicio 3.
	//  *  Obtener todas las tareas entre 2 niveles de prioridad indicados.
    //  */
	// public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {}

}
