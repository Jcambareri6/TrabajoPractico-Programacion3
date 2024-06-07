public class MainGreedy {

	public static void main(String args[]) {
        System.out.println("hola");
		SolucionGreedy Solucion = new SolucionGreedy("datasets/Procesadores.csv", "datasets/Tareas.csv");
        System.out.println(Solucion.AsignarTareasConGreedy(250));
	    
       
		
		 
	}
}