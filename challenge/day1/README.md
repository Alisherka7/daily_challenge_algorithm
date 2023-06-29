# Day 1 - LinkedList 

## Related Leetcode problem
1. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day1/ReverseLinkedList.java">Reverse Linked List - EASY</a>
2. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day1/MergeTwoLinkedList.java">Merge two Linked List - EASY</a>

## Singly Linked list
Linked list - linear collection of data elements whose order is not given by their physical placement in memory. Instead, each element points to the next.

**linked lists** are made up of objects called ```ListNode's```
* ```value``` - This stores value of the node. <i>The value can be anything - character, integer etc...</i>
* ```next``` - This stores the reference to the next node in the linked list. 


The picture below visualizes ```ListNode``` object.

<img width="394" alt="Screen Shot 2023-06-29 at 20 15 49" src="https://github.com/Alisherka7/LeetCode/assets/38793933/6b0d1d61-8275-4aea-9129-10180072b542">



### Creating Linked List


```java
    class ListNode{
        int val;
        LinkedList next;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
```

```ListNode``` can be chained together to build desired LinkedList.
Suppose that we have three ```ListNode``` - ListNode1, ListNode2, ListNode3
<img width="919" alt="Screen Shot 2023-06-29 at 20 22 29" src="https://github.com/Alisherka7/LeetCode/assets/38793933/879ef013-2033-434f-996a-38b4b02ae6ff">

* In this case, our value attribute is String - red, blue, gree.
  

> At a lower level, upon instantiation, these objects would get stored in an arbitrary order in the memory. We cannnot control the order in which teh operating system stores these objects in memory, it is not very relevant but still good to know. 

<br>
<br>

We would need to make sure that our next pointers point to another ```ListNode```, and not ```null```

```java
    ListNode.next = ListNode2;
```

<img width="612" alt="Screen Shot 2023-06-29 at 20 28 11" src="https://github.com/Alisherka7/LeetCode/assets/38793933/b46e5474-a238-41f0-a918-2f6c4dac452c">

> The address for ListNode2 is retrivered from memory.


### Traversal
To traverse a linked list from backward to forward, we can just make use a simple while loop.

```java

ListNode cur = ListNode1;

while(cur != null){
    cur = cur.next;
}

```

We keep running while loop and updating our ```curr``` to the next node until we encounter a node that is ```null``` - meaning we are at the end of the linked list and traversal is finished. 

> Traversal is O(n).

<img width="942" alt="Screen Shot 2023-06-29 at 20 34 20" src="https://github.com/Alisherka7/LeetCode/assets/38793933/7f827300-42b0-44a5-849b-aad2cf52cf79">

<br>
<br>


### Circular LinkedList
If our last LinkedList node ```LitsNode3```'s next pointer points to first element ```ListNode1``` instead of ```null```. This would create infinite while loop and the programm will crash. This is because we would never reach the end of the linked list.

<img width="942" alt="Screen Shot 2023-06-29 at 20 37 43" src="https://github.com/Alisherka7/LeetCode/assets/38793933/74f69980-bd4d-4211-9aac-8d4c559cc29d">

<br>
<br>

## Operations of a Singly Linked List

Linked list have a ```head``` and a ```tail``` pointer. The head pointer points to the very first node in the linked list.

### Appending
An advantage that ```LinkedLists``` have over arrays is that adding a new element can be performed ```O(1)``` time.
<i>No shifting is required after adding another node and we already have the references to ```head``` and ```tail``` </i>

```java
    tail.next = ListNode4;
```

<img width="443" alt="Screen Shot 2023-06-29 at 20 46 29" src="https://github.com/Alisherka7/LeetCode/assets/38793933/808683c5-ca27-42fa-9557-43492cb9c66b">


<br>
<br>

### Deleting from a Singly Linked List

Deletion at the head of a ```Singly Linked List``` will take ```O(1)```, since it is a beginning and single operation. 

The way to delete a specific node, say ```y```, is to skip over it - update ```y```’s previous node’s next pointer to the node that comes after ```y```. This is called chaining next pointers together.

<img width="435" alt="Screen Shot 2023-06-29 at 20 50 27" src="https://github.com/Alisherka7/LeetCode/assets/38793933/8318ba64-1c51-4eb0-8bb5-2325237ef8cd">

```java
    head.next = head.next.next;
```

<img width="451" alt="Screen Shot 2023-06-29 at 20 51 11" src="https://github.com/Alisherka7/LeetCode/assets/38793933/c0127bf6-fb8b-48a5-89c0-e42219169799">

<br>
<br>

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