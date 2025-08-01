package zuochengyun;

// 链表
// 反转单链表、反转双链表
// 合并两个有序列表

// Java API: LinkedList

public class ListAlgorithm {
    // 单链表节点
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 双链表节点
    public static class DoubleListNode {
        public int val;
        public DoubleListNode last;
        public DoubleListNode next;

        public DoubleListNode(int val) {
            this.val = val;
        }
    }

    // 反转单链表
    // https://leetcode.cn/problems/reverse-linked-list
    public reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    // 反转双链表
    public reverseDoubleList(DoubleListNode head) {
        DoubleListNode pre = null;
        DoubleListNode next = null;
        
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;  // add
            pre = head;
            head = next;
        }

        return pre;
    }

    // 合并两个有序列表
    // https://leetcode.cn/problems/merge-two-sorted-lists
    public mergeTwoSortedLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        ListNode head = head1.val <= head2.val ? head1 : head2;  // 较小的 head 保存头节点用于返回
        ListNode cur1 = head.next;                               // 较小的 head.next
        ListNode cur2 = head1.val <= head2.val ? head2 : head1;  // 较大的 head
        ListNode pre = head;                                     // 当前正在处理的节点

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }

        pre.next = cur1 != null ? cur1 : cur2;
        
        return head;
    }
}