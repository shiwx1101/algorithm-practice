/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.leetcode.problem.list;

/**
 * 单链表的排序nlgn 归并排序
 *
 * @author shiwenxiang
 * @version 1: SortList.java, v0.1 2020/8/3 shiwenxiang Exp $$
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode midF = mid.next;
        //很关键 注意中点的next指针赋值
        mid.next = null;
        return merge(sortList(head), sortList(midF));
    }

    public ListNode getMid(ListNode head) {
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode head = new ListNode();
        ListNode point = head;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                point.next = node2;
                node2 = node2.next;
            } else {
                point.next = node1;
                node1 = node1.next;
            }
            point = point.next;
        }
        if (node1 == null) {
            point.next = node2;
        } else {
            point.next = node1;
        }
        return head.next;
    }

    ListNode getInitA() {
        ListNode a = new ListNode(6);
        ListNode b = new ListNode(8);
        ListNode c = new ListNode(10);
        a.next = b;
        b.next = c;
        return a;
    }

    ListNode getInitB() {
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(7);
        ListNode f = new ListNode(9);
        d.next = e;
        e.next = f;
        return d;
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

    public void testMerge() {
        ListNode a = getInitA();
        ListNode b = getInitB();
        ListNode merge = merge(a, b);
        show(merge);
    }

    public void testSort() {
        ListNode c = getInitC();
        ListNode sort = sortList(c);
        show(c);
    }

    public static void main(String[] args) {
        new SortList().testSort();
    }

    public void show(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
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
