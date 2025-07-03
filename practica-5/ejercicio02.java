/* Ejercicio 2
a. Implemente en JAVA una clase llamada Recorridos ubicada dentro del paquete ejercicio2 cumpliendo
la siguiente especificación:
dfs(Graph<T> grafo): List<T>
// Retorna una lista con los datos de los vértices, con el recorrido en profundidad del grafo recibido como parámetro.
bfs(Graph<T> grafo): List<T>
// Retorna una lista con los datos de vértices, con el recorrido en amplitud del grafo recibido como parámetro.
b. Estimar el orden de ejecución de los métodos anteriores. */

package Practica5.Ejercicio2;

import Practica1.Ejercicio8.Queue;
import Practica5.Ejercicio1.AdjListGraph;
import Practica5.Ejercicio1.Edge;
import Practica5.Ejercicio1.Graph;
import Practica5.Ejercicio1.Vertex;
import java.util.*;

public class Recorridos<T> {
    public Recorridos() {
    }
    
    //O(V+E) V: numero de vertices y E: numero de aristas
    public List<T> dfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> lis = new LinkedList<T>(); 
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                dfs(i, grafo, lis, marca);
            }
        }
        return lis;
    }
    private void dfs(int i, Graph<T> grafo, List<T> lis, boolean[] marca) {
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        lis.add(v.getData());
        List<Edge<T>> adyacentes = grafo.getEdges(v); 
        for (Edge<T> e: adyacentes){
            int j = e.getTarget().getPosition();
            if (!marca[j]) {
                dfs(j, grafo, lis, marca);
            }
        }
    }
    
    //O(V+E) V: numero de vertices y E: numero de aristas
    public List<T> bfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> lis = new LinkedList<T>(); 
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                bfs(i, grafo, lis, marca);
            }
        }
        return lis;
    }
    
    private void bfs(int i, Graph<T> grafo, List<T> lis, boolean[] marca) {
        Queue<Vertex<T>> q = new Queue<Vertex<T>>();
        q.enqueue(grafo.getVertex(i));
        marca[i] = true;
        while (!q.isEmpty()) {
            Vertex<T> w = q.dequeue();
            lis.add(w.getData());
            List<Edge<T>> adyacentes = grafo.getEdges(w);
            for (Edge<T> e: adyacentes) {
                int j = e.getTarget().getPosition();
                if (!marca[j]) {
                    marca[j] = true;
                    q.enqueue(e.getTarget());
                }
            }
        }
    }
  
}
