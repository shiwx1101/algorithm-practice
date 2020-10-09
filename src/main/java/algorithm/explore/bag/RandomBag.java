package algorithm.explore.bag;

import org.omg.CORBA.Object;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 随机背包
 */
public class RandomBag<T> implements Iterable<T> {

    private Integer size;

    private Integer capacity;

    private T[] metaDate;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(T t) {
        if (size.equals(capacity)) {
            resize();
        }
        metaDate[size++] = t;
    }

    public RandomBag(Integer capacity) {
        this.capacity = capacity;
        metaDate = (T[]) new Object[capacity];
    }

    private void resize() {
        capacity = capacity * 2;
        T[] newMetaData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newMetaData[i] = metaDate[i];
        }
        metaDate = newMetaData;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            return metaDate[cursor++];
        }

        public ListIterator() {
            for (int i = 0; i < size; i++) {
                int j = i + (int) (Math.random() * (size - i));
                T temp = metaDate[i];
                metaDate[i] = metaDate[j];
                metaDate[j] = temp;
            }
        }
    }
}
