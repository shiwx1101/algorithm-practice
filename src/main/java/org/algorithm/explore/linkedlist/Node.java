package org.algorithm.explore.linkedlist;
/**
 * 
 * @param <E>
 */
class Node<E extends Comparable<E>>{
    E e;
    Node<E> next;
    public Node(){

    }
    public Node(final E e, final Node<E> next) {
        this.e = e;
        this.next = next;
    }
}