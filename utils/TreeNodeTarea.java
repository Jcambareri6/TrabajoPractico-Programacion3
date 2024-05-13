public class TreeNodeTarea {
        private Tarea valor; 
        private TreeNodeTarea izq;
        private TreeNodeTarea der;
   
        
       public TreeNodeTarea(Tarea valor) {
           this.valor= valor; 
           this.izq = null; 
           this.der=null; 
       }
       public TreeNodeTarea getIzq() {
           return izq; 
       }
       public void setIzq(TreeNodeTarea  izq) {
           this.izq = izq;
       }
       public TreeNodeTarea getDer() {
           return der;
       }
       public void setDer(TreeNodeTarea  der) {
           this.der = der;
       }
       public Tarea getValor() {
           return valor;
       }
       public void setValor(Tarea valor) {
           this.valor = valor;
       } 
       
}
