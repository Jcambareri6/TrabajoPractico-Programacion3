

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.print.DocFlavor.STRING;


/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	private HashMap<String,Tarea> tareasPorId;//GUARDA POR ID 
	private ArrayList<Tarea> tareasCSV;
	LinkedList <Tarea> tareasPrioridadCritica;
	LinkedList <Tarea> tareasSinPrioridadCritica;

	/*
     * Expresar la complejidad temporal del constructor.
     */
	public Servicios(String pathProcesadores, String pathTareas)
	{
		CSVReader reader = new CSVReader();
		this.tareasCSV= reader.readTasks(pathTareas);
		this.tareasPrioridadCritica = new LinkedList<Tarea>();
		this.tareasSinPrioridadCritica= new LinkedList<Tarea>();
		this.tareasPorId =  new HashMap<String,Tarea>();
		this.AgregarTarea();
		
		
		//reader.readTasks(pathTareas);
		//reader.readTasks(pathTareas);																	
	}
	
	private void AgregarTarea(){
		for (Tarea tarea : this.tareasCSV) {
			this.tareasPorId.put(tarea.getId(), tarea);
			if(tarea.isEsCritica()){
				this.tareasPrioridadCritica.add(tarea);
			}else{
				this.tareasSinPrioridadCritica.add(tarea);
			}
		}
	}
	
	
	// /*
    //  * Expresar la complejidad temporal del servicio 1.
    
	 //Servicio 1: Dado un identificador de tarea obtener toda la información de la tarea asociada.
	public Tarea servicio1(String ID) {	//complejidad o O(1)
		return this.tareasPorId.get(ID);
	 }
    

    //  *-Expresar la complejidad temporal del servicio 2.
	// -Permitir que el usuario decida si quiere ver
	// todas las tareas críticas o no críticas y generar
	// el listado apropiado resultante.*/

	 public List<Tarea> servicio2(boolean esCritica) {
		if(esCritica){
		 return new LinkedList<>(this.tareasPrioridadCritica); // cuanto es la complejida?
		}else{
			return new LinkedList<>(this.tareasSinPrioridadCritica);
		}
	 	
	 }
	 
    // /*
    //  * Expresar la complejidad temporal del servicio 3.
	//  *  Obtener todas las tareas entre 2 niveles de prioridad indicados.
    //  */
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
	 	List <Tarea> tareaEntreNiveles = new LinkedList<>();
		for (Tarea tarea : this.tareasPrioridadCritica) {
		
			if(tarea.entrePrioridades(prioridadInferior, prioridadSuperior)){
				tareaEntreNiveles.add(tarea);
			}
		} 
		for (Tarea tarea : this.tareasSinPrioridadCritica) {
		   if(tarea.entrePrioridades(prioridadInferior, prioridadSuperior)){
			   tareaEntreNiveles.add(tarea);
		   }
	  	 } 
		return tareaEntreNiveles;
	 }
	// public void recorrerEnOrden(){
	// 	this.tareas.imprimirEnOrdenPublico();
	// }



	//PARTE 2

	/*ahora se desea establecer una asignación de todas las tareas a los distintos procesadores con el
	objetivo de minimizar el tiempo final de ejecución. Establecemos el tiempo final de ejecución como el
	tiempo máximo de ejecución de un procesador una vez que todas las tareas fueron asignadas.
	Además, se sabe que tenemos ciertas restricciones para asignar una tarea a un procesador:
	● Primero, ningún procesador podrá ejecutar 2 tareas críticas de forma consecutiva.
	● Segundo, los procesadores no refrigerados no podrán dedicar más de X tiempo de ejecución a
	las tareas asignadas. El tiempo X será un parámetro establecido por el usuario al momento de
	solicitar la asignación de las tareas a los procesadores.
	*/

	/* EJEMPLO DE ESTRUCTURA BACKTRACKING
	 void BackAtila (estado e, int nroPisada) {
    if ( ! e.HayMovimientos() ){
        if (( nroPisada== e.cantPisadas() ) && (e.vecinaOrigen())){
            imprimirSolucion(e); 
        }
    } else{
            movimiento movSgte;
            int nrohijo=1;
            while ( hijos(nrohijo, e, movSgte)){
                if ( e.esFactible(movSgte) ){
                    BackAtila( e.aplicarMov(movSgte), nroPisada+1);
                    nrohijo++;
                }
            }
    }
	}
	 */


}
