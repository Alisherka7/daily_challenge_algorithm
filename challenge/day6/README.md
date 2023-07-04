# Day 6 - Merge Sort

### Related Leetcode problem
1. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day5/BaseballGame.java">Sort an Array - Medium</a>
2. <a href="https://github.com/Alisherka7/daily_challange_algorithm/blob/main/challenge/day5/MinStack.java">Merge K Sorted Lists - Hard</a>


## Merge Sort

The concept behind merge sort is very simple. Keep splitting the array into halves until the subarrays hit a size of one, sort them, and merge the sorted arrays, which will result in an ultimate sorted array. You might have figured out that this sounds exactly like the fibonacci sequence using recursion, and you would be right! 

Let's take an array of size 5 as an example, ```[3,2,1,4,1,6]``` Our job is to make sure that we sort this in an increasing, or non-decreasing order if we had duplicates. 

<img width="584" alt="Screen Shot 2023-07-04 at 21 32 42" src="https://github.com/Alisherka7/Baekjoon/assets/38793933/89e37456-1275-421f-a1ac-5509e4671ae0">

As observed, we have two branches. Let's work on sorting and merging the left branch first. The work required here is that we will have to hit the base case first, after which we can begin sorting and merging the arrays together, achieving ```[2,3,4]``` as a result. Once our recursion reaches the base case, we have two subarrays, ```[3]``` and ```[2]```. We need a way to compare these two elemets to know where to put them in their original subarray, which is ```[3,2]```. For this, copies of both the subarrays is created and using two-pointers, values are compared and put in the original subarray in the sorted order. 

```java
public static int[] mergetSort(int[] arr, int l, int r){
    // array, starting index of array, last index of array 
    if(l<r){
        // Find the middle point of arr
        int m = (l + r)/2;
        mergeSort(arr, l, m); // sort left half
        mergeSort(arr, m+1, r); // sort right half
        merge(err, l, m, r); // merge sorted halfs
    }
    return arr;
}
```

## Visualization and Pseudocode
### The ```mergeSort()``` recursive call

As we learned with two branch recursion, we solve both the branches and ```piece``` back together the solutions to the subproblems to arrive at the ultimate solution. Once we have the subarray ```[3,2]``` sorted to ```[2,3]``` - this is the ```mergeSort(arr, s, m)``` part. Now, we can move on to sorting the ```[4]```, which corresponds to the ```mergeSort(arr, m + 1, e)```. It is important to note the sequence in which the calls are exectued. The ```merge()``` call will not be exectued until both the recursive ```mergeSort()``` calls have returned for the current subarray.

<img width="767" alt="Screen Shot 2023-07-04 at 21 56 34" src="https://github.com/Alisherka7/Baekjoon/assets/38793933/75392df4-710d-44ca-b096-525026af228c">

## The ```merge()``` function and three pointers

As observed in the visual above, we have three pointers, ```k, j``` and ```i```.

* ```k``` - keeps track of where the next element in ```arr``` needs to be placed
* ```i``` points to the element in the ```leftSubarray``` that is currently being compared to the ```j``` element in the ```rightSubarray```.
* One of ```i``` or ```j``` will increment depending on which element in smaller.
* ```k``` will increment regardless because ```arr``` will have an element placed inside of it regardless of which one of ```i``` or ```j``` increments.

This is clear in the visual above and demonstrated in the ```merge()``` function pseudocode below.

```java
// Merges two subarrays of arra[]
// First subarray is arr[l..m]
// Second subarray is arr[m+1..r]

public static void merge(int[] arr, int l, int m, int r){
    // Find lengths of two subarrays to be merged
    int length1 = m - l + 1;
    int length2 = r - m;

    // Create temp arrays
    int L[] = new int[length1];
    int R[] = new int[length2];

    // Copy the sorted left & right halfs to temp arrays
    for(int i =0; i<legnth1; i++){
        L[i] = arr[l+i];
    }

    for(int j =0; j<length2; j++){
        R[j] = arr[m+1+j];
    }

    // Initial indexes of left and right subarrays
    int i = 0; // index for left
    int j = 0; // index for right
    int k = l; // Initial index of merged subarray array

    // Merge the two sorted halfs into the original array
    while(i < length1){
        arr[k] = L[i];
        i++;
        k++;
    }

    // Copy remaining elements of R[] if any
    while(j < length2){
        arr[k] = R[j];
        j++;
        k++;
    }
}
```


## Time complexity

Merge Sort runs in ```O(n log n)```.
Recall from the fibonacci example when we kept splitting each sub-problem into two other sub-problems. We have a similar case here because our recursive tree is a tree with branching-factor of 2, except we are going the opposite direction. if ```n``` is the length of our array at any given level, our subarrays in the next level have a length ```n/2```.

**For example ** we go from ```n = 4``` to ```n = 2``` to ```n = 1``` which is the base case. The question here is how many times can we divide ```n``` by ```2``` until we hit the base case.
This would look like ```n/2x``` where ```x``` is the number of times we need to divide ```n``` by two until we get to one.

<img width="689" alt="Screen Shot 2023-07-04 at 22 10 04" src="https://github.com/Alisherka7/Baekjoon/assets/38793933/7ae4433d-c176-4a28-8246-f6f77f1c46fd">

## Stability

Merge Sort proves to be a stable algorithm because if we have a pair of duplicates, say, ```7```, the ```7``` in the left subarray will always end up in the merged array first followed by the ```7``` in the right subarrays. This is because when we compare the ```ith``` element in the left subarray to the ```jth``` element in the right subarray for equality, we pick the one in the left subarray, maintaining the relative order.

```java
if(leftSubarray[i] <= rightSubarray[j]){
    arr[k] = leftSubarray[i];
    i+=1;
}
```