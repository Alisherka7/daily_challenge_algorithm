# Day 3 - Queues & Recursion

## Queues 

### Related Leetcode problem
1. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day3/NumberOfStudentsUnableToEat.md">Number of Students Unable to eat lunch - EASY</a>
2. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day2/DesignBrowserHistory.md">Implement Stack using queues - EASY</a>

Queues are similar to stack, except they follow what called a ```FIFO``` approach(First in First out). A real world example would be a line at the bank. The first person to come in the line is the first person to be serve.
<hr>

### Implementation and Operation
The most common implementation of a queue is using a ```LinkedList```. The two operations that queues support are ```enqueue``` and ```dequeue```

### Enqueue
The ```enqueue``` operation adds elements to the ```tail``` of the queue until the size of the queue is reached. Since adding to the end of the queue requires no shifting of the elements, this operation runs in ```O(1)```. 

```java
public void enqueue(int val){
    ListNode newNode = new ListNode(val);
    if(this.right != null){
        // Queue is not empty
        this.right.next = newNode;
        this.right = this.right.next;
    }else{
        // Queue is empty
        this.left = newNode;
        this.right = newNode;
    }
}
```

<img width="569" alt="Screen Shot 2023-07-01 at 16 29 05" src="https://github.com/Alisherka7/daily_challange_algorithm/assets/38793933/832fd0bb-dab3-4477-b5bd-b404807ef748">

<br>
<br>


### Dequeue

The ```dequeue``` operation removes elements from the front of the queue and returns that element. 

```java
public int dequeue(){
    if(this.left == null){
        // Queue is empty
        System.exit(0);
    }
    int val = this.left.val;
    this.left = this.left.next;
    if(this.left == null){
        this.right = null;
    }

    return val;
}
```

<img width="572" alt="Screen Shot 2023-07-01 at 16 31 04" src="https://github.com/Alisherka7/daily_challange_algorithm/assets/38793933/19575552-f1d3-4b43-8e91-35784f5164ed">

<br>
<br>

Queues could also be implemented by using dynamic arrays, however, it gets a little bit trickier if you want to maintain efficiency of ```enqueue``` and ```dequeue``` operations. With the array implementation, ```dequeue``` would take ```O(n)``` time due to shifting of the elements.

> Similar to stacks, it is a good measure to check if the queue is empty before performing the dequeue operation.


## Operations with Queues

* 1. Creating a Doubly Linked ListNode
```java
class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
```


* 2. Implementing
```java
class Queue{
    private ListNode front;
    private ListNode rear;

    public Queue(){
        front = null;
        rear = null;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public enqueue(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }else{
            newNode.prev =rear;
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
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
            throw new NoSuchElementException("Queue is empty!");
        }

        return front.data;
    }

    public int size(){
        int count = 0;
        ListNode cur = front;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void clearn(){
        front = null;
        rear = null;
    }
}
```

## Big-O time complexity

<table>
<tr>
<th>Operation</th>
<th>Big-O time complexity</th>
</tr>
<tr>
<td>Enqueue</td>
<td>O(1)</td>
</tr>
<tr>
<td>Dequeue</td>
<td>O(1)</td>
</tr>

</table>

