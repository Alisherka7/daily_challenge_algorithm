# Day11 - BST Insert and Remove 

## Insertion
If we wish to insert a new node into the BST, we first have to traverse the BST to find the right position, and then insert this node.

If we have a BST ```[4]```, and wich to insert ```6```, we could either end up with ```[4,null,6]``` or ```[6,4,null]```. Both of these would be valid BSTs. In the first example, we added the ```6``` as a leaf node, which is an easier process than the second example.

Let's add ```5``` to previously resulting tree ```[4,null,6]```, which results in ```[4,null,6,5,null]```.

```java
// Insert a new node and return the root of the BST.
public TreeNode insert(TreeNode root, int val){
    if(root == null){
        return new TreeNode(val);
    }

    if(val > root.val){
        root.right = insert(root.right, val);
    }else if(val < root.val){
        root.left = insert(root.left, val);
    }
    return root;
}
```

<img width="680" alt="Screen Shot 2023-07-09 at 19 18 08" src="https://github.com/Alisherka7/daily_challenge_algorithm/assets/38793933/625f3dbb-1208-4c23-a48b-d2bdc6d456fc">

The visual above demonstrates how insertion is done. ```6``` is greater than the root node, so it ends up in the right sub-tree. ```5``` is greater than the root node but smaller than ```6``` so it ends up in the left subtree of the tree rooted at ```6```.

<hr>

## Removal
Before removing a node from a BST, we need to consider two cases:
1. The target node has 0 or 1 child
2. The target node has 2 children

## Case 1 - The target node has one child or no children
If we wish to delete node ```2```, which has no children, the ```left_child``` pointer of ```3``` now points to ```null```.

<img width="689" alt="Screen Shot 2023-07-09 at 19 30 08" src="https://github.com/Alisherka7/daily_challenge_algorithm/assets/38793933/c8e579e9-826b-46b8-872a-bb1365c5c08f">

If we wish to delete node ```3```, which has one child, the ```left_child``` pointer of the root node will point to ```2``` instead of ```3```.

<img width="685" alt="Screen Shot 2023-07-09 at 19 30 59" src="https://github.com/Alisherka7/daily_challenge_algorithm/assets/38793933/d81237be-3cb1-4562-ba73-424af3509b7f">


## Case 2 - The target node has two children
If we wanted to delete a node with two children, say, ```6```, we replace the node with its in-order successor.

The in-order successor is the left-most node in the right subtree of the target node. Another way of looking at it is that it is the smallest node among all the nodes that are greater than the target node. This will ensure that the resulting tree is still a vali binary search tree.

The visual below shows process of deletion of nodes with two children.

<img width="680" alt="Screen Shot 2023-07-09 at 19 33 32" src="https://github.com/Alisherka7/daily_challenge_algorithm/assets/38793933/46731df1-dd23-4ea8-9890-5ed3021bdf71">

```java

// Return the minimum value node of the BST.
public TreeNode minValueNode(TreeNode root){
    TreeNode curr = root;
    while(curr != null && curr.left != null){
        curr = curr.left;
    }
    return curr;
}

// Remove a node and return the root of the BST.
public TreeNode remove(TreeNode root, int val){
    if(root == null){
        return null;
    }

    if(val > root.val){
        root.right = remove(root.right, val);
    }else if(val < root.val){
        root.left = remove(root.left, val);
    }else{
        if(root.left == null){
            return root.right;
        }else if(root.right == null){
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                TreeNode minNode = minValueNode(root.right);
                root.val = minNode.val;
                root.right = remove(root.right, minNode.val);
            }
        }
    }
    return root;
}
```

## Time Complexity
If the given tree is a balanced binary tree, the height will be in ```log n```, for reasons that are very similar to what we discussed in merge sort. However, it is a possibility that in the worst case, the tree provided is either left-skewed or right-skewed. In that case, the height of the tree tree will be in ```O(n)``` and the total work done for all the operations described anove is ```O(n)```.

