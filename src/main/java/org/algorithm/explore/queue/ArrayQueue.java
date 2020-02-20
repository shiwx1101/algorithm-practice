package org.algorithm.explore.queue;

class ArrayQueue{
    private int capacity;
    private Object[] items;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity){
        this.capacity = capacity;
        items = new Object[capacity];
    }

    public boolean enqueue(Object o){
        if(tail==capacity){
            if(head==0)return false;
            for (int i = head; i < tail; i++) {
                items[i-head] = items[head];
            }

            tail-=head;
            head =0;
        }
        items[tail++] = o;
        return true;
    }

    public Object dequeue(){
        if(head==tail)return null;
        return items[head++];
    }




}