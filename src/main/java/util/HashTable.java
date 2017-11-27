package util;

import static java.lang.Math.abs;

public class HashTable<K, V> {

    private HashNode<K, V>[] values;
    private int size;
    private int collisions;

    public HashTable(int capacity) {
        this.size = 0;
        this.collisions = 0;
        int cap = Integer.highestOneBit(capacity) << 1;
        //noinspection unchecked
        this.values = (HashNode<K, V>[]) new HashNode[cap];
    }

    public boolean add(K key, V val) {
        int hash = abs(key.hashCode());
        int h1 = h1(hash);
        int h2 = h2(hash);
        int m = values.length;
        for (int i = 0; i < m; i++) {
            int j = probe(h1, h2, i);
            if (values[j] == null) {
                values[j] = new HashNode<>(key, val);
                size++;
                return true;
            }
            collisions++;
        }
        return false; // no more room
    }

    public V get(K key) {
        int hash = abs(key.hashCode());
        int h1 = h1(hash);
        int h2 = h2(hash);
        int m = values.length;
        for (int i = 0; i < m; i++) {
            int j = probe(h1, h2, i);
            if (values[j] == null) return null;
            if (values[j].key.equals(key)) return values[j].val;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int collisions() {
        return collisions;
    }

    private int h1(int hash) {
        return abs(hash) % 17;
    }

    private int h2(int hash) {
        return (2*abs(hash)+1) % values.length;
    }

    private int probe(int h1, int h2, int i) {
        return (h1 + i*h2) % values.length;
    }

    private static class HashNode<K, V> {
        K key;
        V val;

        HashNode(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}
