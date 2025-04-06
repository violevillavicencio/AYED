package practica2.ejercicio03;

import java.util.LinkedList;
import java.util.List;
import practica2.ejercicio01y02.BinaryTree;

public class ContadorArbol {
    private BinaryTree<Integer> ab;

    public ContadorArbol(BinaryTree<Integer> ab) {
        this.ab = ab;
    }

    public List<Integer> numerosParesInOrden() {
        List<Integer> lista = new LinkedList<>();
        recorrerInOrden(this.ab, lista);
        return lista;
    }

    private void recorrerInOrden(BinaryTree<Integer> nodo, List<Integer> lista) {
        if (nodo != null) {
            if (nodo.hasLeftChild()) {
                recorrerInOrden(nodo.getLeftChild(), lista);
            }

            if (nodo.getData() % 2 == 0) {
                lista.add(nodo.getData());
            }

            if (nodo.hasRightChild()) {
                recorrerInOrden(nodo.getRightChild(), lista);
            }
        }
    }

    public List<Integer> numerosParesPostOrden() {
        List<Integer> lista = new LinkedList<>();
        recorrerPostOrden(this.ab, lista);
        return lista;
    }

    private void recorrerPostOrden(BinaryTree<Integer> nodo, List<Integer> lista) {
        if (nodo != null) {
            if (nodo.hasLeftChild()) {
                recorrerPostOrden(nodo.getLeftChild(), lista);
            }

            if (nodo.hasRightChild()) {
                recorrerPostOrden(nodo.getRightChild(), lista);
            }

            if (nodo.getData() % 2 == 0) {
                lista.add(nodo.getData());
            }
        }
    }
}
