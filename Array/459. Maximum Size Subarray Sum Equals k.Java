
/*
459. Maximum Size Subarray Sum Equals k
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:

Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:

Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
*/


public class Solution {
  public int maxSubArrayLen(int[] nums, int k) {
    // currSum - HashMap = k
    // HashMap = currSum - k
    // len = [map.get(currSum - k) + 1, curr - index]
    /*
    [1, -1, 5, -2, 3]
    [1, 0, 5, 3, 6]
    */
    if(nums == null || nums.length == 0) {
      return 0;
    }
    int maxLength = 0;
    int[] sums = new int[nums.length];
    sums[0] = nums[0];
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(sums[0], 0);
    for(int i = 1; i < nums.length; i++) {
      sums[i] = sums[i - 1] + nums[i];
      map.put(sums[i], i);
      if(sums[i] == k && i + 1 > maxLength) {
        maxLength = i + 1;
      }
      Integer index = map.get(sums[i] - k);
      if(index == null) {
        continue;
      }
      int length = i - index; // length = i - (index + 1) + 1 = i - index
      if(length > maxLength) {
        maxLength = length; 
      }
    }
    return maxLength;
  }
}

