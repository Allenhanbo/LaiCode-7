
/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

public class Solution {
  public int findKthLargest(int[] nums, int k) {
    // Write your solution here
    if(nums.length == 0) {
        return -1;
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, Collections.reverseOrder());
    for(int i = 0; i < nums.length; i++) {
        maxHeap.offer(nums[i]);
    }
    for(int j = 0; j < k - 1; j++) {
        maxHeap.poll();
    }
    return maxHeap.peek();
  }
}


public class Solution {
  public int findKthLargest(int[] nums, int k) {
    // Write your solution here
    if(nums.length == 0) {
        return -1;
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
    for(int i = 0; i < nums.length; i++) {
        if(i < k) {
            minHeap.offer(nums[i]);
        }
        else if(nums[i] > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(nums[i]);
        }
    }
    return minHeap.peek();
  }
}

