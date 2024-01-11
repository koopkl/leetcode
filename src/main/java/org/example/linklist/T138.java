package org.example.linklist;

import java.util.HashMap;

/**
 * 随机链表的复制
 * @Datetime: 11/1/2024 下午3:03
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/copy-list-with-random-pointer/description/"></a>
 */
public class T138 {
    private HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return  null;
        }
        if (!map.containsKey(head)) {
            Node newNode = new Node(head.val);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
            map.put(head, newNode);
        }
        return map.get(head);
    }
}
