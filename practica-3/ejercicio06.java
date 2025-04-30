import java.util.List;
import practica3.ejercicio01_03y05.GeneralTree;

public class RedDeAguaPotable {
    private GeneralTree<Character> arbol;
    
    public RedDeAguaPotable(GeneralTree<Character> arbol) {
        this.arbol = arbol;
    }
    
    public double minimoCaudal(double caudal) {
        if((arbol != null) && (!arbol.isEmpty())) 
            return recorrer(arbol, caudal); 
        return 0; 
    }
    
    private double recorrer(GeneralTree<Character> arbol, double caudal){
        if(arbol.isLeaf()) {
            return caudal;
        }
        else {
            List<GeneralTree<Character>> children = arbol.getChildren(); 
            double cantPorCaudal = caudal / children.size(); 
            double caudalMin = Double.MAX_VALUE; 
            for(GeneralTree<Character> child: children){
                double caudalHijo = recorrer(child, cantPorCaudal); 
                caudalMin = Math.min(caudalMin, caudalHijo); 
            }
            return caudalMin;
        } 
    }
    
}
