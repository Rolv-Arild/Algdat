package util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HashTableTest {

    HashTable<String, Integer> test;

    @Before
    public void setUp() throws Exception {
        test = new HashTable<>(10);
        test.add("En", 1);
        test.add("To", 2);
        test.add("Tre", 3);
        test.add("Fire", 4);
        test.add("Fem", 5);
        test.add("Seks", 6);
        test.add("Sju", 7);
        test.add("Åtte", 8);
        test.add("Ni", 9);
    }

    @Test
    public void add() throws Exception {
        test.add("Ti", 10);
        assertEquals(new Integer(10), test.get("Ti"));
    }

    @Test
    public void get() throws Exception {
        assertEquals(new Integer(1), test.get("En"));
        assertEquals(new Integer(9), test.get("Ni"));
        assertEquals(new Integer(2), test.get("To"));
        assertEquals(new Integer(8), test.get("Åtte"));
        assertEquals(new Integer(3), test.get("Tre"));
        assertEquals(new Integer(7), test.get("Sju"));
        assertEquals(new Integer(4), test.get("Fire"));
        assertEquals(new Integer(6), test.get("Seks"));
        assertEquals(new Integer(5), test.get("Fem"));

    }

    @Test
    public void size() throws Exception {
        assertEquals(9, test.size());
    }

    @Test
    public void collisions() throws Exception {
        assertTrue(test.collisions() < test.size());
    }
}