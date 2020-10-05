/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.leetcode.problem.list;

import java.util.List;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Return the linked list sorted as well.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 * @author shiwenxiang
 * @version : RemoveDuplicatesFromSortedListII.java, v0.1 2020/8/5 shiwenxiang Exp $$
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prePre = new ListNode(0, head);
        ListNode p = prePre;
        ListNode pre = head;
        ListNode cur = head.next;
        boolean flag = false;
        while (cur != null) {
            if (pre.val == cur.val) {
                flag = true;
                pre.next = cur.next;
                //注意重复的结尾
                if (cur.next == null) {
                    prePre.next = null;
                    break;
                }
            } else {
                if (flag) {
                    prePre.next = cur;
                    pre = cur;
                    flag = false;
                } else {
                    prePre = pre;
                    pre = pre.next;
                }
            }
            cur = cur.next;
        }
        return p.next;
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
