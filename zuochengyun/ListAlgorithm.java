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

    // 双链表节点
    public static class DoubleListNode {
        public int val;
        public DoubleListNode last;
        public DoubleListNode next;

        public DoubleListNode(int val) {
            this.val = val;
        }
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
}