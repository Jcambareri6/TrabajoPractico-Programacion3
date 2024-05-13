

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

 
    // public boolean HasElement(int valor) {
    //     if (this.root == null) {
    //         return false;
    //     } else {
    //         return HasElement(this.root, valor);
    //     }
    // }

    // private boolean HasElement(TreeNode nodo, int valor) {
    //     if (nodo.getValor() > valor) {
    //         if (nodo.getIzq() != null) {
    //             return HasElement(nodo.getIzq(), valor);
    //         }
    //     } else {
    //         if (nodo.getDer() != null) {
    //             return HasElement(nodo.getDer(), valor);
    //         } else if (nodo.getValor() == valor) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

   

    public T GetRoot() {
        return this.root.getValor();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    // public int getHeight() {
    //     if (this.root == null) {
    //         return -1;
    //     } else {
    //         return getHeight(this.root);
    //     }

    // }

    // private int getHeight(TreeNode node) {
        
    //     if (node == null) {
    //         return -1; // altura de un árbol vacío es -1
    //     } else {
            
    //         int leftHeight = getHeight(node.getIzq());
        
    //         int rightHeight = getHeight(node.getDer());
            
           
           
    //         if (leftHeight > rightHeight) {
                
    //             return leftHeight + 1;
    //         } else {
    //             return rightHeight + 1; 
    //         }
    //     }
    // }
    // public ArrayList<Integer> getfrontera(){
    //     if(this.root==null){
    //         return new ArrayList<>();
    //     }else{
    //         return getFrontera(this.root);
    //     }
    // }
    // private ArrayList <Integer> getFrontera (TreeNode nodo){
    //     if (nodo.getDer()==null && nodo.getIzq()==null){
    //         ArrayList <Integer> Solucion = new ArrayList<>();
    //         Solucion.add(nodo.getValor());
    //         return Solucion;
    //     }else if(nodo.getDer()!=null){
    //         return getFrontera(nodo.getDer());
    //     }
    //     return getFrontera(nodo.getIzq());

    // }
    // private ArrayList<Integer> getFrontera(TreeNode nodo) {
    //     ArrayList<Integer> solucion = new ArrayList<>();
    //     if (nodo.getIzq() == null && nodo.getDer() == null) {
    //         // Es un nodo hoja, añadir su valor a la lista de soluciones
    //         solucion.add(nodo.getValor());
    //     } else {
    //         // De lo contrario, verifica ambos subárboles (si existen) y agrega sus nodos frontera
    //         if (nodo.getIzq() != null) {
    //             solucion.addAll(getFrontera(nodo.getIzq()));
    //         }
    //         if (nodo.getDer() != null) {
    //             solucion.addAll(getFrontera(nodo.getDer()));
    //         }
    //     }
    //     return solucion;
    // }
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

    // private TreeNode findMin(TreeNode node) {
    //     while (node.getIzq() != null) {
    //         node = node.getIzq();
    //     }
    //     return node;
    // }
    public void imprimirEnOrdenPublico() {
         imprimirEnOrden(this.root); // Llama al método privado con la raíz del árbol
     }
     public void imprimirPreOrden() {
         imprimirPreOrden(this.root); // Llama al método privado con la raíz del árbol
     }
     public void imprimirPosOrden() {
        imprimirPosOrden(this.root); // Llama al método privado con la raíz del árbol
     }
     private void imprimirPreOrden(TreeNode<T> nodo) {
        if (nodo == null) {
            
            return;
        }
        System.out.print(nodo.getValor() + " "); 
        imprimirPreOrden(nodo.getIzq()); 
         imprimirPreOrden(nodo.getDer()); 
     }
     private void imprimirEnOrden(TreeNode <T> nodo) {
         if (nodo == null) return;
        imprimirEnOrden(nodo.getIzq()); // Cambio aquí
         System.out.print(nodo.getValor() + " ");
         imprimirEnOrden(nodo.getDer()); // Cambio aquí
     }
     private void imprimirPosOrden(TreeNode nodo) {
        if (nodo == null) {
          return ;
         }
       
        imprimirPreOrden(nodo.getIzq()); 
        imprimirPreOrden(nodo.getDer()); 
       System.out.print(nodo.getValor() + " "); 
    }
    

  
}
    


