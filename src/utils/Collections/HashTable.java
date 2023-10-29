package utils.Collections;

import java.util.ArrayList;

/**
 * Clase HashTable
 * @param <Key> llave
 * @param <Value> valor que contiene la llave
 */
public class HashTable<Key, Value> {
    private ArrayList<Entry<Key, Value>> table[];
    private int size = 0;

    /**
     * Constructor de la clase
     * @param capacity capacidad o tope de la HashTable
     */

    public HashTable(int capacity) {
        table = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new ArrayList<>();
        }
    }

    /**
     * Método encargado de sacar el tamaño
     * @return el tamaño
     */
    public int size(){
        return size;
    }

    /**
     * Método para determinar si la HashTable está vacía o no
     * @return falso si está llena o true si está vacía
     */
    public boolean isEmpty(){
    if (this.size() == 0){
        return true;
    }
    else{ return false; }
    }

    /**
     * Método para añadir valores al HashTable
     * @param key llave asignada
     * @param value valor que se le asigna a la llave
     * @return regresa la HT
     */
    public HashTable<Key,Value> add(Key key, Value value){
    int index = Math.abs(key.hashCode()) % table.length;
    for (Entry<Key, Value> i : table[index]){
        if(i.getKey().equals(key)){
            i.setValue(value);
            return this;
        }
    }
    table[index].add(new Entry<>(key, value));
    size++;
    return this;
    }

    /**
     * Método para obtener un valor buscando por la llave
     * @param key
     * @return
     */
    public ArrayList<Value> getByKey(Key key){
    int index = Math.abs(key.hashCode()) % table.length;
    ArrayList<Value> values = new ArrayList<>();
        for (Entry<Key, Value> i : table[index]){
            if(i.getKey().equals(key)){
               values.add(i.getValue());
            }
        }
        return values;
    }

    /**
     * Método para obtener los valores deseados
     * @return la lista de valores
     */
    public ArrayList<Value> getValues() {
        ArrayList<Value> values = new ArrayList<>();
        for (ArrayList<Entry<Key, Value>> i : table) {
            for (Entry<Key, Value> j : i){
                values.add(j.getValue());
            }
        }
        return values;
    }
}
