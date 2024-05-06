public class TreeTarea {
    private TreeNodeTarea raiz;

    public TreeTarea() {
        this.raiz = null;
    }

    public void agregar(Tarea tarea) {
        if (this.raiz == null)
            this.raiz = new TreeNodeTarea(tarea);
        else
            this.agregar(this.raiz,tarea);
    }

    private void agregar(TreeNodeTarea nodo, Tarea tarea) {
        if (nodo.getTarea().getNivelDePrioridad() > tarea.getNivelDePrioridad()) {
            if(nodo.getIzquieda() == null) {
                TreeNodeTarea aux = new TreeNodeTarea(tarea);
                nodo.setIzquieda(aux);
            } else {
                agregar(nodo.getIzquieda(),tarea);
            }
        }else if (nodo.getTarea().getNivelDePrioridad() < tarea.getNivelDePrioridad()) {
            if (nodo.getDerecha() == null) {
                TreeNodeTarea aux = new TreeNodeTarea(tarea);
                nodo.setDerecha(aux);
            } else {
                agregar(nodo.getDerecha(),tarea);
            }
        }
    }
    public TreeNodeTarea getRaiz() {
        return raiz;
    }

    public void setRaiz(TreeNodeTarea raiz) {
        this.raiz = raiz;
    }

    
}

