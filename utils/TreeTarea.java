import java.util.ArrayList;
import java.util.List;

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

    private void agregar(TreeNodeTarea tarea, Tarea valor) {
        if (tarea.getValor().getNivelDePrioridad() > valor.getNivelDePrioridad()) {
            if(tarea.getIzq() == null) {
                TreeNodeTarea aux = new TreeNodeTarea(valor);
                tarea.setIzq(aux);
            } else {
                agregar(tarea.getIzq(),valor);
            }
        }else if (tarea.getValor().getNivelDePrioridad() < valor.getNivelDePrioridad()) {
            if (tarea.getDer() == null) {
                TreeNodeTarea aux = new TreeNodeTarea(valor);
                tarea.setDer(aux);
            } else {
                agregar(tarea.getDer(),valor);
            }
        }
    }

    public Tarea buscarId(String Id) {
        if (this.root==null){
            return null;
        }else{
            return this.buscarId(this.root,Id);
        }
    }

    private Tarea buscarId(TreeNodeTarea tarea, String Id) {
        if (tarea.getValor().getId()==Id){
            return tarea.getValor();
        }
        if (tarea.getIzq() != null){
            return (buscarId(tarea.getIzq(),Id));
        }
        if (tarea.getDer() != null){
            return (buscarId(tarea.getDer(),Id));
        }
        return tarea.getValor();
    }

    public List<Tarea> esCritica(boolean esCritica){
        if (this.root==null){
            return new ArrayList<>();
        }else{
            return this.esCritica(this.root,esCritica);
        }
    }

    private List<Tarea> esCritica(TreeNodeTarea tarea, boolean esCritica){
        List<Tarea> tareas = new ArrayList<>();

        if (tarea.getValor().isEsCritica()==esCritica){
            tareas.add(tarea.getValor());
        }
        if (tarea.getIzq() != null){
            tareas.addAll(esCritica(tarea.getIzq(),esCritica));
        }
        if (tarea.getDer() != null){
            tareas.addAll(esCritica(tarea.getDer(),esCritica));
        }
        return tareas;
    }


    public List<Tarea> entreNiveles(int prioridadInferior, int prioridadSuperior){
        if (this.root==null){
            return new ArrayList<>();
        }else{
            return this.entreNiveles(this.root,prioridadInferior,prioridadSuperior);
        }
    }

    private List<Tarea> entreNiveles(TreeNodeTarea tarea, int prioridadInferior, int prioridadSuperior){
        List<Tarea> tareas = new ArrayList<>();

        if (tarea.getValor().getNivelDePrioridad()>=prioridadInferior 
            && tarea.getValor().getNivelDePrioridad()<=prioridadSuperior ){

            tareas.add(tarea.getValor());
        }
        if (tarea.getIzq() != null){
            tareas.addAll(entreNiveles(tarea.getIzq(),prioridadInferior, prioridadSuperior));
        }
        if (tarea.getDer() != null){
            tareas.addAll(entreNiveles(tarea.getDer(),prioridadInferior, prioridadSuperior));
        }
        return tareas;
    }
}
    
