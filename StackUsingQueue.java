import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue<E> {

    private Queue<E> queue = new LinkedList<>();
    private int capacity;

    public StackUsingQueue(int capacity) {
        this.capacity = capacity;
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void push(E e) {
        if (queue.size() == capacity) {
            throw new IllegalStateException("Stack full");
        }

        queue.offer(e);

        // Rotate so new element comes to front
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public E pop() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    public E top() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.peek();
    }
}
