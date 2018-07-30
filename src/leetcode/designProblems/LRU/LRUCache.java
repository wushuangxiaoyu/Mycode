package leetcode.designProblems.LRU;

import java.util.HashMap;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * @author Yu
 * @create 2018-07-19 21:07
 **/
public class LRUCache {

    private DoubleLinkList<Integer> linkList;
    private HashMap<Integer, Node<Integer>> nodeMap;
    private HashMap<Node<Integer>, Integer> keyMap;
    private int capacity;

    public LRUCache(int capacity) {
        if (capacity < 1) {
            throw new RuntimeException("should be more than 0.");
        }
        linkList = new DoubleLinkList<>();
        nodeMap = new HashMap<>();
        keyMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node<Integer> res = nodeMap.get(key);
            linkList.moveNodeToTail(res);
            return res.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            nodeMap.get(key).value = value;
            linkList.moveNodeToTail(nodeMap.get(key));
        } else {
            Node<Integer> newNode = new Node<>(value);
            nodeMap.put(key, newNode);
            keyMap.put(newNode, key);
            linkList.addNode(newNode);
            if (nodeMap.size() == capacity + 1) {
                removeMostUnusedCache();
            }
        }
    }
    private void removeMostUnusedCache() {
        Node<Integer> node = linkList.removeHead();
        Integer key = keyMap.get(node);
        keyMap.remove(node);
        nodeMap.remove(key);
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}

class Node<T> {
    public T value;
    public Node<T> next;
    public Node<T> pre;

    public Node(T value) {
        this.value = value;
    }
}

class DoubleLinkList<T> {
    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(Node<T> node) {
        if (node == null) {
            return;
        }
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }

    public void moveNodeToTail(Node<T> node) {
        if (tail == node) {
            return;
        }
        if (head == node) {
            head = head.next;
            head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        node.pre = tail;
        node.next = null;
        tail.next = node;
        tail = node;
    }

    public Node<T> removeHead() {
        if (head == null) {
            return null;
        }
        Node<T> result = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.pre = null;
            result.next = null;
        }
        return result;
    }

}

