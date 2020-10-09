package algorithm.explore.bag;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Bag<T> implements Iterable<T> {

    private Integer size;

    private Node<T> first;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void add(T t) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.value = t;
        first.next = oldFirst;
    }

    public Bag() {
    }

    private class ListIterator implements Iterator<T> {

        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T t = current.value;
            current = current.next;
            return t;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (Node x = first; x != null; x = x.next) {
            action.accept((T) x.value);
        }
    }


    private class Node<T> {

        T value;
        Node next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node() {
        }
    }
}
