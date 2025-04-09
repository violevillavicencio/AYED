package practica2.ejercicio06;

import practica2.ejercicio01y02.BinaryTree; 
/**
 *
 * @author Usuario
 */

import practica2.ejercicio01y02.BinaryTree;

public class Transformacion {

    private BinaryTree<Integer> arbol;

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    // Método público que inicia la transformación
    public BinaryTree<Integer> suma() {
        transformar(arbol);
        return arbol;
    }

    // Método recursivo que transforma el árbol y devuelve la suma total del subárbol
    private int transformar(BinaryTree<Integer> ab) {
        if (ab == null) {
            return 0;
        }

        if (ab.isLeaf()) {
            int valorOriginal = ab.getData();
            ab.setData(0); // los subárboles vacíos suman 0, así que reemplazamos por 0
            return valorOriginal;
        }

        int sumaIzq = transformar(ab.getLeftChild());
        int sumaDer = transformar(ab.getRightChild());

        int valorOriginal = ab.getData();
        ab.setData(sumaIzq + sumaDer); // reemplazamos el valor del nodo

        return sumaIzq + sumaDer + valorOriginal; // retornamos la suma total para el padre
    }
}
