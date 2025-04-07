package practica2.ejercicio05;

import practica2.ejercicio01y02.BinaryTree; 
import implCola.Queue; 

public class ProfundidadDeArbolBinario {
    BinaryTree<Integer> arbol; 
    
    
    public void setArbol (BinaryTree<Integer> data) {
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
               } else if (nivel < p) {
                   // Solo encolamos hijos si estamos antes del nivel deseado
                   if (aux.hasLeftChild()) 
                       cola.enqueue(aux.getLeftChild());
                   if (aux.hasRightChild()) 
                       cola.enqueue(aux.getRightChild());
               }
           } else if (!cola.isEmpty()) {
               nivel++;
               if (nivel > p) break; // Cortamos el recorrido si ya pasamos el nivel deseado
               cola.enqueue(null);
           }
       }

       return suma; 
   }

}
