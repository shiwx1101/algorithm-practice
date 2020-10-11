package algorithm.explore.linkedlist;

/**
 *
 */
class ListPractice<E extends Comparable<E>> {

    public Node<E> reversal(Node<E> node) {
        Node<E> nextTmp = null;
        Node<E> head = new Node<E>();
        Node<E> cur = node;
        Node<E> next1 = null;
        while (cur != null) {
            nextTmp = cur.next;
            head.next = cur;
            cur.next = next1;
            next1 = cur;
            cur = nextTmp;
        }
        return head.next;
    }

    public boolean exisitLoop(Node<E> node) {
        if (node == null || node.next == null) return false;
        Node<E> slowPoint = node;
        Node<E> fastPoint = node.next;
        while (fastPoint.next != null && fastPoint.next.next != null) {
            if (slowPoint == fastPoint) return true;
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
        }
        return false;
    }

    public Node<E> merge(Node<E> node1, Node<E> node2) {
        Node<E> head = new Node<E>();
        Node<E> pointer = head;
        Node<E> cur1 = node1;
        Node<E> cur2 = node2;

        while (cur1 != null && cur2 != null) {
            if (cur1.e.compareTo(cur2.e) > 0) {
                pointer.next = cur2;
                cur2 = cur2.next;
            } else {
                pointer.next = cur1;
                cur1 = cur1.next;
            }
            pointer = pointer.next;
        }

        if (cur1 == null) {
            pointer.next = cur2;
        }
        if (cur2 == null) {
            pointer.next = cur1;
        }
        return head.next;
    }

    public Node<E> getCenter(Node<E> node) {
        if (node == null) return null;
        if (node.next == null) return node;
        Node<E> fast = node.next;
        Node<E> slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 删除倒数第N个节点
     *
     * @param node
     * @return
     */
    public Node<E> removeBacwardN(Node<E> node, int k) {

        Node<E> fast = node;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            i++;
        }

        if (fast == null) {
            return node;
        }
        Node<E> slow = node;
        Node<E> pre = null;
        while (fast.next != null) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if (pre == null) {
            node = node.next;
        } else {
            pre.next = pre.next.next;
        }
        return node;
    }


}