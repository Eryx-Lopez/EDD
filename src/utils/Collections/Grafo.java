package utils.Collections;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo {
    public Grafo() {

    }

    private final HashMap<Vertice, ArrayList<Arista>> vertices = new HashMap<>();

    public void addVertice(String name) {
        new Vertice(name);
        vertices.put(new Vertice(name), new ArrayList<>());

    }

    public void addArista(String v1, String v2, double weight) {
        Vertice origen = buscarEnHashMap(v1);
        Vertice meta = buscarEnHashMap(v2);
        Arista arista = new Arista(origen, meta, weight);
        vertices.get(origen).add(arista);

    }

    public Vertice buscarEnHashMap(String name) {
        for (Vertice vertice : vertices.keySet()) {
            if (vertice.getName().equals(name)) {
                return vertice;
            }
        }
        addVertice(name);
        return buscarEnHashMap(name);
    }

    public ArrayList<Arista> getAdyacencias(Vertice vertice) {
        return vertices.get(vertice);
    }

    public class Vertice {
        private final String name;

        public Vertice(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    public static class Arista {
        private final Vertice v1;
        private final Vertice v2;
        private final double weight;

        public Arista(Vertice v1, Vertice v2, double weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public Vertice getV1() {
            return v1;
        }

        public Vertice getV2() {
            return v2;
        }

        public double getWeight() {
            return weight;
        }
    }

}


