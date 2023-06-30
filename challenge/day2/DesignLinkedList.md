# Design Linked List - Medium (Leetcode 707)

<a href="https://leetcode.com/problems/design-linked-list/">LeetCode</a>

To solve this problem we need just implement each LinkedList methods (Init, Insert, Delete, etc..)

### 1. ListNode Class:
* ```int val```: This variables stores the value of the node.
* ```ListNode prev```: This variable references the previous node in the linked list.
* ```ListNode next```: This variable references the next node in the linked list.
* ```ListNode(int val)```: This is the constructor of the ```ListNode``` class, which initializes the ```val``` and sets both ```prev``` and ```next``` to ```null```


### 2. MyLinkedList Class:
* ```ListNode left```: Points to the leftmost dummy node in the linked list.
* ```LiistNode right```: Points to the rightmost dummy node in the linked list.

### 3. get(int index):
* This method returns the value at the the specified ```index``` in the linked list.
* It starts traversing the linked list from the ```left.next``` node until it reaches the desired index or the end of the list.
* If the index is within bounds and the currrent node is not the ```right``` dummy node, it returns the value of the current node.
* IF the conditions are not met, it returns ```-1``` to indicate an out-of-bounds index or a position beyond the ```right``` node.

### 4. addAtHead(int val):
* This method adds a new ode with the given ```val``` at the beginning of the linked list.
* It creates a new node, ```firstElement```, and updates the necessary references to insert it at the head
* The ```next``` and ```prev``` variables are used to adjust the connections between the existing ```left``` node, the new node, and the node that was previously at the head.
  
### 5. addAtTail(int val):
* This method adds a new node with the given ```val``` at the end of the linked list.
* It creates a new node, ```lastElement```, and updates the necessary references to insert it at the tail.
* The ```next``` and ```prev``` variables are used to adjust the connections between the existing ```right``` node, the new node, and the node that was previously at the tail.
  

### 6. addAtIndex(int index, int val):
* This medhod adds a new node with the given ```val``` at the specified ```index``` in the linked list.
* It starts traversing the linked list from the ```left.next``` node until it reaches the desired index or the end of the list.
* If the index is within bounds, it cretaes a new node, ```addElement```, and updates the necessary references to insert it at the specified index.
* The ```next``` and ```prev``` variables are used to adjust the connections between the current node, the new node, and the adjacent nodes.

### 7 deleteAtIndex(int index):
* This method deletes the node at the specified ```index`` in the linked list.
* It starts traversing the linked list from the ```left.next``` node until it reaches the desired index or the end of the list.
* If the index is within bounds and the current node is not the ```right``` dummy node, it updates the necessary references to remove the node at the specified index.
* The ```next``` and ```prev``` variables are used to adjust the connections between the current node's adjacent nodes, effectively removeing the current node from the linked list.

# Source Code

```java
class ListNode{
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class MyLinkedList {
    ListNode left;
    ListNode right;

    public MyLinkedList() {
        left = new ListNode(0);
        right = new ListNode(0);
        left.next = right; // set first element
        right.prev = left; // set first element
    }
    
    public int get(int index) {
        ListNode tail = left.next; 
        while(tail != null && index > 0){
            tail = tail.next;
            index--;
        }
        if(tail != null && tail != right && index == 0){
            return tail.val;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        ListNode firstElement = new ListNode(val);
        ListNode next = left.next;
        ListNode prev = left;
        prev.next = firstElement;
        next.prev = firstElement;
        firstElement.next = next;
        firstElement.prev = prev;
    }
    
    public void addAtTail(int val) {
        ListNode lastElement = new ListNode(val);
        ListNode next = right;
        ListNode prev = right.prev;
        prev.next = lastElement;
        next.prev = lastElement;
        lastElement.next = next;
        lastElement.prev = prev;
    }
    
    public void addAtIndex(int index, int val) {
        ListNode curr = left.next;
        while(curr != null && index > 0){
            curr = curr.next;
            index--;
        }
        if(curr != null && index == 0){
            ListNode addElement = new ListNode(val);
            ListNode next = curr;
            ListNode prev = curr.prev;
            prev.next = addElement;
            next.prev = addElement;
            addElement.next = next;
            addElement.prev = prev;
        }
    }
    
    public void deleteAtIndex(int index) {
        ListNode curr = left.next;
        while(curr != null && index > 0){
            curr = curr.next;
            index--;
        }
        if(curr != null && curr != right && index == 0){
            ListNode next = curr.next;
            ListNode prev = curr.prev;
            next.prev = prev;
            prev.next = next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
```