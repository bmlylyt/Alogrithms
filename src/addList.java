public class addList {
    public static ListNode plusOne(ListNode head) {
        if (head == null || head.val == 0) return new ListNode(1);
        if (head.next == null && head.val < 9) {
            head.val = head.val + 1;
            return head;
        } else if (head.next == null && head.val == 9) {
            ListNode dummy = new ListNode(1);
            head.val = 0;
            dummy.next = head;
            return dummy;
        }

        int val = head.val + plusOneDigit(head.next);
        if (val == 10) {
            ListNode dummy = new ListNode(1);
            dummy.next = head;
            return dummy;
        }
        head.val = val;
        return head;
    }
    private static int plusOneDigit(ListNode head) {
        if (head == null) return 0;
        if (head.next == null) {
            if (head.val == 9) {
                head.val = 0;
                return 1;
            } else {
                head.val = head.val + 1;
                return 0;
            }
        }

        if ((head.val + plusOneDigit(head.next)) == 10) {
            head.val = 0;
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(9);
        ListNode two = new ListNode(9);
        ListNode three = new ListNode(0);
        one.next = two; two.next = null;
        double num1 = 4.3;
        int num2 = 3;
        System.out.println(num1 - num2);

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

