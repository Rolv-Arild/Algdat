package util;

public class SingleLinkedList<T> {

    private LinkNode head;
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void add(T t) {
        LinkNode n = new LinkNode(t, head);
        n.next = head;
        head = n;
        size++;
    }

    public T remove() {
        if (head == null) return null;
        T val = head.val;
        head = head.next;
        size--;
        return val;
    }

    public T get() {
        return (head == null) ? null : head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private class LinkNode {
        T val;
        LinkNode next;

        LinkNode(T val, LinkNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
}
