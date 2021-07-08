/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.problem.list;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * @author shiwenxiang
 * @version 1: PartitionList.java, v0.1 2020/8/5 shiwenxiang Exp $$
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode left = new ListNode();
        ListNode l = left;
        ListNode right = new ListNode();
        ListNode r = right;

        while (head != null) {
            if (head.val < x) {
                left.next = new ListNode(head.val);
                left = left.next;
            } else {
                right.next = new ListNode(head.val);
                right = right.next;
            }
            head = head.next;
        }
        left.next = r.next;//注意衔接
        return l.next;
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
