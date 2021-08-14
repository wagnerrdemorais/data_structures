package DataStructures;

public class QueueWithTwoStacks<T> {

    private final Stack<T> newOnTop = new Stack<>();
    private final Stack<T> oldOnTop = new Stack<>();

    public void enqueue(T value) {
        newOnTop.push(value);
    }

    public T peek() {
        shiftStacks();
        return oldOnTop.peek();
    }

    public T dequeue() {
        shiftStacks();
        return oldOnTop.pop();
    }

    private void shiftStacks() {
        if (oldOnTop.isEmpty()) {
            while (!newOnTop.isEmpty()) {
                oldOnTop.push(newOnTop.pop());
            }
        }
    }

}
