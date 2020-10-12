package algorithm.explore.linkedlist;

/**
 * 前移编码
 * <p>
 * 最近访问过的元素可能再次访问
 */
public class MoveToFront<Item> {

    private Node<Item> first;

    public void add(Item item) {
        if (first != null && first.item == item) return;
        Node<Item> cur = first;
        for (; cur != null && cur.next != null; cur = cur.next) {
            if (cur.next.item == item) {
                cur.next = cur.next.next;
                break;
            }
        }
        Node<Item> node = new Node<Item>(item, null);
        node.next = first;
        first = node;
    }

    static class Node<Item> {
        Item item;
        Node<Item> next;

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }

}
