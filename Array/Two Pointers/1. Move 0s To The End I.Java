
/*
Given an array of integers, move all the 0s to the right end of the array.

The relative order of the elements in the original array does not need to be maintained.

Assumptions:

The given array is not null.
Examples:

{1} --> {1}
{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
*/

public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here
    if(array.length < 2) {
      return array;
    }
    int i = 0;
    int j = array.length - 1;
    // all the numbers on the left hand side of i != 0
    // all the numbers on the right hand side of j == 0
    while(i <= j) {
      if(array[i] != 0){
        i++;
      }
      else if(array[j] == 0) {
        j--;
      }
      else {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    return array;
  }
}

