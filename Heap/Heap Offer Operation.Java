
/*
Given a binary min heap in array format. The last celll of the array is not used.

Now offer a new element into the heap.

Assumptions:

The given array is not null and has length >= 1
Examples:

array = {2, 3, 4, 0}, offer(1) --> {1, 2, 4, 3}
*/

public class Solution {
  public int[] offerHeap(int[] array, int ele) {
    // Write your solution here
    array[array.length - 1] = ele;
    perlocateUp(array, array.length - 1);
    return array;
  }
  public void perlocateUp(int[] array, int index) {
    while(index > 0) {
        int parentIndex = (index - 1) / 2;
        if(array[parentIndex] > array[index]) {
            swap(array, parentIndex, index);
        }
        else {
            break;
        }
        index = parentIndex;
    }
  }
  public void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

