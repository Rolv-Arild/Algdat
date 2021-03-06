package util;

public class Sorter {

    /* Swaps two items in an array */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSort(int[] arr) {
        insertionSort(arr, 0, arr.length-1);
    }

    private static void insertionSort(int[] arr, int start, int end) {
        for (int i = start+1; i <= end; i++) {
            while (i > start && arr[i] < arr[i-1]) {
                swap(arr, i, --i);
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = minIndex(arr, i, arr.length);
            swap(arr, i, index);
        }
    }

    private static int minIndex(int[] arr, int start, int end) {
        int min = Integer.MAX_VALUE;
        int minI = -1;
        for (int i = start; i < end; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minI = i;
            }
        }
        return minI;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean changed = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    changed = true;
                }
            }
            if (!changed) return; // sorted
        }
    }

    public static void quickSort(int[] arr) {
        quickSortImpl(arr, 0, arr.length-1);
    }

    private static void quickSortImpl(int[] arr, int start, int end) {
        if (end-start < 20) {
            insertionSort(arr, start, end);
        } else {
            int pivot = partition(arr, start, end);
            quickSortImpl(arr, start, pivot);
            quickSortImpl(arr, pivot + 1, end);
        }
    }

    /* Hoare partitioning scheme */
    private static int partition(int[] arr, int start, int end) {
        int pivot = findPivot(arr, start, end);
        int i = start;
        int j = end;
        while (true) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i >= j) return j;
            swap(arr, i, j);
        }
    }

    private static int findPivot(int[] arr, int start, int end) {
        int a = arr[start];
        int b = arr[end];
        return (a & b) + ((a ^ b) >> 1); // positive and negative overflow conscious
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) return false;
        }
        return true;
    }
}
