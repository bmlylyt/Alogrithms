import java.util.HashMap;
import java.util.Map;

public class LFUCache {
   class Node {
      int key;
      int value;
      int times;
      Node prev;
      Node next;
      public Node (int key, int value, int times) {
         this.key = key;
         this.value = value;
         this.times = times;
      }
   }
   Map<Integer, Node> nodeMap;
   Map<Integer, Node> freMap;
   Node head;
   Node tail;
   int size;
   int capacity;

   public LFUCache(int capacity) {
      nodeMap = new HashMap<>();
      freMap = new HashMap<>();
      this.capacity = capacity;
      size = 0;
      head = new Node(0, 0, 0);
      tail = new Node(0, 0, 0);
      head.next = tail;
      tail.prev = head;
   }

   public int get(int key) {
      if (capacity == 0 || !nodeMap.containsKey(key)) {
         return -1;
      }
      Node oldNode = nodeMap.get(key);
      put(key, oldNode.value);
      return oldNode.value;
   }

   public void put(int key, int value) {
      if (capacity == 0) return;
      if (nodeMap.containsKey(key)) {
         Node cur = nodeMap.get(key);
         if (freMap.get(cur.times) == cur && freMap.get(cur.times + 1) == null) {
            freMap.put(cur.times, cur.prev.times == cur.times ? cur.prev : null);
            cur.times ++;
            cur.value = value;
            freMap.put(cur.times, cur);
            nodeMap.put(key, cur);
            return;
         }
         deleteNode(cur);
         if (freMap.get(cur.times) == cur) {
            freMap.put(cur.times, cur.prev.times == cur.times ? cur.prev : null);
         }
         cur.times ++;
         cur.value = value;
         Node oldNode = freMap.get(cur.times) == null ? freMap.get(cur.times - 1) : freMap.get(cur.times);
         freMap.put(cur.times, cur);
         insertNode(oldNode, cur);
      } else if (size == capacity) {
         Node newNode = new Node(key, value, 1);
         Node lastNode = head.next;
         deleteNode(lastNode);
         nodeMap.remove(lastNode.key);
         if (freMap.get(lastNode.times) == lastNode) {
            freMap.remove(lastNode.times);
         }
         if (freMap.get(1) == null) {
            insertNode(head, newNode);
         } else {
            Node oldNode = freMap.get(1);
            insertNode(oldNode, newNode);
         }
         freMap.put(1, newNode);
         nodeMap.put(key, newNode);
      } else {
         size ++;
         Node newNode = new Node(key, value, 1);
         if (freMap.get(1) == null) {
            insertNode(head, newNode);
         } else {
            Node oldNode = freMap.get(1);
            insertNode(oldNode, newNode);
         }
         freMap.put(1, newNode);
         nodeMap.put(key, newNode);
      }

   }
   private void insertNode(Node node1, Node node2) {
      node2.next = node1.next;
      node1.next.prev = node2;
      node1.next = node2;
      node2.prev = node1;
   }
   private void deleteNode(Node node) {
      node.next.prev = node.prev;
      node.prev.next = node.next;
   }

   public static void main(String[] args) {
      LFUCache lfu = new LFUCache(2);
      lfu.put(1,1);
      lfu.put(2,2);
      System.out.println(lfu.get(1));
      lfu.put(3,3);
      System.out.println(lfu.get(2));
      System.out.println(lfu.get(3));
      printDoubleList(lfu.head);
   }
   private static void printDoubleList (Node head) {
      Node cur = head;
      while (cur.next != null) {
         System.out.print("(" + cur.key + "," + cur.value + ")" + " -- ");
         cur = cur.next;
      }
      System.out.println("(" + cur.key + "," + cur.value + ")");
   }
}

