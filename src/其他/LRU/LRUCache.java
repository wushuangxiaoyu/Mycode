package 其他.LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-08-17 13:22
 **/
public class LRUCache<K, V> {

    private MyList<V> doubleLinkedList;
    private Map<K, Node<V>> keyAsKeymap;
    private Map<Node<V>, K> nodeAsKeymap;
    private int capacity;

    public LRUCache(int capacity) {
        this.doubleLinkedList = new MyList<>();
        this.keyAsKeymap = new HashMap<>();
        this.nodeAsKeymap = new HashMap<>();
        this.capacity = capacity;
    }

    public V get(K key) {
        if (keyAsKeymap.containsKey(key)) {
            Node<V> node = keyAsKeymap.get(key);
            doubleLinkedList.movetoTail(node);
            return node.value;
        }
        throw new RuntimeException("there is no key here");
    }

    public void set(K key, V value) {
        if (keyAsKeymap.containsKey(key)) {
            Node<V> node = keyAsKeymap.get(key);
            node.value = value;
            doubleLinkedList.movetoTail(node);
        } else {
            Node<V> node = new Node<>(value);
            keyAsKeymap.put(key, node);
            nodeAsKeymap.put(node, key);
            doubleLinkedList.insert(node);
            if (keyAsKeymap.size() == capacity + 1) {
                this.remove();
            }
        }
    }

    private void remove() {
        Node<V> oldNode = doubleLinkedList.removeHead();
        K oldKey = nodeAsKeymap.get(oldNode);
        keyAsKeymap.remove(oldKey);
        nodeAsKeymap.remove(oldNode);
    }


    public static class MyList<V> {
        public Node<V> head;
        public Node<V> tail;

        public MyList() {
            this.head = null;
            this.tail = null;
        }

        public void movetoTail(Node<V> cur) {
            if (cur == tail) {
                return;
            }
            if (cur == head) {
                head = cur.next;
                head.pre = null;
            } else {
                cur.pre.next = cur.next;
                cur.next.pre = cur.pre;
            }
            cur.next = null;
            cur.pre = tail;
            tail.next = cur;
            tail = cur;
        }

        public void insert(Node<V> node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
        }

        public Node<V> removeHead() {
            if (head == null) {
                throw new RuntimeException("Error : doubleLinkedList is empty");
            }
            Node<V> node = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = node.next;
                node.pre = null;
                head.next.pre = null;
            }
            return node;
        }
    }

    public static class Node<V> {
        public V value;
        public Node<V> pre;
        public Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> testCache = new LRUCache<String, Integer>(3);
        testCache.set("A", 1);
        testCache.set("B", 2);
        testCache.set("C", 3);
        System.out.println(testCache.get("B"));
        System.out.println(testCache.get("A"));
        testCache.set("D", 4);
        System.out.println(testCache.get("D"));
        System.out.println(testCache.get("C"));

    }

}
