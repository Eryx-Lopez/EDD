import org.junit.Test;
import utils.Collections.HashTable;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase encargada de contener los test para los métodos creados en la HashTable
 */
public class HashTableTest {
    /**
     * Test para comprobar si la HT está vacía
     */
    @Test
    public void isEmptyTest(){
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        assertTrue(hashTable.isEmpty());
        hashTable.add("Cuatro", 4);

        assertFalse(hashTable.isEmpty());
    }
    /**
     * Test para comprobar si se agregan elementos a la HT, para luego comprobar el tamaño de ésta
     */
    @Test
    public void addAndSize(){
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        hashTable.add("Cuatro", 4);
        hashTable.add("Cinco", 5);
        hashTable.add("Seis", 6);

        assertEquals(3,hashTable.size());
    }

    /**
     * Test para comprobar si se pueden obtener los valores mandando únicamente la llave
     */
    @Test
    public void getByKeyTest(){
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        hashTable.add("Cuatro", 4);
        ArrayList<Integer> expectedValues = new ArrayList<>();
        expectedValues.add(4);

        assertEquals(expectedValues, hashTable.getByKey("Cuatro"));
    }

    /**
     * Test para comprobar si se obtienen los valores
     */
    @Test
    public void getValuesTest(){
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        hashTable.add("Cuatro", 4);
        hashTable.add("Cinco", 5);
        hashTable.add("Seis", 6);
        ArrayList<Integer> expectedValues = new ArrayList<>();
        expectedValues.add(4);
        expectedValues.add(5);
        expectedValues.add(6);

        assertTrue(hashTable.getValues().containsAll(expectedValues) &&expectedValues.containsAll(hashTable.getValues()));

    }
}
