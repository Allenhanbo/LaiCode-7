
/*
Heap Sort is a comparison based sorting algorithm with O(nlogn) time and O(1) space.

Requirements:

You have to do it in place, extra space used is no more than O(1).
Time complexity is O(nlogn).
*/


public class Solution {
  public int[] heapsort(int[] array) {
    // Write your solution here
    // the last index that has children: (n - 1 - 1)/2 = n/2 - 1
    heapify(array);
    // 初始化以后把第一个也就是最大的元素放到最后一个
    swap(array, 0, array.length - 1);
    // 每次从0到i个元素中找到最大值放到，第i个位置
    for(int i = array.length - 2; i >= 0; i--) {
      percolateDown(array, 0, i + 1);
      swap(array, 0, i);
    }
    return array;
  }
  // 初始化一个maxHeap
  private void heapify(int[] array) {
    for(int i = array.length/2 - 1; i >= 0; i--) {
      percolateDown(array, i, array.length);
    }
  }
  // 把较大的节点换到上面来，形成maxHeap
  private void percolateDown(int[] array, int i, int size) {
    while(i <= size/2 - 1) {
      int leftIndex = i * 2 + 1;
      int rightIndex = i * 2 + 2;
      int candidateIndex = leftIndex;
      // 找到两个子孩子中较大的那个
      if(rightIndex < size && array[rightIndex] > array[leftIndex]) {
        candidateIndex = rightIndex;
      }
      // 如果那个较大的子孩子比母节点大，交换位置
      if(array[candidateIndex] > array[i]) {
        swap(array, i, candidateIndex);
      }
      else {
        break;
      }
      i = candidateIndex;
    }
  }
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}


