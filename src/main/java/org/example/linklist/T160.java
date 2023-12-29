package org.example.linklist;

import java.util.Stack;

/**
 *
 * @Datetime: 29/12/2023 下午3:22
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/description/">链表相交</a>
 */
public class T160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> res1 = new Stack<>();
        Stack<ListNode> res2 = new Stack<>();
        while (headA != null) {
            res1.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            res2.add(headB);
            headB = headB.next;
        }
        ListNode nowEnd = null;
        while (!res1.empty() && !res2.empty() && res1.peek() == res2.peek()) {
            nowEnd = res1.pop();
            res2.pop();
        }
        return nowEnd;
    }
}
