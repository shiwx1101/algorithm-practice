package algorithm.explore.linkedlist;
/**
 * 
 * @param <E>
 */
public class Node<E extends Comparable<E>>{
    public E e;
    public Node<E> next;
    public Node(){

    }
    public Node(final E e, final Node<E> next) {
        this.e = e;
        this.next = next;
    }
}