
/*
Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.

Assumptions

The given array is not null
Examples

A = {1, 2, 1, 2, 1}, return [1, 2]
A = {1, 2, 1, 2, 3, 3, 1}, return [1]
A = {1, 2, 2, 3, 1, 3}, return []
*/


public class Solution {
  public List<Integer> majority(int[] array) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if(array.length == 0) {
      return result;
    }
    if(array.length == 1) {
      result.add(array[0]);
      return result;
    }
    if(array.length == 2) {
      if(array[0] == array[1]) {
        result.add(array[0]);
      }
      else {
        result.add(array[0]);
        result.add(array[1]);
      }
      return result;
    }
    int candidate1 = array[0];
    int count1 = 1;
    int candidate2 = array[1];
    int count2 = 1;
    for(int i = 2; i < array.length; i++) {
      if(array[i] == candidate1) {
        count1++;
      }
      else if(array[i] == candidate2) {
        count2++;
      }
      else if(count1 == 0) {
        candidate1 = array[i];
        count1 = 1;
      }
      else if(count2 == 0) {
        candidate2 = array[i];
        count2 = 1;
      }
      else {
        count1--;
        count2--;
      }
    }
    count1 = 0;
    count2 = 0;
    for(int i = 0; i < array.length; i++) {
      if(array[i] == candidate1) {
        count1++;
      }
      if(array[i] == candidate2) {
        count2++;
      }
    }
    if(count1 > array.length / 3) {
      result.add(candidate1);
    }
    if(count2 > array.length / 3) {
      result.add(candidate2);
    }
    return result;
  }
}
