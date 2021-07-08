/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.problem.list;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 *
 * @author shiwenxiang
 * @version 1: RemoveNthNodeFromEndofList.java, v0.1 2020/8/4 shiwenxiang Exp $$
 */
public class RemoveNthNodeFromEndOfList {

    public void show(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    ListNode getInitC() {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(8);
        ListNode c = new ListNode(9);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(7);
        ListNode f = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        return a;
    }

    public void test() {
        ListNode c = getInitC();
        show(c);
        System.out.println("------------------");
        show(removeNthFromEnd(c, 6));
    }

    public static void main(String[] args) {
        new RemoveNthNodeFromEndOfList().test();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int length = findLength(head);
        if (n == length) {
            return head.next;
        }
        int index = length - n;
        int p = 0;
        ListNode pre = new ListNode(0, head);
        ListNode point = pre;
        while (p != index) {
            point = point.next;
            p++;
        }
        point.next = point.next.next;
        return pre.next;
    }

    public int findLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }
    }


}
