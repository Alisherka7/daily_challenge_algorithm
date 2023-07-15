# Day 17 - Hashing

### Related Leetcode problem
1. <a href="https://leetcode.com/problems/contains-duplicate/">Contains Duplicate - EASY</a>
2. <a href="https://leetcode.com/problems/two-sum/">Two sum - EASY</a>
3. <a href="https://leetcode.com/problems/lru-cache/">LRU Cache - MEDIUM</a>



## Hash Usage
Hash maps are probably one of the most useful data structures/concepts for coding interviews.
They are also extremely ubiquitous in interviews. When questions ask "unique, count, frequency", take hash maps out your arsenal.

Recall that the defference between a set and map is that in sets do not map their keys to anything, whereas maps have key-value pairs.

<hr>

# Motivation
Let's start off by comparing hash maps to tree maps and sorted arrays and understand what trade-offs we make using each data structure.

<table>
<tr>
<th>Operation</th>
<th>TreeMap</th>
<th>HashMap</th>
<th>Array</th>
</tr>
<tr>
<td>Insert</td>
<td>O(log n)</td>
<td>O(1)</td>
<td>O(n)</td>
</tr>
<tr>
<td>Remove</td>
<td>O(log n)</td>
<td>O(1)</td>
<td>O(n)</td>
</tr>
<tr>
<td>Search</td>
<td>O(log n)</td>
<td>O(1)</td>
<td>O(log n), if sorted</td>
</tr>
<tr>
<td>Inorder Traversal</td>
<td>O(n)</td>
<td>-</td>
<td>-</td>
</tr>
</table>

## Tree Maps vs Hash Maps
The downside of hash maps in that they are not ordered, so there is no garantee that the map will store that values in set positions like BST's or arrays do. If you were to iterate through all the keys, you would first need to sort them and then traverse, which will run in o(n log n)time. 

Because hashmaps don't allow duplicates and have key-value pairs, we cna use them to count frequency of keys. Going back to our phonebook example, we can count the number of times a given name appears in our phonebook by mapping the name to its frequency.

Given the array below, we can add all the elements into a hash map as keys. Because hash maps do not allow publicates, we can use this to our advantage. If a name already exists in our hash map as the key and we encounter it again in our array, we can just increment its value by 1. If t he name does not exist, we can add it to our hash map and set the frequency to 1.

```["alice", "brad", "collin", "brad", "dylan", "kim]```
<table>
<tr>
<th>Operation</th>
<th>TreeMap</th>
</tr>
<tr>
<td>Alice</td>
<td>1</td>
</tr>
<tr>
<td>Brad</td>
<td>2</td>
</tr>
<tr>
<td>Collin</td>
<td>1</td>
</tr>
<tr>
<td>Dylan</td>
<td>1</td>
</tr>
<tr>
<td>Kim</td>
<td>1</td>
</tr>
</table>

The following code demonstrates how the above operation will execute.

```java
String[] names = {"alice", "brad", "collin", "brad", "dylan", "kim";
HashMap<String, Integer> countMap = new HashMap<>();

for(String name : names){
    if(!countMap.containsKey(name)){
        countMap.put(name, 1);
    }else{
        countMap.put(name, countMap.get(name) + 1);
    }
}

System.out.println(countMap);
```

The above algorithm, when implemented using a hash map, is more efficient than using a tree map. With a tree map, the insertion operation wuold cost ```O(log n)``` time and if ```n``` is the size of the array, it would total to ```O(n log n)``` time. This only costs ```O(n)``` in the case of a hashmap.
