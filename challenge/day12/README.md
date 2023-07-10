# Day 12 - DFS (Depth-First Search)

Depth First Search (DFS) is a way of traversing binary search trees that prioritizes depth rather than breadth.

The idea is to keep traversing down either the ```left subtree``` or the ```right subtree``` until there are no more nodes left. There are various methods under which depth-first search is performed. These methods visit the nodes - ```root, left_child, right_child``` in different orders. THese tree methods are:
1. Inorder
2. Preorder
3. Postorder

Depth first search is best implemented using recursion. Again, you could use a stack and do it iteratively but it is a lot more complicated.

Take a tree with the nodes ```[4,3,6,2,null,5,7]``` going from left to right.

<hr>

## Inorder Traversal

An inorder traversal prioritizing left before right will visit the ```left-child``` first, then the parent node and then the ```right-child```. Inorder traversal will result in the nodes being visited in a sorted order.

```java
public void inorder(TreeNode root){
    if(root == null){
        return;
    }
    inorder(root.left);
    System.out.println(root.val);
    inorder(root.right);
}
```

The order in which these nodes will be visited is ```[2,3,4,5,6,7]```, which is sorted. It is important to note that this only works when left is prioritized before right. If we prioritizie right before left, we will end up with a reverse sorted array.

> The reason the nodes will print in a sorted order is because of the BST property. Since we know all values to the left of a node are smaller, this means we won't hit our base case until we reach the left-most node which is also the smallest node. After visiting this, we will traverse up, visit the parent and then visit the right-subtree. The visual below shows this process.

The order in which the nodes are visited is represented by the numbers in blue next to the node

<img width="514" alt="Screen Shot 2023-07-10 at 22 16 48" src="https://github.com/Alisherka7/daily_challenge_algorithm/assets/38793933/f542f931-556f-49c6-825b-d4625b8d7999">


## Preorder Traversal

A preorder traversal prioritizing left before right will visit the parent, the left-child and the right-child, in that order.

```java
public void preorder(TreeNode root){
    if(root == null){
        return;
    }

    System.out.println(root.val);
    preorder(root.left);
    preorder(root.right);
}
```

The nodes are visited in the following order ```[4,3,2,6,5,7]```

<img width="521" alt="Screen Shot 2023-07-10 at 22 37 24" src="https://github.com/Alisherka7/daily_challenge_algorithm/assets/38793933/129d5f61-645f-4a32-9282-7cc2163ba72b">

## Postorder Traversal

A post-order traversal prioritizing left before right will visit the ```left_child```, the ```right_child``` and the parent, int that order.

```java
public void postorder(TreeNode root){
    if(root == null){
        return;
    }

    postorder(root.left);
    postorder(root.right);
    System.out.println(root.val);
}
```

The order in which these nodes will be visited is: ```[2,3,5,7,6,4]```


<img width="525" alt="Screen Shot 2023-07-10 at 22 39 21" src="https://github.com/Alisherka7/daily_challenge_algorithm/assets/38793933/431b0883-0ef1-462f-ac7b-c227add562f8">

<hr>

## Time Space Complexity

We know that we have to visit every node in the tree, and if there are ```n``` nodes in the tree, the algorithm will run in ```O(n)```.
Another interesting point is that we could actually sort an array by making use of a binary tree. First, we would need to building the tree and insert each value. We know that there are ```n``` values and inserting a value in the binary tree takes ```log n``` time. Therefore, the whole process of building the tree will be ```O(n log n)```. Traversing the tree will only take ```n``` steps, so in total it will be ```O(n + n log n)```.

We have mentioned before that we do not take ocnstants into consideration. We also know that ```O(n log n)``` will grow faster than ```O(n)```, so we can set our upper bound to ```O(n log n)```.


