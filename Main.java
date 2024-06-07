public class Main {

	public static void main(String args[]) {
		Servicios servicios = new Servicios("datasets/Procesadores.csv", "datasets/Tareas.csv");
		servicios.servicio1("T1");
		servicios.servicio1("T3");
		servicios.servicio2(true);
		servicios.servicio2(false);
		servicios.servicio3(30, 200);
		servicios.servicio3(60, 100);
	}
}
