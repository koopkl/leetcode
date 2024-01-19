package org.example.linklist;

import java.util.HashMap;

/**
 *
 * @Datetime: 16/1/2024 下午4:19
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/lru-cache/description/">LRU缓存</a>
 */

public class T146 {
    static class LRUCache {
        HashMap<Integer, LRUNode> map = new HashMap<>();
        LRUNode head;
        LRUNode end;
        int capacity;
        class LRUNode {
            int val;
            int key;
            LRUNode left;
            LRUNode right;
            LRUNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            String res = "";
            LRUNode temp = head;
            while (temp != null) {
                builder.append(temp.val + "->");
                temp = temp.right;
            }
            res += builder.toString();
            builder = new StringBuilder();
            temp = end;
            while (temp != null) {
                builder.append(temp.val + "->");
                temp = temp.left;
            }
            return res + "\n" + builder;
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new LRUNode(-1, -1);
            this.end = new LRUNode(-1, -1);
            head.right = end;
            end.left = head;
            head.left = null;
            end.right = null;

        }

        public int get(int key) {
            if (map.containsKey(key)) {
                LRUNode lruNode = map.get(key);
                lruNode.left.right = lruNode.right;
                lruNode.right.left = lruNode.left;
                lruNode.left = this.head;
                lruNode.right = this.head.right;
                this.head.right.left = lruNode;
                this.head.right = lruNode;
                return map.get(key).val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.get(key).val = value;
                this.get(key);
            } else {
                LRUNode lruNode = new LRUNode(key, value);
                lruNode.left = head;
                lruNode.right = head.right;
                head.right = lruNode;
                lruNode.right.left = lruNode;
                if (map.size() >= capacity) {
                    map.remove(end.left.key);
                    end.left = end.left.left;
                    end.left.right = end;
                }
                map.put(key, lruNode);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(1, 0);
        lruCache.put(2, 2);
        System.out.println(lruCache);
    }

}
