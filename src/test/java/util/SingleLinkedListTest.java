package util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SingleLinkedListTest {

    SingleLinkedList<Integer> test;

    @Before
    public void setUp() throws Exception {
        test = new SingleLinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        test.add(8);
        test.add(9);
    }

    @Test
    public void size() throws Exception {
        assertEquals(9, test.size());
    }

    @Test
    public void add() throws Exception {
        test.add(10);
        assertEquals(10, test.size());
        assertEquals(new Integer(10), test.get());
    }

    @Test
    public void remove() throws Exception {
        assertEquals(new Integer(9), test.remove());
        assertEquals(8, test.size());
        assertEquals(new Integer(8), test.get());
    }

    @Test
    public void get() throws Exception {
        assertEquals(new Integer(9), test.get());
    }

    @Test
    public void isEmpty() throws Exception {
        assertFalse(test.isEmpty());
    }

}