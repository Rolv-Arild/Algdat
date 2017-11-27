package util;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class BinaryHeapTest {

    private Integer[] testNumbers = new Integer[]{1, 9, 2, 8, 3, 7, 4, 6, 0};
    private Integer[] sorted;


    private BinaryHeap<Integer> heap1;
    private BinaryHeap<Integer> heap2;

    @Before
    public void setUp() throws Exception {
        sorted = Arrays.copyOf(testNumbers, testNumbers.length);
        Arrays.sort(sorted);
        heap1 = new BinaryHeap<>();
        for (Integer testNumber : testNumbers) {
            heap1.add(testNumber);
        }
        heap2 = new BinaryHeap<>(Arrays.asList(testNumbers));
    }

    @Test
    public void peek() throws Exception {
        assertTrue(heap1.peek() == 0);
        assertTrue(heap2.peek() == 0);
    }

    @Test
    public void poll() throws Exception {
        for (Integer integer : sorted) {
            assertTrue(integer.intValue() == heap1.poll());
            assertTrue(integer.intValue() == heap2.poll());
        }
    }

    @Test
    public void add() throws Exception {
        heap1.add(5);
        heap2.add(5);
        sorted = Arrays.copyOf(sorted, sorted.length+1);
        sorted[sorted.length-1] = 5;
        Arrays.sort(sorted);

        for (Integer integer : sorted) {
            assertTrue(integer.intValue() == heap1.poll());
            assertTrue(integer.intValue() == heap2.poll());
        }    }
}