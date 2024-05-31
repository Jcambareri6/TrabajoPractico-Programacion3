public class Main {

	public static void main(String args[]) {
		Servicios servicios = new Servicios("datasets/Procesadores.csv", "datasets/Tareas.csv");
	// 	System.out.println(servicios.servicio1("T2"));
	// 	System.out.println(servicios.servicio2(false));
	// 	System.out.println(servicios.servicio3(31,70));
	//    servicios.resolverBacktracking(0, 9999950, 0, 0);
        // System.out.println(servicios.DevolverTareas());
		// servicios.agregarProcesadores(new Procesador("P1", "COD1", true, 2010));
		// servicios.agregarProcesadores(new Procesador("COD_P2", "COD1", true, 0));
		 System.out.println(servicios.AsignarTareas(100));
		 //servicios.tareasDeProcesadores();
		 
	}
}
