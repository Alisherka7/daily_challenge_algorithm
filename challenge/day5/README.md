# Stacks

### Related Leetcode problem
1. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day5/BaseballGame.java">Baseball Game - EASY</a>
2. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day5/ValidParentheses.java">Valid Parentheses - EASY</a>
3. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day5/MinStack.java">Min Stack - Medium</a>

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

<img width="634" alt="Screen Shot 2023-07-03 at 19 33 30" src="https://github.com/Alisherka7/daily_challange_algorithm/assets/38793933/ddcd299d-d64c-4cbc-bd47-4caded40e6e8">


## Pop

Pop operation removes the last element from top of the stack, which in dynamic array termis would be retrieving the last element. This is also an efficient ```O(1)```

```java
public int pop(){
    return stack.remove(stack.size() - 1);
}
```
<img width="608" alt="Screen Shot 2023-07-03 at 19 35 06" src="https://github.com/Alisherka7/daily_challange_algorithm/assets/38793933/d44584db-4f14-4e12-8362-462522f941e0">

> In most languages, before popping, it is a good measure to check if the stack is empty to avoid errors.

## Peek 
Peek is the simples of three. It just returns, without removing, the top most elements.

```java
public int peek(){
    return stack.get(stack.size() - 1);
}
```
<hr>


## Big-O time complexity

<table>
<tr>
<th>Operation</th>
<th>Big-O time complexity</th>
</tr>
<tr>
<td>Push</td>
<td>O(1)</td>
</tr>
<tr>
<td>Pop</td>
<td>O(1)</td>
</tr>
<tr>
<td>Peek/Top</td>
<td>O(1)</td>
</tr>
</table>
