public class TreeNodeTarea {
    private Tarea tarea;
    private TreeNodeTarea izquieda;
    private TreeNodeTarea derecha;

    public TreeNodeTarea (Tarea tarea){
        this.tarea=tarea;
        this.izquieda=null;
        this.derecha=null;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public TreeNodeTarea getIzquieda() {
        return izquieda;
    }

    public void setIzquieda(TreeNodeTarea izquieda) {
        this.izquieda = izquieda;
    }

    public TreeNodeTarea getDerecha() {
        return derecha;
    }

    public void setDerecha(TreeNodeTarea derecha) {
        this.derecha = derecha;
    }


    
}


