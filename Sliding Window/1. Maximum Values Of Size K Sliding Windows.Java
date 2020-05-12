
/*
Given an integer array A and a sliding window of size K, find the maximum value of each window as it slides from left to right.

Assumptions

The given array is not null and is not empty
K >= 1, K <= A.length
Examples

A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are {{1,2,3}, {2,3,2}, {3,2,4}, {2,4,2}, {4,2,1}},

and the maximum values of each K-sized sliding window are [3, 3, 4, 4, 4]
*/

public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    int left = 0;
    int right = k - 1;
    while(right < array.length) {
      int max = array[left];
      for(int i = left + 1; i <= right; i++) {
        if(array[i] > max) {
          max = array[i];
        }
      }
      result.add(ma);
      left++;
      right++;
    }
    return result;
  }
}


// Method 1: maxHeap O((n-k)*logk) 每次：O(logk)
public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    // Write your solution here
    /*
    initialization: insert all first k elements into the max-heap
    then: when the sliding window moves to the right side step by 1 step...
    1 new element comes in, 
    1 left most element should be removed from the sliding window
    but we can temporarily keep it in the heap, until it becomes the top element in the heap.
    class Element {
      int index;
      int value;
    }
    */
    List<Integer> result = new ArrayList<>();
    PriorityQueue<Element> maxHeap = new PriorityQueue<>();
    for(int i = 0; i < array.length; i++) {
      if(i < k - 1) {
        maxHeap.offer(new Element(i, array[i]));
      }
      else {
        maxHeap.offer(new Element(i, array[i]));
        // maxHeap.peek().index < i - k - 1，这里debug有一会
        while(maxHeap.peek().index < i - k + 1) {
          maxHeap.poll();
        }
        result.add(maxHeap.peek().value);
      }
    }
    return result;
  }
  public class Element implements Comparable<Element> {
    int index;
    int value;
    public Element(int index, int value) {
      this.index = index;
      this.value = value;
    }
    public int compareTo(Element another) {
      if(this.value == another.value) {
        return 0;
      }
      return this.value > another.value ? -1 : 1;
    }
  }
}


// method 2: deque, O(n),每次O(1)
public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    // Write your solution here
    // deque中元素必须保持降序
    // 先检查deque首元素 == array[i - 1]，如果是就删除
    // 如果新进来的元素 > deque.peekFirst(), 把前面的元素都删除
    // 如果新进来的元素 < deque.peekFirst(), 按照降序插入
    // 每一轮加入deque.peekFirst()到result里面
    List<Integer> result = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();
    for(int i = 0; i < array.length; i++) {
      if(i < k) {
        while(!deque.isEmpty() && array[i] > deque.peekLast()) {
          deque.pollLast();
        }
        deque.offerLast(array[i]);
        if(i == k - 1) {
          result.add(deque.peekFirst());
        }
      }
      else {
        if(array[i - k] == deque.peekFirst()) {
          deque.pollFirst();
        }
        while(!deque.isEmpty() && array[i] > deque.peekLast()) {
          deque.pollLast();
        }
        deque.offerLast(array[i]);
        result.add(deque.peekFirst());
      }
    }
    return result;
  }
}











