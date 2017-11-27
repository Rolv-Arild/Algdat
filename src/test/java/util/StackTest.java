package util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    Stack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
    }

    @Test
    public void push() throws Exception {
        stack.push(10);
        assertEquals(new Integer(10), stack.peek());
    }

    @Test
    public void peek() throws Exception {
        assertEquals(new Integer(9), stack.peek());
    }

    @Test
    public void poll() throws Exception {
        assertEquals(new Integer(9), stack.poll());
    }

}