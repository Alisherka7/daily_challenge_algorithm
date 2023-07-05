# Day 7 - Quick Sort
The idea begind quick sort is to pick an index, which is called the ```pivot```, and partition the array such that every value to the left is less than or equal to the ```pivot``` and every value to the right is greather than the pivot.

## Picking a pivot value
Generally, there are several tested and tried options when it comes to picking a pivot:
* Pick the first index
* Pick the last index
* Pick the median (pick the first, last, and middle value and find their median and perform the split at the median)
* Pick a random pivot

You may be asking which pivot to pick? This is dependent on the data itselft, both the size and the initial order. For coding interviews we can keep things simple, so in this chapter we will use the last index as our pivot.

## Implementation

We will pick a ```pivot``` if we haven't already hit the base case which is array of size ```1``` and pick a ```left``` pinter, which will point to the left-most element of the current subarray to begin with. Then, we will iterate through our array and if we find an element smaller than our ```pivot``` element, we will swap the current element with the element at our ```left``` pointer and incremenet the ```left``` pointer.
