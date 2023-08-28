package Modulo1.futbol.utils;

import java.util.Optional;

public class Node <E>{
    public E data;
    public Optional<Node<E>> next;

    public Node(E data) {
        this.data = data; //Almacenar un dato tipo genérico
        next = Optional.empty(); //Almacena un nodo Optional, significando que puede estar vacío
    }
}