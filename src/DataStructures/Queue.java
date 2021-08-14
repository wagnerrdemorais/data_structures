package DataStructures;

public class Queue<T> {

    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public T peek() {
        return head.data;
    }

    public void add(T data) {
        Node node = new Node(data);

        if (tail != null) {
            tail.next = new Node(data);
        }

        tail = node;

        if (head == null) {
            head = node;
        }
    }

    public T remove() {
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

}
