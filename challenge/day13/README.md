# Day 13 - BFS (Breadth-Fist Search)

## Concept 
In depth-first search, we prioritized depth. For breath-frist search, we prioritize breadth. We focus visiting all the node on one level before moving on to the next level.

Generally, breadth-first search is implemented iteratively and that is the implementation we will be covering in this course. You can write it recursively but it is a lot more challenging.

BFS makes use of a ```queue data structure```, more specifically, a deque, allowing us to remove elements both from the head and the tail in ```O(1)``` time. This will make sense soon.

```java
public void bfs(TreeNode root){
    Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
    if(root != null){
        queue.add(root);
    }
    int level = 0;
    while(!queue.isEmpty()){
        System.out.println("Level " + level + ": ");
        int levelLength = queue.size();
        for(int i =0; i<levelLength; i++){
            TreeNode curr = queue.removeFirst();
            System.out.println(curr.val + " ");
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }
        level++;
        System.out.println();
    }
}
```

Let's take an example of a binary tree, ```[4,3,6,2,null,5,7]``` and apply the BFS algorithm. Remember, our goal is to visit all the nodes on one level before moving to the next.

If we append our ```root``` node to our queue and loop through the queue such that at any given time, our queueu only holds the nodes on a certain level, we will ensure that we visit the levels in order and that we don't mix up the levels either. THis is exactly what the code inside of the while loop achieves. As long as our queue is not empty, we remove the node's that is present in our queue and add its children to the queue (which would be the next level). Therefore, when we remove ```root```, we add its children, which are ```3,6``` to the queue. Next, we remove ```3``` and add its child ```2```. We than remove ```6``` and add ```5,7``` to the queue. Because of the ```FIFO``` nature of a queue, we ensure that we visit the nodes from left to right.

Our queue becomes empty once we have visited all of the nodes.


<img width="782" alt="Screen Shot 2023-07-11 at 22 44 39" src="https://github.com/Alisherka7/daily_challenge_algorithm/assets/38793933/b29b9edd-06a9-4ea3-9b53-75e45cb84e61">

## Time Complexity
Technically, the total work done is ```c * n``` where ```n``` is the number of nodes in the tree and ```c``` is the amount of work we perform at each node. We performed a total of three opreations per node printing the node, appending the node, and removing it. This is what the ```c``` represents. For the case of asymptotic analysis, we can drop this constant, meaning the algorithms belongs to ```O(n)```.