

//arbol de objetos solo admite objetos que implementen la interfaz comparable
public class Tree <T extends Comparable<T>> {
    private TreeNode<T> root;

    public Tree() {
        this.root = null;

    }

    public void Agregar(T valor) {
        if (this.root == null) {
            this.root = new TreeNode<T>(valor);
        } else {
            Agregar(this.root, valor);
        }
    }

    private void Agregar(TreeNode<T> nodo, T valor) {
        if (nodo.getValor().compareTo(valor)<0) {
            if (nodo.getIzq() == null) {
                TreeNode<T> NodoTemp = new TreeNode<T>(valor);
                nodo.setIzq(NodoTemp);

            } else {
                Agregar(nodo.getIzq(), valor);
            }
        } else if (nodo.getValor().compareTo(valor)>0) {
            if (nodo.getDer() == null) {
                TreeNode<T> NodoTemp = new TreeNode<T>(valor);
                nodo.setDer(NodoTemp);

            } else {
                Agregar(nodo.getDer(), valor);
            }
        }
    }

    public T HasElement(String id) {
        if (this.root == null) {
            return null;
        } else {
            return HasElement(this.root, id);
        }
    }

 

   

    public T GetRoot() {
        return this.root.getValor();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    // public boolean delete (int valor ){
    //     if(this.root == null){
    //         return false; 
    //     }
    //     return deleteR(this.root, valor, null);

    // } 
    // private boolean deleteR ( TreeNode nodoActual ,int  valor,TreeNode nodoPadre){
    //     if(nodoActual.getValor()==valor){
    //         return deleteNode(nodoActual,nodoPadre);
    //     }else if(nodoActual.getValor()<valor){
    //         return deleteR(nodoActual.getDer(), valor, nodoActual);
    //     }else{
    //         return deleteR(nodoActual.getIzq(), valor, nodoActual);
    //     }
        
    // }

    // private boolean deleteNode(TreeNode nodoActual, TreeNode nodoPadre) {
    //     // Nodo con dos hijos
    //     if (nodoActual.getIzq() != null && nodoActual.getDer() != null) {
    //         TreeNode sucesor = findMin(nodoActual.getDer());
    //         int sucesorValor = sucesor.getValor();
    //         delete(sucesorValor);  // Eliminar el sucesor
    //         nodoActual.setValor(sucesorValor);  // Reemplazar valor del nodo a eliminar con el del sucesor
    //         return true;
    //     }
    
    //     // Nodo con un hijo o ninguno
    //     TreeNode nuevoHijo = null;
    //     if (nodoActual.getIzq() != null) nuevoHijo = nodoActual.getIzq();
    //     else if (nodoActual.getDer() != null) nuevoHijo = nodoActual.getDer();
    
    //     if (nodoPadre == null) {
    //         this.root = nuevoHijo;  // Caso especial si el nodo a eliminar es la raíz
    //     } else if (nodoPadre.getIzq() == nodoActual) {
    //         nodoPadre.setIzq(nuevoHijo);
    //     } else {
    //         nodoPadre.setDer(nuevoHijo);
    //     }
    
    //     return true;
    // }

     public void imprimirPreOrden() {
         imprimirPreOrden(this.root); // Llama al método privado con la raíz del árbol
     }
     private void imprimirPreOrden(TreeNode<T> nodo) {
        if (nodo == null) {
            
            return;
        }
        System.out.print(nodo.getValor() + " "); 
        imprimirPreOrden(nodo.getIzq()); 
         imprimirPreOrden(nodo.getDer()); 
     }

  
}
    


