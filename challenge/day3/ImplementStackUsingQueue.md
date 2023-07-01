# Implement Stack Using Queue + (LinkedList)
<a href="https://leetcode.com/problems/implement-stack-using-queues/description/">Leetcode</a>

My Solution
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

        int val = rear.val;
        if(front == rear){
            front = null;
            rear = null;
        }else{
            rear = rear.prev;
            rear.next = null;
        }
        return val;
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return rear.val;
    }
}

class MyStack {
    Queues myStack;

    public MyStack() {
        myStack = new Queues();
    }
    
    public void push(int x) {
        myStack.enqueue(x);
    }
    
    public int pop() {
        return myStack.dequeue();
    }
    
    public int top() {
        return myStack.peek();
    }
    
    public boolean empty() {
        return myStack.isEmpty();
    }
}
```