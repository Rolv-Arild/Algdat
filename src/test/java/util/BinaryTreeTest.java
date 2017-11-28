package util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

    private BinaryTree<Integer> tree1;
    private BinaryTree<Integer> tree2;

    @Before
    public void setUp() throws Exception {
        tree1 = new BinaryTree<>();
        tree1.add(1);
        tree1.add(9);
        tree1.add(2);
        tree1.add(8);
        tree1.add(3);
        tree1.add(7);
        tree1.add(4);
        tree1.add(6);
        tree1.add(5);
        tree1.add(0);

        tree2 = new BinaryTree<>();
        tree2.add(5);
        tree2.add(2);
        tree2.add(7);
        tree2.add(1);
        tree2.add(3);
        tree2.add(6);
        tree2.add(8);

    }

    @Test
    public void size() throws Exception {
        assertEquals(10, tree1.size());
        assertEquals(7, tree2.size());
    }

    @Test
    public void height() throws Exception {
        assertEquals(9, tree1.height());
        assertEquals(3, tree2.height());
    }

    @Test
    public void isFull() throws Exception {
        assertFalse(tree1.isFull());
        assertTrue(tree2.isFull());
    }

    @Test
    public void add() throws Exception {
        tree2.add(0);
        assertFalse(tree2.isFull());
        assertTrue(tree2.height() > 2);
        assertEquals(8,tree2.size());
    }

    @Test
    public void remove() throws Exception {
        assertTrue(tree2.remove(3));
        assertEquals(6, tree2.size());
        assertFalse(tree2.remove(7));
    }

    @Test
    public void contains() throws Exception {
        for (int i = 1; i <= 9; i++) {
            assertTrue(String.valueOf(i), tree1.contains(i));
            if (i != 4 && i != 9) assertTrue(String.valueOf(i), tree2.contains(i));
        }
    }
}