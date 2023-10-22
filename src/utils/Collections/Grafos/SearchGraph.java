package utils.Collections.Grafos;

import java.util.*;

public class SearchGraph {
    public static Grafo.Vertice breadthFirstSearch(Grafo grafo, String inicio, String objetivo) {

        Queue<Grafo.Vertice> vQueue = new LinkedList<>();
        Set<Grafo.Vertice> visitados = new HashSet<>();

        Grafo.Vertice vInicio = grafo.buscarEnHashMap(inicio);

        //visito vertice
        vQueue.add(vInicio);
        visitados.add(vInicio);

        while(!vQueue.isEmpty()) {
            Grafo.Vertice vIndex = vQueue.poll();

            // proceso (busco el número)
            if (vIndex.getName().equals(objetivo)) {
                return vIndex;
            }
            List<Grafo.Arista> aristas = grafo.getAdyacencias(vIndex);

            for (Grafo.Arista arista : aristas) {
                // agrego sus adyacencias
                Grafo.Vertice vAdyacentes = arista.getV2();

                // reviso si está visitado
                // si no está visitado, lo agrego a la de visitados
                if (!visitados.contains(vAdyacentes)) {
                    visitados.add(vAdyacentes);
                    vQueue.add(vAdyacentes);
                }
            }
        }
    return null;
    }

    public static Grafo.Vertice deepFirstSearch(Grafo grafo, String inicio, String objetivo) {
        Stack<Grafo.Vertice> vStack = new Stack<>();
        Set<Grafo.Vertice> visitados = new HashSet<>();

        Grafo.Vertice vInicio = grafo.buscarEnHashMap(inicio);

        //visito vertice
        vStack.add(vInicio);
        visitados.add(vInicio);

        while(!vStack.isEmpty()){
            Grafo.Vertice vIndex = vStack.pop();

            // proceso (busco el número)
            if(vIndex.getName().equals(objetivo)){
                return vIndex;
            }
            List<Grafo.Arista> aristas = grafo.getAdyacencias(vIndex);

            for(Grafo.Arista arista : aristas){
                // agrego sus adyacencias
                Grafo.Vertice vAdyacentes = arista.getV2();

                // reviso si está visitado
                // si no está visitado, lo agrego a la de visitados
                if (!visitados.contains(vAdyacentes)){
                    visitados.add(vAdyacentes);
                    vStack.add(vAdyacentes);
                }
            }
        }
        return null;
    }
}
