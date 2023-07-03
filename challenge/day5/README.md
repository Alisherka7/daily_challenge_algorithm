# Stacks

### Related Leetcode problem
1. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day3/NumberOfStudentsUnableToEat.md">Baseball Game - EASY</a>
2. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day3/ImplementStackUsingQueue.md">Valid Parentheses - EASY</a>
3. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day3/ImplementStackUsingQueue.md">Min Stack - Medium</a>

A stack is a data structure that contains a collection of elements where you can add and delete elements from just one end (called the top of the stack).
<br>
Stacks are a dynamic data structure that operate on a LIFO (Last In First Out) manner. The last element placed inside in the first element that come out. The stack supports three operations - ```push```, ```pop```, ```peek```.

## Push
Push opeartion adds and element to the top of the stack, which is dynamic array terms would be appeanding an element to the end. This is and efficient ```O(1) ```



```java
public void push(int n){
    stack.add(n);
}
```



<hr>