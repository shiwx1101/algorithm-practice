package algorithm.explore.queue;

import algorithm.explore.linkedlist.Node;

class ListQueue<E extends Comparable<E>>{
    private int capacity;
    private Node<E> head;
    private Node<E> tail;
    private int lenght = 0;

    public ListQueue(int capacity){
        this.capacity = capacity;
        this.head = new Node<>();
        this.tail = head;
    }

    public boolean enqueue(E e){
        if(lenght==capacity)return false;
        Node<E> tmp = new Node<E>(e, null);
        tail.next = tmp;
        tail = tmp;
        ++lenght;
        return false;
    }

    public Node<E> dequeue(){
        if(lenght==0){
            return null;
        }
        Node<E> tmp = head.next;
        head = tmp;
        return tmp;
    }

}