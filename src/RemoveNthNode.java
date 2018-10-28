public class RemoveNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n -- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.val);
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        n1.next = n2;n2.next = n3;n3.next = n4;n4.next = n5;
//        ListNode head = removeNthFromEnd(n1, 2);
//        while (head != null) {
//            System.out.print(head.val + " -> ");
//            head = head.next;
//        }
        double a = 1.1;
        int b = 1;
        System.out.print(a - b);
    }
}
