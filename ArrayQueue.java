public class ArrayQueue<E> {

    private E[] data;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) {
        if (size == data.length) {
            throw new IllegalStateException("Queue full");
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        E value = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        return value;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[head];
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("first=" + queue.first());
        System.out.println("dequeue=" + queue.dequeue());
        System.out.println("size=" + queue.size());
    }
}
