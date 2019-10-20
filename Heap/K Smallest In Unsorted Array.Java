
/*
Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.

Assumptions

A is not null
K is >= 0 and smaller than or equal to size of A
Return

an array with size K containing the K smallest numbers in ascending order
Examples

A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
*/


public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    if(array.length == 0) {
        return new int[0];
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int[] result = new int[k];
    for(int i = 0; i < array.length; i++) {
        minHeap.offer(array[i]);
    }
    for(int j = 0; j < k; j++) {
        int temp = minHeap.poll();
        result[j] = temp;
    }
    return result;
  }
}


public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    if(array.length == 0 || k == 0) {
        return new int[0];
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
    int[] result = new int[k];
    for(int i = 0; i < array.length; i++) {
        if(i < k) {
            maxHeap.offer(array[i]);
        }
        else if(array[i] < maxHeap.peek()) {
            maxHeap.poll();
            maxHeap.offer(array[i]);
        }
    }
    for(int j = k - 1; j >= 0; j--) {
        int temp = maxHeap.poll();
        result[j] = temp;
    }
    return result;
  }
}



