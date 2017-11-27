package util;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertTrue;

public class SorterTest {
    private final int[] test1 = new int[]{1,2,3,4,5,6,7,8,9};
    private int[] test2;
    private int[] test3;

    @Before
    public void setUp() throws Exception {
        test2 = new int[]{9,1,8,2,7,3,6,4,5,0}; // 1,2,3,6,4,5,0,7,8,9
        test3 = new int[10000];
        Random r = new Random();
        for (int i = 0; i < test3.length; i++) {
            test3[i] = r.nextInt();
        }
    }

    @Test
    public void isSorted() throws Exception {
        assertTrue(Sorter.isSorted(test1));
    }

    @Test
    public void insertionSort() throws Exception {
        Sorter.insertionSort(test2);
        assertTrue(Sorter.isSorted(test2));
        Sorter.insertionSort(test3);
        assertTrue(Sorter.isSorted(test3));
    }

    @Test
    public void selectionSort() throws Exception {
        Sorter.selectionSort(test2);
        assertTrue(Sorter.isSorted(test2));
        Sorter.selectionSort(test3);
        assertTrue(Sorter.isSorted(test3));
    }

    @Test
    public void bubbleSort() throws Exception {
        Sorter.bubbleSort(test2);
        assertTrue(Sorter.isSorted(test2));
        Sorter.bubbleSort(test3);
        assertTrue(Sorter.isSorted(test3));
    }

    @Test
    public void quickSort() throws Exception {
        Sorter.quickSort(test2);
        assertTrue(Sorter.isSorted(test2));
        Sorter.quickSort(test3);
        assertTrue(Sorter.isSorted(test3));
    }

}