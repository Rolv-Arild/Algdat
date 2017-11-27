package util;

import java.util.ArrayList;
import java.util.Collection;

public class BinaryHeap<T extends Comparable<T>> {

    ArrayList<T> heap;
    int size;

    public BinaryHeap() {
        this.size = 0;
        this.heap = new ArrayList<>();
    }
    
    public BinaryHeap(Collection<T> collection) {
        heap = new ArrayList<>(collection);
        size = collection.size();
        int i = size/2;
        while (i-- > 0) siftDown(i);
    }
    
    private T get(int i) {
        return heap.get(i);
    }

    private void set(int i, T val) {
        heap.set(i, val);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i + 1) * 2;
    }

    public T peek() {
        return get(0);
    }

    public T poll() {
        T min = get(0);
        set(0, get(--size));
        siftDown(0);
        return min;
    }

    public void add(T t) {
        int i = size++;
        heap.add(t);
        siftUp(i);
    }

    private void siftUp(int i) {
        int p = parent(i);
        while (i > 0 && get(i).compareTo(get(p)) < 0) {
            swap(i, p);
            i = p;
            p = parent(i);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDown(int i) {
        int m = leftChild(i);
        if (m < size) {
            int h = m + 1; // right child
            if (h < size && get(h).compareTo(get(m)) < 0) m = h;
            // m is now the index of the smallest child
            if (get(m).compareTo(get(i)) < 0) {
                swap(i, m); // move the node down
                siftDown(m); // move it further down if possible
            }
        }
    }

    private void swap(int i, int m) {
        T temp = get(i);
        set(i, get(m));
        set(m, temp);
    }


    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(1);
        heap.add(9);
        heap.add(2);
        heap.add(8);
        heap.add(3);
        heap.add(7);
        heap.add(4);
        heap.add(6);
        heap.add(0);
        heap.add(5);
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
