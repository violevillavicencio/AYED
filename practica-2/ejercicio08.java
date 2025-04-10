package practica2.ejercicio8;

import practica2.ejercicio01y02.BinaryTree; 

public class ParcialArboles {

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        // Si arbol1 es null, es vacíamente prefijo de cualquiera
        if (arbol1 == null) return true;

        // Si arbol1 no es null pero arbol2 sí, no puede ser prefijo
        if (arbol2 == null) return false;

        // Si los datos no coinciden, no es prefijo
        if (!arbol1.getData().equals(arbol2.getData())) return false;

        // Verificamos recursivamente los hijos
        boolean izq = true;
        boolean der = true;

        if (arbol1.hasLeftChild()) {
            if (!arbol2.hasLeftChild()) return false;
            izq = esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
        }

        if (arbol1.hasRightChild()) {
            if (!arbol2.hasRightChild()) return false;
            der = esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
        }

        return izq && der;
    }
}
