import org.junit.Test;
import utils.Collections.HashTable;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
    @Test
    public void isEmptyTest(){
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        assertTrue(hashTable.isEmpty());
        hashTable.add("Cuatro", 4);

        assertFalse(hashTable.isEmpty());
    }
    @Test
    public void addAndSize(){
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        hashTable.add("Cuatro", 4);
        hashTable.add("Cinco", 5);
        hashTable.add("Seis", 6);

        assertEquals(3,hashTable.size());
    }

    @Test
    public void getByKeyTest(){
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        hashTable.add("Cuatro", 4);
        ArrayList<Integer> expectedValues = new ArrayList<>();
        expectedValues.add(2);

        assertEquals(expectedValues, hashTable.getByKey("Dos"));
    }
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
