/*
 Ejercicio 4
Se quiere realizar un paseo en bicicleta por lugares emblemáticos de Oslo. Para esto se cuenta con un grafo de
bicisendas. Partiendo desde el “Ayuntamiento” hasta un lugar destino en menos de X minutos, sin pasar por un
conjunto de lugares que están restringidos.*/

public class VisitaOslo {

	public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
		if ((lugares != null) && (!lugares.isEmpty())){
			Vertex<String> origen = lugares.search("Ayuntamiento"); 
			if (origen!=null) {
				Vertex<String> vDestino = lugares.search(destino);
				if (vDestino != null) {
					List<String> camino = new LinkedList<String>();
					boolean [] marcas = new boolean [lugares.getSize()];
					marcarRestringidos(lugares,lugaresRestringidos,marcas);
					boolean encontre = dfs(lugares, origen, vDestino, camino, new LinkedList<>() ,marcas ,maxTiempo);
					if (encontre) 
						return camino;
				}
			}
		}
    return null;
	}
	
	private void marcarRestringidos(Graph<String> lugares, List<String> lugaresRestringidos, boolean[] marcas) {
        for(String nom: lugaresRestringidos) {
            Vertex<String> v = lugares.search(nom);
            if(v!=null) {
                marcas[v.getPosition()] = true;
            }
        }
    }
	
	private boolean dfs(Graph<String> lugares, Vertex<String>origen, Vertex<String> destino, List<String> camino ,List<String> caminoActual , boolean [] marcas,int maxTiempo) {
		boolean encontre = false;
		marcas[origen.getPosition()] =true; //marco como visitado
		caminoActual.add(origen.getData());
		if (origen == destino) {
				camino.clear();
				camino.addAll(caminoActual);
				encontre = true;
		}
    else {
			      List<Edge<String>> ady = lugares.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && !encontre) {
                Edge<String> v = it.next();
                int j = v.getTarget().getPosition();
                if(!marcas[j] && maxTiempo - v.getWeight() >= 0) {
                    encontre = dfs(lugares, v.getTarget(), destino, camino,caminoActual, marcas, maxTiempo - v.getWeight());
                }
            }
    }
		caminoActual.remove(caminoActual.size()-1);
		marcas[origen.getPosition()] =false;
		return encontre;
	}
