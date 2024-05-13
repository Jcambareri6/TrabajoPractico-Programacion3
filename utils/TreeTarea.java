public class TreeTarea {
    private TreeNodeTarea root;

    public TreeTarea() {
        this.root = null;

    }

    public void agregar(Tarea valor) {
        if (this.root == null)
            this.root = new TreeNodeTarea(valor);
        else
            this.agregar(this.root,valor);
    }

    private void agregar(TreeNodeTarea nodo, Tarea valor) {
        if (nodo.getValor().getNivelDePrioridad() > valor.getNivelDePrioridad()) {
            if(nodo.getIzq() == null) {
                TreeNodeTarea aux = new TreeNodeTarea(valor);
                nodo.setIzq(aux);
            } else {
                agregar(nodo.getIzq(),valor);
            }
        }else if (nodo.getValor().getNivelDePrioridad() < valor.getNivelDePrioridad()) {
            if (nodo.getDer() == null) {
                TreeNodeTarea aux = new TreeNodeTarea(valor);
                nodo.setDer(aux);
            } else {
                agregar(nodo.getDer(),valor);
            }
        }
    }

    public Tarea buscarTarea(String Id) {
        if (this.root==null){
            return null;
        }else{
            return this.buscarTarea(this.root,Id);
        }
    }

    private Tarea buscarTarea(TreeNodeTarea nodo, String Id) {
        if (nodo.getValor().getId() != Id) {
            if (nodo.getIzq() != null){
                return buscarTarea(nodo.getIzq(),Id);
            }
            if (nodo.getDer() != null){
                return buscarTarea(nodo.getDer(),Id);
            }
        }
        if (nodo.getValor().getId() == Id){
            return nodo.getValor();
        } else return null;
    }
}
    
