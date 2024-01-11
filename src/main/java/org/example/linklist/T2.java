package org.example.linklist;

/**
 *
 * @Datetime: 8/1/2024 下午10:08
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/add-two-numbers/description">两数相加</a>
 */
public class T2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode now = res;
        int add = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + add;
            add = sum / 10;
            now.next = new ListNode(sum % 10, null);
            now = now.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + add;
            add = sum / 10;
            now.next = new ListNode(sum % 10, null);
            now = now.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + add;
            add = sum / 10;
            now.next = new ListNode(sum % 10, null);
            now = now.next;
            l2 = l2.next;
        }

        if (add == 1) {
            now.next = new ListNode(1, null);
        }
        return res.next;
    }

}
