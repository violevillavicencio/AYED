package practica3.ejercicio07;

import java.util.LinkedList;
import java.util.List;
import practica3.ejercicio01_03y05.GeneralTree;

public class Caminos {
    private GeneralTree<Integer> arbol;

    public List<Integer> caminoAHojaMasLejana() {
        List<Integer> resultado = new LinkedList<>();
        if (arbol != null && !arbol.isEmpty()) {
            List<Integer> caminoActual = new LinkedList<>();
            recorrer(arbol, caminoActual, resultado);
        }
        return resultado;
    }

    private void recorrer(GeneralTree<Integer> nodo, List<Integer> caminoActual, List<Integer> resultado) {
        caminoActual.add(nodo.getData());

        if (nodo.isLeaf()) {
            if (caminoActual.size() > resultado.size()) {
                resultado.clear();
                resultado.addAll(caminoActual);
            }
        } else {
            for (GeneralTree<Integer> hijo : nodo.getChildren()) {
                recorrer(hijo, caminoActual, resultado);
            }
        }

        // Backtracking: eliminar el último nodo agregado al camino
        caminoActual.remove(caminoActual.size() - 1);
    }
}
