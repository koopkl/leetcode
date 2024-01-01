package org.example.linklist;

/**
 *
 * @Datetime: 1/1/2024 下午4:46
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/reverse-linked-list/description/">反转链表</a>
 */
public class T206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
