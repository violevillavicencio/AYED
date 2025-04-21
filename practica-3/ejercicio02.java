package practica3.ejercicio02;

import java.util.LinkedList;
import java.util.List;
import practica3.ejercicio01.GeneralTree; 
import implCola.Queue;
/**
 *
 * @author Usuario
 */
public class RecorridosAG {
    
   
    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){
        List<Integer> lista = new LinkedList<>();
        if(!a.isEmpty())
            numerosImparesMayoresQuePreOrden(a,n,lista);
        return lista; 
    }
    
    private void numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n,List<Integer> lista){
        int dato = a.getData(); 
        if ((dato % 2 != 0) && (dato > n))
            lista.add(dato); 
        List<GeneralTree<Integer>> children = a.getChildren();
        for(GeneralTree<Integer> child: children) {
            numerosImparesMayoresQuePreOrden(child, n, lista);        
        }
    }
    
    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree<Integer> a, Integer n) {
        List <Integer> lista = new LinkedList<>();
        if(!a.isEmpty()) 
            numerosImparesMayoresQueInOrden(a, n, lista);
        return lista;
    }
    
    private void numerosImparesMayoresQueInOrden (GeneralTree<Integer> a, Integer n, List<Integer> lista) {
        List<GeneralTree<Integer>> children = a.getChildren();
        if(a.hasChildren()) {
            numerosImparesMayoresQueInOrden(children.get(0), n, lista);
        }
        int dato = a.getData();
        if(dato %2 != 0 && dato > n) 
            lista.add(dato);
        for(int i=1; i < children.size(); i++) {
            numerosImparesMayoresQueInOrden(children.get(i), n, lista);
        }
    }
    
     public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n) {
        List <Integer> lista = new LinkedList<>();
        if(!a.isEmpty()) 
            numerosImparesMayoresQuePostOrden(a, n, lista);
        return lista;
    }
    
    private void numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n, List<Integer> lista) {
        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> child: children) {
            numerosImparesMayoresQuePostOrden(child, n, lista);
        }
        int dato = a.getData();
        if(dato %2 != 0 && dato > n) 
            lista.add(dato);
    }
    
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
    List<Integer> result = new LinkedList<>();
    Queue<GeneralTree<Integer>> queue = new Queue<>();
    queue.enqueue(a);
    
    while (!queue.isEmpty()) {
        GeneralTree<Integer> current = queue.dequeue();
        
        if (!current.isEmpty()) {
            Integer dato = current.getData();
            if (dato != null && dato % 2 != 0 && dato > n) {
                result.add(dato);
            }
            for (GeneralTree<Integer> child : current.getChildren()) {
                queue.enqueue(child);
            }
        }
    }
    return result;
}

}
