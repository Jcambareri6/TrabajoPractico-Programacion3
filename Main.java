package tpe;

public class Main {

	public static void main(String args[]) {
		System.out.println( "hola");
		Servicios servicios = new Servicios("tpe/datasets/Procesadores.csv", "tpe/datasets/Tareas.csv");
		servicios.getTareas();
	}
}
