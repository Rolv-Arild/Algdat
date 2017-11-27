package util;

public class DoubleLinkedList<T> {

    private LinkNode head;
    private LinkNode tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(T t) {
        LinkNode n = new LinkNode(t, null, head);
        if (head != null) head.prev = n;
        n.next = head;
        head = n;
        size++;
    }

    public void addLast(T t) {
        LinkNode n = new LinkNode(t, tail, null);
        if (tail != null) tail.next = n;
        n.prev = tail;
        tail = n;
        size++;
    }

    private void unlink(LinkNode n) {
        if (n == head) {
            head = n.next;
            head.prev = null;
        } else if (n == tail) {
            tail = n.prev;
            tail.next = null;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
        size--;
    }

    public T removeFirst() {
        if (head == null) return null;
        T val = head.val;
        unlink(head);
        return val;
    }

    public T removeLast() {
        if (tail == null) return null;
        T val = tail.val;
        unlink(tail);
        return val;
    }

    public T getFirst() {
        return (head == null) ? null : head.val;
    }

    public T getLast() {
        return (tail == null) ? null : tail.val;
    }

    private class LinkNode {
        T val;

        LinkNode prev;
        LinkNode next;

        LinkNode(T val, LinkNode prev, LinkNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
