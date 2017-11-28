package util;

public class Stack<T> {

    private SingleLinkedList<T> list;

    public Stack() {
        this.list = new SingleLinkedList<>();
    }

    public void push(T t) {
        list.add(t);
    }

    public T peek() {
        return list.get();
    }

    public T poll() {
        return list.remove();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
