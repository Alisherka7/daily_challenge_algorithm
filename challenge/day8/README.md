# Day 8 - Bucket Sort

### Related Leetcode problem
1. <a href="https://leetcode.com/problems/sort-colors/">Sort Colors - MEDIUM</a>

Bucket sort is not as popular or widely used as the previous algorithms we have covered. Bucket sort works well when the dataset to be sorted has value **within a specific range**

<hr>

## Concept

Imagine we have an array of size ```6``` and it contains value of an inclusive range of ```0-2```. The idea begind bucket sort is to craete a ```bucket``` for each one of the numbers and map them to their respective buckets.

There will be a bucket for ```0,1```, and ```2```. This bucket, which is just a position in a specified array will contain the frequencies of each one of the values within the range. For the sake of this example, we only have three values and accrodingly we will have three buckets.

>The term bucket will really just translate into a position in an array where we will map these frequencies.

Once each one of the buckets is filled with the frequency of each one of the values, we will overwrite all the values in the original array such that they end up in the sorted order.

```java
public static int[] bucketSort(int[] arr){
    // Assuming arr only contains, 0,1 or 2
    int[] count = {0,0,0};

    // Count the quantity of each val in arr
    for(int num : arr){
        counts[num] += 1;
    }

    // Fill each bucket in the original array
    int i =0;
    for(int n =0; i<counts.length; n++){
        for(int j =0; j<counts[n]; j++){
            arr[i] = n;
            i++;
        }
    }
    return arr;
}
```

The first part of the pseudocode, right before we do ```i=0```, corresponds to filling up each one of the buckets. 

```java
// Fill each bucket in the original array
int i =0;
for(int n =0; n<counts.length; n++){
    for(int j =0; j<counts[n]; j++){
        arr[i] = n;
        i++;
    }
}
```

* The ```i``` pinter will keep track of the next insertion position for our original array, ```arr```.
* The ```n``` pointer keeps track of the current position of the ```counts``` array.
* The ```j``` pointer keeps track of the number of times that ```counts[n]``` has appeared.

So, knowing that, we have our ```counts``` array which is ```[2,1,3]```. And our original input array is ```[2,1,2,0,0,2]```.
At the first iteration, ```n=0```, which corresponds to ```2``` in ```counts```.  Our inner loop will run two times, overwriting ```arr[0]``` and ```arr[1]``` to be ```0``` in an adjacent manner will result in them being sorted. This process will continue for each number and the ultimate state of ```arr``` will be ```[0,0,1,2,2,2]``` which is the ultimate goal.

<img width="642" alt="Screen Shot 2023-07-06 at 23 28 25" src="https://github.com/Alisherka7/Baekjoon/assets/38793933/2fc28d1a-2693-4c60-a17f-930b4d36e56f">

<hr>


## Time Complexity 
The first for loop will run ```n``` times where ```n``` is the length of the ```counts``` array. However, the inner loop will only run until ```counts[n]```, which is a different everytime. The first time it will be ```2```, then ```1``` and then ```3```. Therefore, our algorithm belongs to ```O(n)```.


<table>
<tr>
<th>Algorithm</th>
<th>Big-O time complexity</th>
</tr>
<tr>
<td>Insertion Sort</td>
<td>O(n^2)</td>
</tr>
<tr>
<td>Merge Sort</td>
<td>O(n log n)</td>
</tr>
<tr>
<td>Quick Sort</td>
<td>O(n log n)</td>
</tr>
<tr>
<td>Bucket Sort</td>
<td>O(n)</td>
</tr>
</table>