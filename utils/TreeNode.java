
public class TreeNode <T extends Comparable<T>>{
     private T valor; 
     private TreeNode<T> izq;
     private TreeNode<T> der;
    public TreeNode(T valor) {
        this.valor= valor; 
        this.izq = null; 
        this.der=null; 
    }
    public TreeNode<T> getIzq() {
        return izq; 
    }
    public void setIzq(TreeNode <T>  izq) {
        this.izq = izq;
    }
    public TreeNode <T> getDer() {
        return der;
    }
    public void setDer(TreeNode <T>  der) {
        this.der = der;
    }
    public T getValor() {
        return valor;
    }
    public void setValor(T valor) {
        this.valor = valor;
    } 
    
    
     

}
