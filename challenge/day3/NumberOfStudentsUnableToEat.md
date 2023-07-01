# Number Of Students Unable To Eat - EASY

For solve this problem I used a Doubly Linked List.
<a href="https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/">LeetCode</a>

```java
class ListNode{
    int val;
    ListNode prev;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class Queues{
    ListNode front;
    ListNode rear;

    public Queues(){
        front = null;
        rear = null;
    }

    public int size(){
        int count = 0;
        ListNode cur = front;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    public void clear(){
        front = null;
        rear = null;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void printElements() {
        ListNode current = front;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void enqueue(int val){
        ListNode newNode = new ListNode(val);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }else{
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue(){
        if(isEmpty()){
            return -1;
        }

        int val = front.val;
        if(front == rear){
            front = null;
            rear = null;
        }else{
            front = front.next;
            front.prev = null;
        }
        return val;
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return front.val;
    }
}

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queues st = new Queues();
        Queues sand = new Queues();

        // add all elements in queue
        for(int i =0; i<students.length; i++){
            st.enqueue(students[i]);
            sand.enqueue(sandwiches[i]);
        }

        while(!sand.isEmpty()){
            int stCount = 0;
            int stInt = st.dequeue();
            int sandInt = sand.dequeue();
        
            while(stInt != sandInt){ 
                st.enqueue(stInt); 
                stInt = st.dequeue();
                if(stCount == st.size()){
                    return st.size()+1;
                }
                stCount++;
            }
        }
        return st.size();
    }
}
```