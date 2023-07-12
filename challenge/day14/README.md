# Day 14 - BST Sets and Maps

Sets and Maps, similar to stacks and queues, rae interfaces that can be implemented using trees. Implemeting them with trees allows for a ```O(log n)``` time for operations.

<hr>

## Sets
Imagine we have a phone book with three names - ```Alice, Brad, Collin```. We could store these during dynamic arrays but a set ensures that we have unique values in our data strcutrue, and implementing it using a tree ensures that our keys are sorted alphabetically.

## Maps

A map on the other hand operates on key-value pairs. Going back to our phone book example, not only can we store names, but also map them to thier phone numbers. Again, the  data structure is sorted by the key. Because the key maps to a value, we can find all of the information associated with a key. The value here doesn't have to be phone number, it cal also be an object, etc.
```{'Alice' : 123, 'Brad' : 434, 'Collin' : 331}```

## Implementation in different languages
Java and C++ have built-in TreeMap data structures, but with Python and JavaScript, an external library is required to be imported.

### Python
```python
from sortedcontainers import SortDict
treemap = SortedDict({'c':3, 'a':1, 'b':2})
```

### Java
```java
TreeMap<String, String> treeMap = new TreeMap<String, String>();
```

### JavaScript

```js
const TreeMap = require("treemap-js");
let map = new TreeMap();
```

### C++

```cpp
map<string, string> treeMap;
```

Trees are just one way of implementing sets and maps. You can even use hashing to implement these interfaces. We shall talk aboute hashing in the upcoming chapters. TreeMaps are also not super common in interviews but if your language of choice is Python or JavaScript that does not have a built-in Treemap, it is unlikely that your interviewer asks you to implement it from scratch.