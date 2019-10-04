
/*
Given an array of integers, move all the 0s to the right end of the array.

The relative order of the elements in the original array need to be maintained.

Assumptions:

The given array is not null.
Examples:

{1} --> {1}
{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
*/

public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here
    if(array.length <= 1){
      return array;
    }
    int i = 0; 
    int j = 0;
    while(j < array.length) {
      if(array[j] == 0) {
        j++;
      }
      else {
        array[i++] = array[j++];
      }
    }
    while(i < array.length) {
      array[i++] = 0;
    }
    return array;
  }
}


