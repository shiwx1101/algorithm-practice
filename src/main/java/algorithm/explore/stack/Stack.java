package algorithm.explore.stack;

public class Stack<Item> {

    private Integer size;

    private Node<Item> first;

    public boolean isEmpty() {
        return first == null;
    }

    public Integer size(){
        return size;
    }

    public void push(Item item) {
        if (item == null) return;
        Node<Item> oldFirst = first;
        first = new Node<>(item, null);
        first.next = oldFirst;
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            return null;
        }
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }


    class Node<Item> {
        Item item;
        Node<Item> next;

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }
}
