public class Parcial {

    private class InfoUsuario {
        private int usuarios = 0;
        private boolean esPopular = false;

        // Getters y setters
        public void setUsuarios(int u) { this.usuarios = u; }
        public void setPopularidad(boolean p) { this.esPopular = p; }
        public int getUsuarios() { return usuarios; }
        public boolean getPopularidad() { return esPopular; }
    }

    public InfoUsuario nivelPopularidad(Graph<String> red, String usuario, int distancia, int umbral) {
        InfoUsuario info = new InfoUsuario();
        if (red != null && !red.isEmpty()) {
            Vertex<String> usu = red.search(usuario);
            if (usu != null) {
                recorrer(red, usu, distancia, umbral, info);
                return info; // devuelvo la tupla
            }
        }
        return null;
    }

    public void recorrer(Graph<String> red, Vertex<String> usu, int distancia, int umbral, InfoUsuario info) {
        int nivel = 0;
        boolean[] marcas = new boolean[red.getSize()];
        LinkedList<String> listaAmigos = new LinkedList<>();

        Queue<Vertex<String>> cola = new Queue<>();
        marcas[usu.getPosition()] = true;
        cola.enqueue(usu);
        cola.enqueue(null);

        while (!cola.isEmpty() && nivel <= distancia) {
            Vertex<String> aux = cola.dequeue();
            if (aux != null) {
                if (nivel == distancia) {
                    listaAmigos.add(aux.getData());
                }
                else{ 
                    for (Edge<String> e : red.getEdges(aux)) {
                        Vertex<String> vecino = e.getTarget();
                        if (!marcas[vecino.getPosition()]) {
                            marcas[vecino.getPosition()] = true;
                            cola.enqueue(vecino);
                        }
                    }
                }
            } else if (!cola.isEmpty()) {
                nivel++;
                cola.enqueue(null);
            }
        }

        info.setUsuarios(listaAmigos.size());
        if (listaAmigos.size() >= umbral) {
            info.setPopularidad(true);
        }
    }
}
