
/*
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*/


public class Solution {
  public boolean containsDuplicate(int[] nums) {
    // Write your solution here
    if(nums == null || nums.length == 0) {
      return false;
    }
    HashSet<Integer> numbers = new HashSet<>();
    for(int i = 0; i < nums.length; i++) {
      if(!numbers.add(nums[i])) {
        return true;
      }
    }
    return false;
  }
}