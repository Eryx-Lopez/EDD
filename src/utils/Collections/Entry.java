package utils.Collections;

public class Entry <Key, Value>{
private Key key;
private Value value;
protected Entry<Key,Value> next;

    public Entry(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }
//Ya que solo se tiene que modificar el valor y no la llave
    public void setValue(Value value) {
        this.value = value;
    }
}


