public class MainBacktracking {
    
    public static void main (String args[]){
    SolucionBacktracking SolucionBacktracking = new SolucionBacktracking("datasets/Procesadores.csv", "datasets/Tareas.csv");
    System.out.println(SolucionBacktracking.AsignarTareasConBacktracking(3000));
    }
}
