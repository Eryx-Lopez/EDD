package utils.Collections;

import java.util.ArrayList;

public class HashTable<Key, Value> {
    private int capacity;
    private ArrayList<Entry<Key, Value>> table[];
    int size = 0;

    public HashTable(int capacity) {
        table = new ArrayList[capacity];
    }

    /**
     * Mientras no este vacio, recorre la lista hasta llegar al tope,
     * almacenando la cantidad en la variable size que aumenta con cada iteracion
     * @return el tamano final
     */
    public int size(){
        return size;
    }

    public boolean isEmpty(){
    if (this.size() == 0){
        return true;
    }
    else{ return false; }
    }

    public HashTable add(Key key, Value value){
    int index = Math.abs(key.hashCode()) % table.length;
    for (Entry<Key, Value> i : table[index]){
        if(i.getKey().equals(key)){
            i.setValue(value);
            return this;
        }
    }
    table[index].add(new Entry<>(key, value));
    return this;
    }

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
