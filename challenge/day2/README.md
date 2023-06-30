# Day 2 - Doubly Linked List

## Related Leetcode problem
1. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day1/ReverseLinkedList.java">Design Linked List - Medium</a>
2. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day1/MergeTwoLinkedList.java">Design Browser History - Medium</a>

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

