
/*
Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. For each group of elements with the same value do not keep any of them.

Do this in-place, using the left side of the original array. Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
*/

public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    if(array.length < 2) {
      return array;
    }
    Deque<Integer> stack = new LinkedList<>();
    stack.push(array[0]);
    // push, pop, peek
    int i = 1;
    while(i < array.length) {
      if(stack.isEmpty()) {
        stack.push(array[i]);
        i++;
      }
      else if(array[i] == stack.peek()) {
        i++;
        while(i < array.length && array[i] == stack.peek()) {
          i++;
        }
        stack.pop();
      }
      else {
        stack.push(array[i]);
        i++;
      }
    }
    int[] result = new int[stack.size()];
    for(int j = result.length - 1; j >= 0; j--) {
      result[j] = stack.pop();
    }
    return result;
  }
}

