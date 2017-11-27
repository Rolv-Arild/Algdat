package util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoubleLinkedListTest {

    DoubleLinkedList<Integer> test;

    @Before
    public void setUp() throws Exception {
        test = new DoubleLinkedList<>();
        test.addFirst(1);
        test.addLast(2);
        test.addFirst(3);
        test.addLast(4);
        test.addFirst(5);
        test.addLast(6);
        test.addFirst(7);
        test.addLast(8);
    }

    @Test
    public void addFirst() throws Exception {
        test.addFirst(10);
        assertEquals(new Integer(10), test.getFirst());
    }

    @Test
    public void addLast() throws Exception {
        test.addLast(0);
        assertEquals(new Integer(0), test.getLast());
    }

    @Test
    public void removeFirst() throws Exception {
        assertEquals(new Integer(7), test.removeFirst());
    }

    @Test
    public void removeLast() throws Exception {
        assertEquals(new Integer(8), test.removeLast());
    }

    @Test
    public void getFirst() throws Exception {
        assertEquals(new Integer(7), test.getFirst());
    }

    @Test
    public void getLast() throws Exception {
        assertEquals(new Integer(8), test.getLast());
    }

}