package org.example.linklist;

/**
 *
 * @Datetime: 1/1/2024 下午4:19
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">删除链表的倒数第N个</a>
 */
public class T19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(-1, head);
        ListNode fast = temp;
        ListNode slow = temp;
        while (fast != null && n >= 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return temp.next;
    }
}
