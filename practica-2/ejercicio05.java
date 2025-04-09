package practica2.ejercicio05;

import practica2.ejercicio01y02.BinaryTree;
import implCola.Queue;

public class ProfundidadDeArbolBinario {
    BinaryTree<Integer> arbol;

    public void setArbol(BinaryTree<Integer> data) {
        this.arbol = data;
    }

    // devuelve la suma de todos los nodos del árbol que se encuentren a la profundidad pasada como argumento.
    public int sumaElementosProfundidad(int p) {
        Queue<BinaryTree<Integer>> cola = new Queue<>();

        cola.enqueue(arbol);
        cola.enqueue(null); // marcador de fin de nivel

        int suma = 0;
        int nivel = 0;

        while (!cola.isEmpty()) {
            BinaryTree<Integer> aux = cola.dequeue();

            if (aux != null) {
                if (nivel == p) {
                    suma += aux.getData();
                }
                // Solo encolamos hijos si aún no estamos en el nivel p
                if (nivel < p) {
                    if (aux.hasLeftChild())
                        cola.enqueue(aux.getLeftChild());
                    if (aux.hasRightChild())
                        cola.enqueue(aux.getRightChild());
                }
            } else if (!cola.isEmpty()) {
                nivel++;
                cola.enqueue(null);
            }
        }
        return suma;
    }

    public static void main(String[] args) {
        // Árbol:
        //         14
        //        /  \
        //      53    2
        //     / \   / \
        //   12  9  33 102

        // declaración de nodos
        BinaryTree<Integer> catorce = new BinaryTree<>(14);
        BinaryTree<Integer> cincuentaYTres = new BinaryTree<>(53);
        BinaryTree<Integer> dos = new BinaryTree<>(2);
        BinaryTree<Integer> doce = new BinaryTree<>(12);
        BinaryTree<Integer> nueve = new BinaryTree<>(9);
        BinaryTree<Integer> treintaYTres = new BinaryTree<>(33);
        BinaryTree<Integer> cientoDos = new BinaryTree<>(102);

        // construcción del árbol
        catorce.addLeftChild(cincuentaYTres);
        catorce.addRightChild(dos);
        cincuentaYTres.addLeftChild(doce);
        cincuentaYTres.addRightChild(nueve);
        dos.addLeftChild(treintaYTres);
        dos.addRightChild(cientoDos);

        // instancia de la clase
        ProfundidadDeArbolBinario p = new ProfundidadDeArbolBinario();
        p.setArbol(catorce);

        // uso del método
        System.out.println("La suma de los nodos en profundidad 2 es: " + p.sumaElementosProfundidad(1));
    }
}
