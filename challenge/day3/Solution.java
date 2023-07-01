class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class Queues {
    ListNode front;
    ListNode rear;

    public Queues() {
        front = null;
        rear = null;
    }

    public int size() {
        int count = 0;
        ListNode cur = front;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    public void clear() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int val) {
        ListNode newNode = new ListNode(val);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }

        int val = front.val;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return front.val;
    }
}

public class Solution {
    public static void main(String[] args) {
        int[] students = { 1, 1, 1, 0, 0, 1 };
        int[] sandwiches = { 1, 0, 0, 0, 1, 1 };
        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queues st = new Queues();
        Queues sand = new Queues();

        // add all elements in queue
        for (int i = 0; i < students.length; i++) {
            st.enqueue(students[i]);
            sand.enqueue(sandwiches[i]);
        }

        while (!sand.isEmpty()) {
            int stCount = 0;
            int stInt = st.dequeue(); // 1 | 1 0 0
            int sandInt = sand.dequeue(); // 0 | 1 0 1

            while (stInt != sandInt) {
                stInt = st.dequeue();
                st.enqueue(stInt);
                stCount++;
                if (stCount == st.size()) {
                    return st.size();
                }
            }
        }
        return st.size();
    }
}