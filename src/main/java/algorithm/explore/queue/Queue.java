package algorithm.explore.queue;

import algorithm.explore.linkedlist.Node;

public class Queue<E extends Comparable<E>> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(E e) {
        Node<E> oldLast = last;
        last = new Node<E>(e, null);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public E dequeue() {
        if (size == 0) {
            return null;
        }
        E e = first.e;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        size--;
        return e;
    }

}