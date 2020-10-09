package algorithm.explore.queue;

import java.util.Random;

public class RandomQueue<T> {

    private int size;

    private T[] metaData;

    public boolean isEmpty() {
        return size == 0;
    }

    void enqueue(T t) {
        if (size == metaData.length) {
            resize(2 * metaData.length);
        }
        metaData[size++] = t;
    }

    T dequeue() {
        int change = (int) (Math.random() * (size - 1));
        T temp = metaData[size - 1];
        metaData[size - 1] = metaData[change];
        metaData[change] = temp;
        T result = metaData[size - 1];
        metaData[size - 1] = null;
        size--;
        if (size > 0 && size == metaData.length / 4) {
            resize(metaData.length / 2);
        }
        return result;
    }

    T sample() {
        int change = (int) (Math.random() * (size - 1));
        return metaData[change];
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = metaData[i];
        }
        metaData = temp;
    }

    public RandomQueue() {
        metaData = (T[]) new Object[1];
    }
}
