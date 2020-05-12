
/*
Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.

Assumptions

The given array is not null
Examples

{ 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)
*/


// method 1: 每个节点左边找最大，右边找最大，然后计算当前节点的值
// time complexity: O(n^2)
public class Solution {
  public int maxTrapped(int[] array) {
    // Write your solution here
    if(array.length <= 2) {
      return 0;
    }
    int sum = 0;
    for(int i = 0; i < array.length; i++) {
      int left = i - 1;
      int right = i + 1;
      int leftHeight = array[i];
      int rightHeight = array[i];
      while(left >= 0) {
        leftHeight = Math.max(leftHeight, array[left]);
        left--;
      }
      while(right < array.length) {
        rightHeight = Math.max(rightHeight, array[right]);
        right++;
      }
      if(leftHeight > array[i] && rightHeight > array[i]) {
        int height = Math.min(leftHeight, rightHeight);
        sum += height - array[i];
      }
    }
    return sum;
  }
}


// method 2: 用DP的方法先找到左右最大最小高度，然后去小值计算当前储水量
// time compelxity: O(n); space complexity: O(n)
public class Solution {
  public int maxTrapped(int[] array) {
    // Write your solution here
    if(array.length <= 2) {
      return 0;
    }
    int[] maxHeightLeft = new int[array.length];
    int[] maxHeightRight = new int[array.length];
    maxHeightLeft[0] = array[0];
    for(int i = 1; i < array.length; i++) {
      maxHeightLeft[i] = Math.max(maxHeightLeft[i - 1], array[i]);
    }
    maxHeightRight[array.length - 1] = array[array.length - 1];
    for(int i = array.length - 2; i >= 0; i--) {
      maxHeightRight[i] = Math.max(maxHeightRight[i + 1], array[i]);
    }
    int sum = 0;
    for(int i = 1; i < array.length - 1; i++) {
      sum += Math.min(maxHeightLeft[i], maxHeightRight[i]) - array[i];
    }
    return sum;
  }
}




