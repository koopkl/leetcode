package org.example.linklist;

/**
 *
 * @Datetime: 8/1/2024 下午9:41
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/">合并两个链表</a>
 */
public class T21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode temp = new ListNode();
       ListNode now = temp;
       if (list1 == null) {
           return list2;
       }
       if (list2 == null) {
           return list1;
       }
       while (list1 != null && list2 != null) {
           while (list1 != null && list1.val <= list2.val) {
                now.next = list1;
                now = now.next;
                list1 = list1.next;
           }
           if (list1 == null) {
               now.next = list2;
               now = now.next;
               continue;
           }
           while (list2 != null && list1.val > list2.val) {
               now.next = list2;
               now = now.next;
               list2 = list2.next;
           }
           if (list2 == null) {
               now.next = list1;
               now = now.next;
           }
       }
       return temp.next;
    }
}
