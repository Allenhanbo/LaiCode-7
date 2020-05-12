
/*
Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest rectangular area that can be formed in the histogram.

Assumptions

The given array is not null or empty
Examples

{ 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9(starting from index 2 and ending at index 4)
*/


public class Solution {
  public int largest(int[] array) {
    // Write your solution here
    // Method 1: start from any index, go left and go right
    if(array.length == 1) {
      return array[0];
    }
    int globalMax = Integer.MIN_VALUE;
    for(int i = 0; i < array.length; i++) {
      int left = i;
      int right = i;
      int height = array[i];
      int leftHeight = array[i];
      int rightHeight = array[i];
      int area = array[i];
      int localMax = array[i];
      while(left >= 0 || right < array.length) {
        if(left >= 0) {
          leftHeight = Math.min(leftHeight, array[left]);
          area = (i - left + 1) * leftHeight;
          localMax = Math.max(localMax, area);
        }
        if(right < array.length) {
          rightHeight = Math.min(rightHeight, array[right]);
          area = (right - i + 1) * rightHeight;
          localMax = Math.max(localMax, area);
        }
        if(left >= 0 && right < array.length) {
          height = Math.min(leftHeight, rightHeight);
          area = (right - left + 1) * height;
          localMax = Math.max(localMax, area);
        }
        left -= 1;
        right += 1;
      }
      globalMax = Math.max(globalMax, localMax);
    }
    return globalMax;
  }
}






