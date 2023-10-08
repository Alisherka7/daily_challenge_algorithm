# Solution:

### 1. Approach 1: Two Pointers

An intiuitive method is to use two pointers to iterate over both strings. Assume we have two pointers, `i` and `j`, with `i` pointing to the first letter of `word1` and `j` pointing to the first letter of `word2`. We also create an empty string `res` to store the outcome.

We append the letter pointed to by pointer `i` i.e, `word1[i]`, and increment `i` by `1` to point to the next letter of `word1`. Because we need to add the letters in alternation order, next we append `word2[j]` to `result`. We also increase `j` by `1`.

We continue iterating over the given strings until both are exhausted. We stop appending letters from `word1` when `i` reaches the end of `word1`, and we stop appending letters from `word2` when `j` reaches the end of `word2`.

### Implementation

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        while (i < m || j < n) {
            if (i < m) {
                result.append(word1.charAt(i++));
            }
            if (j < n) {
                result.append(word2.charAt(j++));
            }
        }

        return result.toString();
    }
}
```

### Complexity Analysis
Here, `m` is the length of `word1` and `n` is the length of `word2`.
* Time Complexity: **O(m + n)** - We iterate over `word1` and `word2` once and push their letters into `result`.
* Space Complexity: **O(1)** - Without considering the space consumed by the input strins (`word1` and `word2) and the output string (`result`), we do not use more than constant space.


# Approach 2: One Pointer
### Intuition
To merge the given words, we can also use a single pointer.

Let `i` be the pointer that we'll use. We begin with `i=0` and progress to the size of the longer wrod between `word1` and `word2`, till -> = `i = max (word1.length(), word2.length())`

As we progress to teh size of a longer word, we check each time if `i` points to an index that is in bounds of the words or not.

### Implementation

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Math.max(m, n); i++) {
            if (i < m) {
                result.append(word1.charAt(i));
            }
            if (i < n) {
                result.append(word2.charAt(i));
            }
        }

        return result.toString();
    }
}
```
### Time complexity
Here, `m` is the length of `word1` and `n` is the length of `word2` 
* Time Complexity: **O(m + n)**
* Space Complexity: **O(n)** for java and python 
