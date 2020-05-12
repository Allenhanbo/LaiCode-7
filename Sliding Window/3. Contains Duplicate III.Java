
/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
*/

public class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    // Write your solution here
    if(nums == null || nums.length == 0 || k == 0 || t < 0) {
      return false;
    }
    if(k == 1 && nums.length == 1) {
      return false;
    }
    int i = 0;
    int j = 1;
    while(i < nums.length - 1) {
      if(Math.abs(nums[i] - nums[j]) <= t) {
        return true;
      }
      else {
        j++;
      }
      if((j - i) > k || j == nums.length) {
        i++;
        j = i + 1;
      }
    }
    return false;
  }
}

