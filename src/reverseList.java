import java.util.ArrayList;
import java.util.List;

public class reverseList {
    public static ListNode reverseListBy2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode subHead = reverseListBy2(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = subHead;
        return newHead;
    }

    public static ListNode reverseListBy3(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode subHead = reverseListBy3(head.next.next.next);
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        int count = 3;
        while (count -- > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = subHead;
        return prev;
    }
    // 1 -> 2 -> 3   6 -> 5 -> 4 -> null
    //            \___________/

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        // 5
        ListNode nextHead = head;
        for (int i = 0; i < n; i ++) {
            nextHead = nextHead.next;
        }
        // 1
        ListNode preHead = head;
        for (int i = 0; i < m - 2; i ++) {
            preHead = preHead.next;
        }
        // 2
        ListNode tail = head;
        for (int i = 0; i < m - 1; i ++) {
            tail = tail.next;
        }
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = tail;
        for (int i = 0; i <= n - m; i ++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        preHead.next = prev;
        tail.next = nextHead;
        return head;

    }
    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        ListNode test2 = new ListNode(2);
        ListNode test3 = new ListNode(3);
        ListNode test4 = new ListNode(4);
        ListNode test5 = new ListNode(5);

        ListNode demo1 = new ListNode(3);
        ListNode demo2 = new ListNode(5);
        demo1.next = demo2; demo2.next = null;

        test1.next = test2;test2.next = test3; test3.next = test4;test4.next = test5;
        test5.next = null;
        ListNode head1 = test1;
        ListNode head2 = demo1;
        printList(head2);

        reverseBetween(head2, 1, 2);

        printList(head2);

    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
        System.out.println("");
    }

}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int i) {
        val = i;
    }
}
