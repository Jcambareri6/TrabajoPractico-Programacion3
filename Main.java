public class Main {

	public static void main(String args[]) {
		Servicios servicios = new Servicios("datasets/Procesadores.csv", "datasets/Tareas.csv");
		System.out.println(servicios.servicio1("T1"));
		System.out.println(servicios.servicio1("T3"));
		System.out.println(servicios.servicio2(true));
		System.out.println(servicios.servicio2(false));
		System.out.println(servicios.servicio3(30, 200));
		System.out.println(servicios.servicio3(60, 100));
	}
}


