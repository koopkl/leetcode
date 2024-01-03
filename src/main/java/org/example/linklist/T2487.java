package org.example.linklist;

import java.util.Stack;

/**
 *
 * @Datetime: 3/1/2024 下午2:29
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/remove-nodes-from-linked-list/description/">
 *     从链表中移除元素</a>
 */
public class T2487 {
    /**
     * stack
     * @return
     */
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        Stack<ListNode> resStack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }
        ListNode res = null;
        while (!stack.empty()) {
            if (res == null) {
                res = stack.pop();
            } else {
                if (stack.peek().val < res.val) {
                    stack.pop();
                } else {
                    ListNode tempNode = stack.pop();
                    tempNode.next = res;
                    res = tempNode;
                }
            }
        }
        return res;
    }

    public ListNode ooo(ListNode head) {
        if (head == null) {
            return null;
        }
        head.next = ooo(head.next);
        if (head.next != null && head.val < head.next.val) {
            return head.next;
        } else {
            return head;
        }

    }

}
