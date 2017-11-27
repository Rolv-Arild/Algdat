package util;

import static java.lang.Math.abs;

public class Hashmap<K, V> {

    private HashNode<K, V>[] values;
    private int size;

    public Hashmap(int capacity) {
        this.size = 0;
        int cap = Integer.highestOneBit(capacity) << 1;
        //noinspection unchecked
        this.values = (HashNode<K, V>[]) new HashNode[cap];
    }

    public boolean add(K key, V val) {
        int hash = abs(key.hashCode());
        int m = values.length;
        for (int i = 0; i < m; i++) {
            int j = probe(hash, i);
            if (values[j] == null) {
                values[j] = new HashNode<>(key, val);
                return true;
            }
        }
        return false; // no more room
    }

    public V get(K key) {
        int hash = abs(key.hashCode());
        int m = values.length;
        for (int i = 0; i < m; i++) {
            int j = probe(hash, i);
            if (values[j] == null) return null;
            if (values[j].key.equals(key)) return values[j].val;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int probe(int hash, int i) {
        return (hash + i) % values.length;
    }

    private static class HashNode<K, V> {
        K key;
        V val;

        HashNode(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Hashmap<String, String> map = new Hashmap<>(10);
        map.add("Sigrid", "digriS");
        map.add("Julie", "eiluJ");
        map.add("Kygo", "ogyK");
        map.add("Hallo","ollaH");
        map.add("Sigri", "igriS");
        map.add("Juli", "iluJ");
        map.add("Kyg", "gyK");
        map.add("Hall","llaH");

        System.out.println(map.get("Sigrid"));
        System.out.println(map.get("Julie"));
        System.out.println(map.get("Kygo"));
        System.out.println(map.get("Hallo"));
        System.out.println(map.get("Sigri"));
        System.out.println(map.get("Juli"));
        System.out.println(map.get("Kyg"));
        System.out.println(map.get("Hall"));
    }
}
