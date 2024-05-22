import java.util.List;


/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	private TreeTarea tareas;

	/*
     * Expresar la complejidad temporal del constructor.
     */
	public Servicios(String pathProcesadores, String pathTareas)
	{
		CSVReader reader = new CSVReader();
		
		this.tareas = reader.readTasks(pathTareas);
		//reader.readTasks(pathTareas);																	
	}

	
	
	
	// /*
    //  * Expresar la complejidad temporal del servicio 1.
    
	 //Servicio 1: Dado un identificador de tarea obtener toda la información de la tarea asociada.
	public Tarea servicio1(String ID) {	
		return tareas.buscarId(ID);
	 }
    
    // /*
    //  *-Expresar la complejidad temporal del servicio 2.
	// -Permitir que el usuario decida si quiere ver
	// todas las tareas críticas o no críticas y generar
	// el listado apropiado resultante.*/

	public List<Tarea> servicio2(boolean esCritica) {
		return tareas.esCritica(esCritica);
	}
	 
    // /*
    //  * Expresar la complejidad temporal del servicio 3.
	//  *  Obtener todas las tareas entre 2 niveles de prioridad indicados.
    //  */
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
		return tareas.entreNiveles(prioridadInferior,prioridadSuperior);
	}
	public void recorrerEnOrden(){
		this.tareas.imprimirEnOrdenPublico();
	}



	//PARTE 2

	/*hora se desea establecer una asignación de todas las tareas a los distintos procesadores con el
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
