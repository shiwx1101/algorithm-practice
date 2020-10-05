package algorithm.explore.queue;

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
        if((tail+1)%capacity==head)return false;
        items[tail] = o;
        tail = (tail+1)%capacity;
        return true;
    }

    public Object dequeue(){
        if(head==tail)return null;
        Object o = items[head];
        head = (head+1)%capacity;
        return o;
    }




}