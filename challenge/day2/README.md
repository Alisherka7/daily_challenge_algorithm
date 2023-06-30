# Day 2 - Doubly Linked List

## Related Leetcode problem
1. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day2/DesignLinkedList.md">Design Linked List - Medium</a>
2. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day2/DesignBrowserHistory.md">Design Browser History - Medium</a>

Having learned about singly linked lists, let's next learn about its variation - the Doubly Linked List. As the name implies, it's called doubly because each node now has two pointers. We have a ```prev``` pointer which points to the previous node, in addition to the ```next``` pointer. If the ```prev``` pointer points to null, it is an indication that we are at the start of the linked list.

<img width="451" alt="Screen Shot 2023-06-30 at 18 25 30" src="https://github.com/Alisherka7/daily_challange_algorithm/assets/38793933/7d64b0bb-397c-4e97-a83a-e90560fe708a">

<hr>

<br>

## Operations of a Doubly Linked Lists

### Insertion 

Similar to the singly linked list, adding a node to a doubly liked lislt will run in ```O(1)``` time. Only this time, we have to update the ```prev``` pointer as well. 

For example, looking at the visual below, we have three nodes in our linked list, ```ListNode1```, ```ListNode2``` and ```ListNode3```. Now we have another node, ```ListNode4```, that we wish to insert We know the we will have to update the ```next``` pointer of ```ListNode3``` and the ```prev``` pointer of ```ListNode4```.

```java
tail.next = ListNode4;
ListNode4.prev = tail;
tail = tail.next;
```


### Deletion

Going back to the example with three nodes, deleting is also a ```O(1)``` operation.
There is no shifting or traversal required. Instead, in this case adjusting the ```prev``` pointer is required. 


```java
ListNode2 = tail.prev;
ListNode2.next = null;
tail = ListNode2;
```


## Sample Codes
<hr>

### 1. Creating a Doubly Linked List

```java
class ListNode {
    int data;
    Node prev;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
```

### 2. Inserting an element at the beginning of the list:
```java
public void insertAtBeginning(int data){
    ListNode newNode = new ListNode(data); // -> 1, null, null
    if(head == null){
        head = newNode;
    }else{
        newNode.next = head; // -> 1, null, head(2,3)
        head.prev = newNode; // -> head(2), newNode(1), head(3)
        head = newNode; // -> head(1), head(2), head(3)
    }
}
```


### 3. Inserting an Element at the End of the list:
```java 
public void isnertAtEnd(int data){
    ListNode newNode = new ListNode(data);
    if(head == null){
        head = newNode;
    }else{
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next; // go to the last element
        }
        tail.next = newNode; // add new node at the last node
        newNode.prev = tail; // set prev node as tail last node for connection
    }
}
```

### 4. Inserting an Element at a Specific Position:
```java
public void insertAtPosition(int data, int position){

    // if position incorrect
    if(position < 1){
        System.out.println("Invalid position");
        return;
    }

    // if position is first element
    ListNode newNode = new ListNode(data);
    if(position == 1){
        if(head != null){
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        return;
    }

    // go to the specified position
    ListNode tail = head;
    int currentPos = 1;

    while(currentPos < position -1 && tail != null){
        tail = tail.next; // current position is -> tail(2)
        currentPos++;
    }


    // if tail out of bounds
    if(tail == null){
        System.out.println("Invalid position");
        return;
    }

    newNode.next = tail.next; // -> newNode(3), null, tail(4)
    if(tail.next != null){
        tail.next.prev = newNode; // -> tail(4), newNode(3), tail(5)
    }
    tail.next = newNode; // -> tail(2), tail(1), newNode(3)
    newNode.prev = tail; // -> newNode(3), tail(2), tail(4)
}
```

### 5. Removing an Element from the beginning of the List:
```java
public void removeFromBeginning(){
    // check list node is not empty
    if(head == null){
        System.out.println("List is empty.");
        return;
    }
    
    // check list node is not last node
    if(head.next == null){
        head = null;
        return;
    }

    head = head.next; // On first head node setted as second node
    headp.prev = null; // Because of it's a first element we need set it null
}
```

### 6. Removing an Element from the End of the List:
```java
public void removeFromEnd(){
    // check list node is not empty
    if(head == null){
        System.out.println("List is empty.");
        return;
    }

    // check list node is not last node
    if(head.next == null){
        head = null;
        return;
    }

    ListNode tail = head;
    while(tail.next != null){
        // go to the last node
        tail = tail.next; // tail(5), tail(4), null
    }
    tail.prev.next = null; // tail(5), null, null
}
```

### 7. Removing an Element from a Specific position
```java
public void removeFromPosition(int pos){

    // check list node is not empty
    if (head == null) {
        System.out.println("List is empty.");
        return;
    }

    // check position on valid
    if (pos < 1) {
        System.out.println("Invalid position.");
        return;
    }

    // if current pos is first element
    if(pos == 1){
        head = head.next; // head(1), null, head(2)
        if(head != null){
            head.prev = null; // head(2), null, head(3)
        }
        return;
    }

    ListNode tail = head;
    int currPos = 1;

    // go to the position
    while(currPos < position && tail != null){
        tail = tail.next; // curr pos -> tail(4), tail(3), tail(5)
        currPos++;
    }

    // if curr position out of bounds
    if(tail == null){
        System.out.println("Invalid position.");
        return;
    }

    // if curre pos is last element
    if(tail.next == null){
        tail.prev.next = null; // -> tail(3), tail(2), null
        return;
    }

    tail.prev.next = tail.next; // -> tail(3), tail(2), tail(5)
    tail.next.prev = tail.prev; // -> tail(5), tail(3), tail(6)
}
```



### Access 
Similar to singly linked lists, we cannot randomly access a node. So in the worst case, we will have to traverse ```n``` nodes before reaching the deisred node. This operation runs in ```O(n)```.

## Big-O time complexity

<table>
<tr>
<th>Operation</th>
<th>Big-O time complexity</th>
</tr>
<tr>
<td>Access</td>
<td>O(n)</td>
<tr>
<tr>
<td>Search</td>
<td>O(n)</td>
<tr>
<tr>
<td>Insertion</td>
<td>O(1)</td>
<tr>
<tr>
<td>Deletion</td>
<td>O(1)</td>
<tr>
</table>

