package org.example.linklist;

/**
 * 训练链表递归很好的题目
 * @Datetime: 1/1/2024 下午4:34
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/description/">两两交换链表中的节点</a>
 */
public class T24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null ) {
            return head;
        }
        return ooo(head, head.next, 2);
    }

    public ListNode ooo(ListNode pre, ListNode next, int cnt) {
        if (next == null) {
            return pre;
        }
        if (next.next == null) {
            pre.next = null;
            next.next = pre;
            return next;
        }
        pre.next = ooo(next.next, next.next.next, cnt + 2);
        next.next = pre;
        return next;
    }
}
