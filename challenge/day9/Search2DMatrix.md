# Approach
The matrix has the following properties:

1. Each row is sorted in ascending order.
2. The first element of each row is greater than the last element of the previous row.

The code uses a binary search approach to solve the problem efficiently. Here's a brief explanation of the approach:

1. Initialize the ```leftRow``` and ```rightRow``` pointers to the first and last row indices of the matrix, respectively.
2. While leftRow is less than or equal to ```rightRow```, perform the following steps:
* Calculate the ```middle``` row index mid using the formula ```mid = leftRow + (rightRow - leftRow) / 2```
* Check if the target value falls within the range of values in the middle row using the conditions ```matrix[mid][0] <= target and matrix[mid][matrix[mid].length-1] >= target```.
* If the ```target``` is within the range, call the check method passing the ```middle``` row and the target value to perform a binary search within that row.
* If the ```target``` is found in the row, ```return true```.
* If the target is smaller than the range, update ```rightRow``` to ```mid - 1``` to search in the upper half of the matrix.
* If the ```target``` is larger than the range, update ```leftRow``` to ```mid + 1``` to search in the lower half of the matrix.
3. If the target is not found in any row, ```return false```.
The ```check``` method performs a binary search within a given row to find the target value. It follows a similar binary search approach as described above, but applied to a 1D array. It returns ```true``` if the ```target``` value is found in the row, and ```false``` otherwise.

# Complexity
- Time complexity: O(log(mn))
- Space complexity: O(1)

# Code
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int mid;
        int leftRow = 0;
        int rightRow = matrix.length -1;
        while(leftRow <= rightRow){
            mid = leftRow + (rightRow - leftRow) / 2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length-1] >= target){
                return check(matrix[mid], target);
            }
            else if(matrix[mid][0] > target && matrix[mid][matrix[mid].length-1] > target){
                rightRow = mid - 1;
            }else{
                leftRow = mid + 1;
            }
        }
        return false;
    }

    public boolean check(int[] matrix, int target){
        int mid;
        int left = 0;
        int right = matrix.length -1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(target == matrix[mid]){
                return true;
            }else if(target > matrix[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
```