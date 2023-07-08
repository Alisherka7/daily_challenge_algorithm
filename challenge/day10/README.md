# Day 10 - Binary Tree

The binary Tree is another data structure that involves nodes and pointers. Nodes in a binary tree also have at most two pointers, but we call them the **left child** and  the **right child** pointers. The first node in a binary tree is referred to as the **root** node.

The value of a node can be any data type. A ```TreeNode``` class would look like the following. Notice how much of the implementation is similar to a ```ListNode``` discussed in the linked list chapter, except now we have ```left_child``` and ```right_child```.

```java
public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
```

* If a node does not have any childre, it is classified as a ```leaf``` node. 
* If a node has even a single child, either left or right, it would be classified as a ```non-leaf``` node.

Unlike linked list, binary tree node pointers can only point in one direction. As such, cycles are not allowed in binary trees. Mathematically speaking, a binary tree is an undirected graph with no cycles. This means that a leaf node is always guaranteed to exist.

> The same applies to the decision trees that are used in recursion.

The following section demonstrates how binary tress are drawn and their terminology that is crucial to understand binary tree problems in interview.

<hr>

## Properties

## 1. Root Node
Root node is the highes node in the tree and has no parent node. Al of the nodes in the tree can be reached by the root node.

## 2. Leaf Nodes

Leaf nodes are nodes with no children. The nodes at the last level of the tree are guarenteed to be leaf nodes but they can also be found on other levels.

<img width="636" alt="Screen Shot 2023-07-08 at 13 18 30" src="https://github.com/Alisherka7/daily_challenge_algorithm/assets/38793933/3a3c0ce2-8917-48f4-a33f-2d05f7e8dae3">

## 3. Children
The children of a node are its **left child** and **right child**

<img width="647" alt="Screen Shot 2023-07-08 at 13 19 09" src="https://github.com/Alisherka7/daily_challenge_algorithm/assets/38793933/3c37fea5-7c2e-41cb-a7cb-240e26464905">

## 4. Height

The height of a binary tree is measured from the root node all to way to the lowest leaf node, just like the height of anything in real life. The height of a single node tree is just ```1```, if the node itself is counted, or ```0``` if not.

Sometimes, the height is counted by the number of edges that are in between the nodes instead of the nodes themselves. Using this method, the height will be ```n-1``` where ```n``` is the number of nodes, in the path from the root to the lowest leaf.

The maximum height of the given binary tree in the visual below is ```3```.
Alternatively, if we were counting by edges, instead of nodes, it would be ```2```.
> The number of edges in a tree are ```n-1```, where ```n``` is the number of nodes.


## 5. Depth
Depth of a binary tree node is measured from itself all the way up to the root. As observed in the visual below, the depth at the root node is ```1```, with it increasing as we go down. Measure depth at a given node by looking at how many nodes are above it, including the node itself.

<img width="648" alt="Screen Shot 2023-07-08 at 13 24 29" src="https://github.com/Alisherka7/daily_challenge_algorithm/assets/38793933/bc68d0dc-0ed0-464e-aa3a-739c87323211">

## 6. Ancestor
A node connected to all of the nodes below it is considered an ancestor to those nodes.

## 6. Descendent
The descendent of a node is eighter child of the node or child of some other descendent of the node.

<img width="652" alt="Screen Shot 2023-07-08 at 13 25 43" src="https://github.com/Alisherka7/daily_challenge_algorithm/assets/38793933/472416da-59ae-4c83-984e-3b547254fb29">
