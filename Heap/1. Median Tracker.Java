
/*
Given an unlimited flow of numbers, keep track of the median of all elements seen so far.

You will have to implement the following two methods for the class

read(int value) - read one value from the flow
median() - return the median at any time, return null if there is no value read so far
Examples

read(1), median is 1
read(2), median is 1.5
read(3), median is 2
read(10), median is 2.5
......
*/

public class Solution {
  Double result;
  PriorityQueue<Integer> minHeap; // 存储较大的数字
  PriorityQueue<Integer> maxHeap; // 存储较小的数字，保持maxHeap >= minHeap
  public Solution() {
    // add new fields and complete the constructor if necessary.
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(11, Collections.reverseOrder());
    result = null;
  }
  
  public void read(int value) {
    // write your implementation here.
    if(minHeap.size() == 0 && maxHeap.size() == 0) {
      maxHeap.offer(value);
    }
    else {
      if(maxHeap.size() > minHeap.size()) {
        if(value < maxHeap.peek()) {
          maxHeap.offer(value);
          minHeap.offer(maxHeap.poll());
        }
        else {
          minHeap.offer(value);
        }
      }
      else {
        if(value < maxHeap.peek()) {
          maxHeap.offer(value);
        }
        else {
          minHeap.offer(value);
          maxHeap.offer(minHeap.poll());
        }
      }
    }
  }
