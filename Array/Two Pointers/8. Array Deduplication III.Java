
/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value do not keep any of them. Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1}
*/

public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    if(array.length < 2) {
      return array;
    }
    //slow: the numbers to the left hand side of slow should be return
    //fast1: point to the first duplicate number
    //fast2: the current pointer
    int slow = 0;
    int fast1 = 0;
    int fast2 = 0;
    while(fast2 < array.length) {
      fast1 = fast2;
      while(fast2 < array.length && array[fast1] == array[fast2]){
        fast2++;
      }
      if(fast2 - fast1 > 1){
        fast1 = fast2;
      }
      else {
        array[slow++] = array[fast1];
      }
    }
    return Arrays.copyOf(array, slow);
  }
}





