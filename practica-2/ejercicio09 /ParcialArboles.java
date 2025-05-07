package practica2.ejercicio09;

import practica2.ejercicio01y02.BinaryTree;

public class ParcialArboles {

    public BinaryTree<SumaYDif> sumaYDif(BinaryTree<Integer> arbol) {
        BinaryTree<SumaYDif> nuevo = new BinaryTree<>();
        if (arbol != null && !arbol.isEmpty())
            recorrer(arbol, nuevo, 0, 0);
        return nuevo;
    }

    private void recorrer(BinaryTree<Integer> arbol, BinaryTree<SumaYDif> nuevo, int suma, int valorPadre) {
        SumaYDif datos = new SumaYDif();
        datos.setSuma(arbol.getData() + suma);
        datos.setDif(arbol.getData() - valorPadre);
        nuevo.setData(datos);

        if (arbol.hasLeftChild()) {
            BinaryTree<SumaYDif> hijoIzquierdo = new BinaryTree<>();
            nuevo.addLeftChild(hijoIzquierdo);
            recorrer(arbol.getLeftChild(), hijoIzquierdo, datos.getSuma(), arbol.getData());
        }

        if (arbol.hasRightChild()) {
            BinaryTree<SumaYDif> hijoDerecho = new BinaryTree<>();
            nuevo.addRightChild(hijoDerecho);
            recorrer(arbol.getRightChild(), hijoDerecho, datos.getSuma(), arbol.getData());
        }
    }
}
