public class MainGreedy {

	public static void main(String args[]) {
		SolucionGreedy SolucionGreedy = new SolucionGreedy("datasets/Procesadores.csv", "datasets/Tareas.csv");

	    System.out.println(SolucionGreedy.AsignarTareasConGreedy(200));
    
	}
}