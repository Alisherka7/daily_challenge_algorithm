class ListNode {
  int value;
  ListNode next;

  public ListNode(int value) {
    this.value = value;
    this.next = null;
  }
}

public class MergeTwoLinkedList {

  // generate Linked list
  private static ListNode generateListNode(int start, int end) {
    ListNode head = new ListNode(0);
    ListNode tail = head;
    for (int i = start; i <= end; i++) {
      ListNode newNode = new ListNode(i);
      tail.next = newNode;
      tail = tail.next;
    }
    return head.next;
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

  // merge two listnode
  private static ListNode mergeTwoList(ListNode list1, ListNode list2) {
    ListNode res = new ListNode(0);
    ListNode tail = res;

    while (list1 != null && list2 != null) {
      if (list1.value < list2.value) {
        tail.next = list1;
        list1 = list1.next;
      } else {
        tail.next = list2;
        list2 = list2.next;
      }
      tail = tail.next;
    }

    if (list1 != null) {
      tail.next = list1;
    } else {
      tail.next = list2;
    }
    return res.next;
  }

  public static void main(String[] args) {
    // generate linked list
    ListNode list1 = generateListNode(0, 5);
    ListNode list2 = generateListNode(2, 8);
    System.out.println("->List1");
    printListNode(list1);
    System.out.println("->List2");
    printListNode(list2);

    ListNode mergedListNode = mergeTwoList(list1, list2);
    System.out.println("After merge");
    printListNode(mergedListNode);

  }
}
