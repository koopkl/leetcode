package org.example.linklist;

/**
 *
 * @Datetime: 8/1/2024 下午7:59
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/palindrome-linked-list/"></a>
 */
public class T234 {
    private ListNode left;
    public boolean isPalindrome(ListNode head) {
        this.left = head;
        return kk(head);
    }

    public boolean kk(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = kk(right.next) && left.val == right.val;
        left = left.next;
        return res;
    }
}
