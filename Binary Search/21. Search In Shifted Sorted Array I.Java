
/*
Given a target integer T and an integer array A, A is sorted in ascending order first, then shifted by an arbitrary number of positions.

For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such that A[i] == T or return -1 if there is no such index.

Assumptions

There are no duplicate elements in the array.
Examples

A = {3, 4, 5, 1, 2}, T = 4, return 1
A = {1, 2, 3, 4, 5}, T = 4, return 3
A = {3, 5, 6, 1, 2}, T = 4, return -1
Corner Cases

What if A is null or A is of zero length? We should return -1 in this case.
*/


public class Solution {
  public int search(int[] array, int target) {
    // A = {3, 4, 5, 1, 2}, T = 4
    if(array == null || array.length == 0) {
      return -1;
    }
    return searchHelper(array, target, 0, array.length - 1);
  }

  public int searchHelper(int[] array, int target, int left, int right) {
    // base case
    if(left > right) {
      return -1;
    }
    int mid = left + (right - left) / 2;
    if(array[mid] == target) {
      return mid;
    }
    else if(array[left] == target) {
      return left;
    }
    else if(array[right] == target) {
      return right;
    }
    // left part is sorted
    else if(array[left] < array[mid]) {
      if(target >= array[left] && target < array[mid]) {
        return binarySearch(array, target, left, mid - 1);
      }
      // target in right part
      else {
        return searchHelper(array, target, mid + 1, right);
      }
    }
    // right part is sorted
    else {
      if(target > array[mid] && target <= array[right]) {
        return binarySearch(array, target, mid + 1, right);
      }
      // target in left part
      else {
        return searchHelper(array, target, left, mid - 1);
      }
    }
  }

  public int binarySearch(int[] array, int target, int left, int right) {
    while(left <= right) {
      int mid = left + (right - left)/2;
      if(array[mid] == target) {
        return mid;
      }
      else if(array[mid] < target) {
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }
    return -1;
  }
}


