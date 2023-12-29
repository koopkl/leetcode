package org.example.linklist;

/**
 *
 * @Datetime: 29/12/2023 下午3:50
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/linked-list-cycle/description/">环形链表</a>
 */
public class T141 {
    /**
     * 修改val方法
     * @return
     */
    public boolean hasCycle(ListNode head) {
        while (true) {
            if (head == null) {
                return false;
            }
            if (head.val < -100000) {
                return true;
            }
            head.val = -100005;
            head = head.next;
        }
    }

    /**
     * 快慢指针方法
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode slow = temp;
        ListNode fast = temp.next;
        while (slow != fast) {
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast != null) {
                fast = fast.next;
            }
        }
        return fast != null;
    }
}
