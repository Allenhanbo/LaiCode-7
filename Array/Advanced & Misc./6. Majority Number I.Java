
/*
Given an integer array of length L, find the number that occurs more than 0.5 * L times.

Assumptions

The given array is not null or empty
It is guaranteed there exists such a majority number
Examples

A = {1, 2, 1, 2, 1}, return 1
*/



public class Solution {
  public int majority(int[] array) {
    // Write your solution here
    if(array.length == 1) {
      return array[0];
    }
    int result = array[0];
    int count = 1;
    for(int i = 1; i < array.length; i++) {
      if(array[i] == result) {
        count++;
      }
      else {
        count--;
        if(count < 0) {
          result = array[i];
          count = 1;
        }
      }
    }
    return result;
  }
}

