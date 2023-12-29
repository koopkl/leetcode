package org.example.linklist;

/**
 *
 * @Datetime: 29/12/2023 下午2:43
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/remove-linked-list-elements/description/">移除链表元素</a>
 */
public class T203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode myHead = new ListNode();
        myHead.next = head;
        myHead.val = -1;
        ListNode temp = myHead;
        while (temp != null) {
            if (temp.next != null && temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }

        }
        return myHead.next;
    }
}
