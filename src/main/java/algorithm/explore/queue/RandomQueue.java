package algorithm.explore.queue;

import java.util.*;

public class RandomQueue<T> implements Iterable<T> {

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
            return metaData[cursor++];
        }

        public ListIterator() {
            for (int i = 0; i < size; i++) {
                int j = i + (int) (Math.random() * (size - i));
                T temp = metaData[i];
                metaData[i] = metaData[j];
                metaData[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        List<Card> cards = Card.generator();
        RandomQueue<Card> queue = new RandomQueue<>();
        cards.forEach(queue::enqueue);
        Iterator<Card> iterator = queue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        List<Card> myself = new ArrayList<>();
        System.out.println(queue.size);
        while (queue.size > 0) {
            Card card = queue.dequeue();
            if (queue.size % 4 == 3) {
                myself.add(card);
            }
        }
        myself.stream().sorted(Comparator.comparing(Card::getMark).thenComparing(Card::getColor)).forEach(System.out::println);
    }
}
