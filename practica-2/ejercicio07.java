package practica2.ejercicio07;

import practica2.ejercicio01y02.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;
    
    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol; 
    }
    
    public boolean isLeftTree(int num) {
        return cumple(num, arbol); 
    }

    private boolean cumple(int num, BinaryTree<Integer> nodo) {
        if (nodo == null) return false;

        if (nodo.getData() == num) {
            int hi, hd;

            if (!nodo.hasLeftChild()) {
                hi = -1;
            } else {
                hi = contarUnicoHijo(nodo.getLeftChild());
            }

            if (!nodo.hasRightChild()) {
                hd = -1;
            } else {
                hd = contarUnicoHijo(nodo.getRightChild());
            }

            return hi > hd;
        }

        // Buscar en subárbol izquierdo
        if (nodo.hasLeftChild() && cumple(num, nodo.getLeftChild())) {
            return true;
        }

        // Buscar en subárbol derecho
        if (nodo.hasRightChild() && cumple(num, nodo.getRightChild())) {
            return true;
        }

        return false;
    }

    private int contarUnicoHijo(BinaryTree<Integer> nodo) {
        if (nodo == null) return 0;

        int cuenta = 0;

        boolean tieneIzq = nodo.hasLeftChild();
        boolean tieneDer = nodo.hasRightChild();

        if ((tieneIzq && !tieneDer) || (!tieneIzq && tieneDer)) {
            cuenta = 1;
        }

        if (tieneIzq) {
            cuenta += contarUnicoHijo(nodo.getLeftChild());
        }

        if (tieneDer) {
            cuenta += contarUnicoHijo(nodo.getRightChild());
        }

        return cuenta;
    }
    
    public static void main(String[] args) {
        // Creamos los nodos del árbol
        BinaryTree<Integer> raiz = new BinaryTree<>(10);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo15 = new BinaryTree<>(15);}
        BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo20 = new BinaryTree<>(20);

        // Armamos la estructura del árbol
        raiz.addLeftChild(nodo5);
        raiz.addRightChild(nodo15);
        nodo5.addLeftChild(nodo2);     // Nodo 5 tiene un solo hijo (izquierdo)
        nodo15.addRightChild(nodo20);  // Nodo 15 tiene un solo hijo (derecho)

        // Creamos una instancia de ParcialArboles y seteamos el árbol
        ParcialArboles parcial = new ParcialArboles();
        parcial.setArbol(raiz);

        // Probamos con diferentes valores
        System.out.println("isLeftTree(10): " + parcial.isLeftTree(10)); // false, 1 = 1
        System.out.println("isLeftTree(5): " + parcial.isLeftTree(5));   // true, izq tiene 1, der no existe (-1)
        System.out.println("isLeftTree(15): " + parcial.isLeftTree(15)); // false, izq no existe (-1), der tiene 1
        System.out.println("isLeftTree(20): " + parcial.isLeftTree(20)); // false, no tiene hijos
        System.out.println("isLeftTree(999): " + parcial.isLeftTree(999)); // false, no existe
    }
}
