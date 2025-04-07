package practica2.ejercicio04;

import practica2.ejercicio01y02.BinaryTree; 

public class RedBinariaLlena {

    public static int retardoReenvio(BinaryTree<Integer> nodo) {
        // Caso base: si es hoja, devolvemos su valor
        if (nodo.isLeaf()) {
            return nodo.getData();
        }
        
        // Calculamos recursivamente los retardos de cada hijo
        int retardoIzquierdo = 0;
        int retardoDerecho = 0;

        if (nodo.hasLeftChild()) {
            retardoIzquierdo = retardoReenvio(nodo.getLeftChild());
        }

        if (nodo.hasRightChild()) {
            retardoDerecho = retardoReenvio(nodo.getRightChild());
        }

        // Elegimos el mayor retardo entre ambos caminos
        int mayorRetardoHijo = Math.max(retardoIzquierdo, retardoDerecho);
        
        int retardoTotal = nodo.getData() + mayorRetardoHijo;

        return retardoTotal;
    }
    
}
