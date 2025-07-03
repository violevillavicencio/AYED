/* Parque temaiken se quiere saber la maxima cantidad de recintos que se puede visitar en un tiempo determinado 
que disponen partiendo desde "Entrada". */ 

public class Parcial {

	public int resolver(Graph<Recinto> sitios, int tiempo){
		//busco la entrada, usando un iterador en la lista de vertices
		List<Vertex<Recinto>> vertices = sitios.getVertices(); 
		Iterator<Vertex<Recinto>> it = vertices.iterator(); 
		Vertex<Recinto> aux, entrada = null; 

		//mientras tenga mas vertices que recorrer y no haya encontrado entrada
		while(it.hasNext && entrada== null){
			aux = it.next; 
			if (aux.getData().getNombre().equals("entrada")){
				entrada = aux; 
			}
		}

		int resultado = 0; 
		if (entrada != null){
			boolean [] marcas = new boolean [vertices.getSize()]; 
			resultado = resolver(sitios, entrada, tiempo, marcas); 
		}

		return resultado; 
	}

	private int resolver(Graph<Recinto> sitios, Vertex<Recinto> entrada, int tiempo, boolean [] marcas){
		int ret; // retorno 
		marcas[entrada.getPosition()] = true; 

		// tengo que contemplar el tiempo dentro del nodo 
		// si no dispongo de tiempo no puedo recorrerlo 
		if (tiempo < entrada.getData().getTiempo()){ 
			ret = 0; 
		}
		else{
			// dispongo de timpo, visito sitio actual y consumo tiempo 
			tiempo = tiempo - entrada.getData().getTiempo(); 
			List<Edge<Recinto>> vecinos = sitios.getEdges(entrada); 
			int lugares = 0 , maxLugares = 0; 
			for(Edge<Recinto> ady : vecinos){
				Vertex<Recinto> vecino = ady.getTarget(); 
				int tiempoCaminoVecino = ady.getWeight(); 
				int tiempoVecino = vecino.getData().getTiempo(); 

				//tomo solo los caminos que me alcanza el tiempo y que no fueron visitados 
				if((tiempoCaminoVecino + tiempoVecino <= tiempo) && (!marcarRestringidos[vecino.getPosition()])){
					//achicamos el problema en la sig llamada
					lugares = resolver(sitios, vecino, tiempo - tiempoCaminoVecino, marcas); 
					if(lugares > maxLugares){
						maxLugares = lugares; 
					}
				}
			}
			ret = maxLugares + 1; 
		}
		// desmarco el vertice actual 
		marcas[entrada.getPosition()] = false; 
		return ret; 
	}
}
