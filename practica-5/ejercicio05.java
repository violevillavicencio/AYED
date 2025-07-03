public class BancoItabu {

    private class Persona {
        private String tipo; // "Empleado" o "Jubilado"
        private String nombre;
        private String domicilio;
        private boolean cobro; // true si ya cobró

        // Getters y setters
        public String getTipo() {
            return tipo;
        }
        public String getNombre() {
            return nombre;
        }
        public String getDomicilio() {
            return domicilio;
        }
        public boolean yaCobro() {
            return cobro;
        }
        public boolean esJubilado() {
            return tipo.equals("Jubilado");
        }
    }

    // Busca el vértice del empleado por nombre
    private Vertex<Persona> buscarEmpleado(Graph<Persona> grafo, String nombreEmpleado) {
        List<Vertex<Persona>> vertices = grafo.getVertices();
        Iterator<Vertex<Persona>> it = vertices.iterator();
        Vertex<Persona> persona = null;
        while (it.hasNext() && persona == null) {
            Vertex<Persona> aux = it.next();
            if (aux.getData().getNombre().equals(nombreEmpleado)) {
                persona = aux;
            }
        }
        return persona;
    }

    // Método principal: retorna lista de jubilados a entregar hasta distancia indicada
    public List<Persona> metodo(Graph<Persona> grafo, String nombreEmpleado, int distancia) {
        List<Persona> listaJubilados = new LinkedList<>();

        if (grafo != null && !grafo.isEmpty()) {
            Vertex<Persona> empleado = buscarEmpleado(grafo, nombreEmpleado);
            if (empleado != null) {
                recorrer(grafo, empleado, distancia, listaJubilados);
            }
        }
        return listaJubilados;
    }

    // BFS por niveles con null para marcar cambio de nivel
    private void recorrer(Graph<Persona> grafo, Vertex<Persona> empleado, int distancia, List<Persona> listaJubilados) {
        int nivel = 0;
        boolean[] marcas = new boolean[grafo.getSize()];
        Queue<Vertex<Persona>> cola = new Queue<>();

        marcas[empleado.getPosition()] = true;
        cola.enqueue(empleado);
        cola.enqueue(null); // separador de niveles

        while (!cola.isEmpty() && nivel <= distancia && listaJubilados.size() < 40) {
            Vertex<Persona> aux = cola.dequeue();

            if (aux != null) {
                // Solo guardo si es jubilado, no cobró y está a distancia exacta
                if (nivel == distancia) {
                    Persona p = aux.getData();
                    if (p.esJubilado() && !p.yaCobro()) {
                        listaJubilados.add(p);
                    }
                } else {
                    // Expando adyacentes solo si nivel < distancia
                    for (Edge<Persona> e : grafo.getEdges(aux)) {
                        Vertex<Persona> vecino = e.getTarget();
                        if (!marcas[vecino.getPosition()]) {
                            marcas[vecino.getPosition()] = true;
                            cola.enqueue(vecino);
                        }
                    }
                }
            } else if (!cola.isEmpty()) {
                nivel++;
                if (nivel <= distancia) {
                    cola.enqueue(null);
                }
            }
        }
    }
}
