package algorithm.explore.buffer;

/**
 * 环形缓冲区
 * <p>
 * 环形队列 定长N 先进先出
 *
 * @param <T>
 */
public class RingBuffer<T> {
    private Integer N;
    private T[] data;
    private Integer first;
    private Integer last;

    public boolean isEmpty() {
        return first.equals(last);
    }

    public boolean isFull() {
        return (last + 1) % N == first;
    }

    private Integer size() {
        return last - first < 0 ? N + last - first : last - first;
    }

    public RingBuffer(Integer N) {
        this.N = N;
        this.data = (T[]) new Object[N];
    }

    public void enqueue(T t) {
        if (isFull()) {
            throw new RuntimeException("满了不能进队");
        }
        last = (last + 1) % N;
        data[last] = t;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("空了不能出队");
        }
        T t = data[first];
        first = (first + 1) % N;
        return t;
    }
}
