
/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
*/

public class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    // Write your solution here
    if(nums == null || nums.length == 0 || k == 0) {
      return false;
    }
    int i = 0;
    int j = 1;
    while(i < nums.length - 1) {
      if(nums[i] == nums[j]) {
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
