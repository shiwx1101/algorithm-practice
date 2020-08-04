/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package org.algorithm.leetcode.problem.list;

import java.util.List;

/**
 * Merge two sorted linked lists and return it as a new sorted list.
 * <p>
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @author shiwenxiang
 * @version 1: MergeTwoSortedLists.java, v0.1 2020/8/4 shiwenxiang Exp $$
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode head = new ListNode(0, null);
        ListNode point = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                point.next = l2;
                l2 = l2.next;
            } else {
                point.next = l1;
                l1 = l1.next;
            }
            point = point.next;
        }
        if (null == l1) {
            point.next = l2;
        }
        if (null == l2) {
            point.next = l1;
        }
        return head.next;
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
