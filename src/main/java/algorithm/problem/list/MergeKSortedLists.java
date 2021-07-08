package algorithm.problem.list;

/**
 *
 */
public class MergeKSortedLists {

    /**
     * [][][][][][][][]
     * |             |
     * |----><-------|
     * <p>
     * 头尾合并
     * 重新赋值
     * 一直迭代   8 4 2 1
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int point = lists.length - 1;
        while (point > 0) {
            int i = 0;
            int j = point;
            while (j > i) {
                lists[i] = merge(lists[i++], lists[j--]);
            }
            point = j;
        }
        return lists[0];
    }

    /**
     * 合并list
     *
     * @param node1
     * @param node2
     * @return
     */
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                cur.next = node1;
                cur = cur.next;
                node1 = node1.next;
            } else {
                cur.next = node2;
                cur = cur.next;
                node2 = node2.next;
            }
        }
        if (node1 == null) cur.next = node2;
        if (node2 == null) cur.next = node1;
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
