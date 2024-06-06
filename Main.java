public class Main {

	public static void main(String args[]) {
		Servicios servicios = new Servicios("datasets/Procesadores.csv", "datasets/Tareas.csv");
		System.out.println(servicios.AsignarTareasConBacktracking(250));
	}
}

public class Main {

	public static void main(String args[]) {
		Servicios servicios = new Servicios("datasets/Procesadores.csv", "datasets/Tareas.csv");
		System.out.println(servicios.AsignarTareasConBacktracking(500));
	}
}
