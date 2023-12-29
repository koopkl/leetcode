package org.example.linklist;

/**
 *
 * @Datetime: 29/12/2023 下午4:46
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/linked-list-cycle-ii/description/">环形链表2</a>
 */
public class T142 {
    /**
     * 双指针之快慢指针
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode temp = new ListNode();
        temp.next = head;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        ListNode slow = temp;
        ListNode fast = temp;
        do {
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast != null) {
                fast = fast.next;
            }
        } while (slow != fast);
        if (slow == null) {
            return null;
        }
        fast = temp;
        while(fast!= slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
