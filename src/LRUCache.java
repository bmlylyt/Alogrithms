import java.util.HashMap;
import java.util.Map;

class Node {
    public int key;
    public int value;
    public Node pre;
    public Node next;
    public Node (int key, int value) {
        this.key = key;
        this.value = value;
        pre = null;
        next = null;
    }
}
public class LRUCache {
    public Map<Integer, Node> map;
    public Node head;
    public Node tail;
    public int size;
    public int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
        size = 0;

    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node curNode = map.get(key);
        int result = curNode.value;
        deleteNode(curNode);
        addToTail(curNode);
        return result;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node newNode = new Node(key, value);
            if (size < capacity) {
                map.put(key, newNode);
                addToTail(newNode);
                size ++;
            } else {
                map.remove(head.next.key);
                deleteNode(head.next);
                addToTail(newNode);
            }
            return;
        }
        Node curNode = map.get(key);
        curNode.value = value;
        deleteNode(map.get(key));
        addToTail(curNode);
    }
    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private void addToTail(Node node) {
        node.pre = tail.pre;
        node.pre.next = node;
        tail.pre = node;
        node.next = tail;
    }
    private void print() {
        Node cur = head;
        System.out.print("[");
        while (cur != null) {
            System.out.print(" " + cur.value + " ");
            cur = cur.next;
        }
        System.out.print("]");
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.print();
        cache.get(1);
        cache.print();
        cache.put(3,3);
        cache.print();
        cache.get(2);
        cache.print();
        cache.put(4,4);
        cache.print();
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));

    }
}

