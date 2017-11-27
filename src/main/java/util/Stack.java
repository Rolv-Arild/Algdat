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

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        while (!stack.isEmpty()) {
            System.out.println(stack.poll());
        }
    }

    private boolean isEmpty() {
        return list.isEmpty();
    }
}
