/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.leetcode.problem.list;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *
 * @author shiwenxiang
 * @version 1: RotateList.java, v0.1 2020/8/5 shiwenxiang Exp $$
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int length = length(head);
        k = length - k % length;
        ListNode tail = findTail(head);
        //关键点 形成一个环。
        tail.next = head;
        ListNode pre = tail;
        ListNode cur = head;
        while (k-- > 0) {
            pre = pre.next;
            cur = cur.next;
        }
        //断开环
        pre.next = null;
        return cur;
    }

    public ListNode findTail(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    ListNode getInitA() {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        a.next = b;
        b.next = c;
        return a;
    }

    void test() {
        ListNode a = getInitA();
        rotateRight(a, 4);
    }

    public static void main(String[] args) {
        new RotateList().test();
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
