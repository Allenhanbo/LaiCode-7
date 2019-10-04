
/*
Given an array of balls, where the color of the balls can only be Red, Green or Blue, sort the balls such that all the Red balls are grouped on the left side, all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side. (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).

Examples

{0} is sorted to {0}
{1, 0} is sorted to {0, 1}
{1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
Assumptions

The input array is not null.
Corner Cases

What if the input array is of length zero? In this case, we should not do anything as well.
*/

public class Solution {
  public int[] rainbowSort(int[] array) {
    // Write your solution here
    if(array.length == 0) {
      return new int[0];
    }
    // -1 -> i
    // 0 -> k
    // j <- 1
    int i = 0;
    int k = 0;
    int j = array.length - 1;
    while(k <= j) {
      if(array[k] == -1) {
        swap(array, i, k);
        i++;
        k++;
      }
      else if(array[k] == 0) {
        k++;
      }
      else {
        swap(array, k, j);
        j--;
      }
    }
    return array;
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}



