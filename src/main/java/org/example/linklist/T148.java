package org.example.linklist;

/**
 * 排序链表
 * @Datetime: 11/1/2024 下午3:39
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/sort-list/">排序链表</a>
 */
public class T148 {
    public ListNode sortList(ListNode head) {
        return mySort(head, null);
    }

    public ListNode mySort(ListNode left, ListNode right) {
        if (left == null) {
            return null;
        }
        if (left.next == right) {
            left.next = null;
            return left;
        }
        // 找到中点
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right) {
            slow = slow.next;
            fast = fast.next;
            if (fast != right) {
                fast = fast.next;
            }
        }
        System.out.println("one");
        System.out.println(left.val);
        System.out.println(slow.val);
        if (right != null) {
            System.out.println(right.val);
        }
        ListNode mid = slow;
        ListNode list1 = mySort(left, mid);
        ListNode list2 = mySort(mid, right);
        ListNode merged = mergeList(list1, list2);
        return merged;
    }

    public ListNode mergeList(ListNode lst1, ListNode lst2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = lst1, temp2 = lst2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
