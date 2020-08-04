/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package org.algorithm.leetcode.problem.list;

import java.util.List;

/**
 * @author shiwenxiang
 * @version 1: ReverseNodesInKGroup.java, v0.1 2020/8/4 shiwenxiang Exp $$
 */
public class ReverseNodesInKGroup {

    ListNode getInitC() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
//        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
//        e.next = f;
        return a;
    }

    public void show(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public void test() {
        ListNode c = getInitC();
        ListNode node = reverseKGroup(c, 2);
        show(node);
    }

    public static void main(String[] args) {
        new ReverseNodesInKGroup().test();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || k == 1) {
            return head;
        }
        int length = findLength(head);
        if (k <= 0 || k > length) {
            throw new RuntimeException();
        }
        int round = length / k;
        int r = 0;
        int point = 0;
        ListNode res = new ListNode();
        ListNode joinPoint = res;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (r < round) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            point++;
            if (point == k) {
                r++;
                joinPoint.next = pre;
                joinPoint = head;
                head = cur;
                pre = null;
                point = 0;
            }
        }
        joinPoint.next = cur;
        return res.next;
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

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
