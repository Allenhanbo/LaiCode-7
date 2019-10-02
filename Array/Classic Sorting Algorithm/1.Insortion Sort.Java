
/*
Given an array of integers, sort the elements in the array in ascending order. The insertion sort algorithm should be used to solve this problem.

Examples

{1, 2, 3} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
Corner Cases

What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.
*/


public class Solution {
  public int[] sort(int[] array) {
    // Write your solution here
    // int[] result = new int[array.length];
    for(int i = 0; i < array.length; i++) {
      for(int j = i; j > 0; j--) {
        if(array[j] < array[j - 1]) {
          int temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
        }
      }
    }
    return array;
  }
}