

public class TreeNode<T> {
     private T objeto; 
     private TreeNode izq;
     private TreeNode der;
    public TreeNode(T objeto) {
        this.objeto= objeto; 
        this.izq = null; 
        this.der=null; 
    }
    public TreeNode getIzq() {
        return izq;
    }
    public void setIzq(TreeNode izq) {
        this.izq = izq;
    }
    public TreeNode getDer() {
        return der;
    }
    public void setDer(TreeNode der) {
        this.der = der;
    }
    public Integer getobjeto() {
        return objeto;
    }
    public void setobjeto(Integer objeto) {
        this.objeto = objeto;
    } 
    
public static void main(String[] args) {
   Tarea t1 = new Tarea("T1", 100 , "joaquin", false, 10);
   TreeNode<Tarea> = new TreeNode<>(t1);
}    
     

}
