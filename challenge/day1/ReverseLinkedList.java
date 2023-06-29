class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class ReverseLinkedList {
    // Iterate method
    private static ListNode iterateReverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // reverse
    private static ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }

        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;

        return reverse(head, newHead);
    }

    // Recursive method
    private static ListNode recursiveReverse(ListNode head) {
        return reverse(head, null);
    }

    // generate Linked list
    private static ListNode generateListNode() {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i = 1; i < 10; i++) {
            ListNode newNode = new ListNode(i);
            tail.next = newNode;
            tail = tail.next;
        }
        return head;
    }

    // print linked list
    private static void printListNode(ListNode head) {
        ListNode tail = head;
        while (tail != null) {
            System.out.print(tail.value + " ");
            tail = tail.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // generate linked list
        ListNode head = generateListNode();
        // print before reversed
        System.out.println("Before reverse");
        printListNode(head);

        ListNode iterateReversedListNode = iterateReverse(head);
        System.out.println("After iterate reverse");
        printListNode(iterateReversedListNode);

        ListNode newHead = generateListNode();

        ListNode recursiveReversedListNode = recursiveReverse(newHead);
        System.out.println("After recursive reverse");
        printListNode(recursiveReversedListNode);

    }
}