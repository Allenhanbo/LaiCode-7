
/*
Given an array of strings, find if the strings can be concatenated to form a ring. The two strings s1 and s2 can be concatenated iff the the last char of s1 is identical to the first char of s2. The first char of the first string in the array must be identical to the last char of the last string. The ring must contain every string in the input once and only once.

Assumptions:

The given array is not null or empty.
None of the strings in the array is null or empty.
Examples:

input = {"aaa", "bbb", "baa", "aab"}, return true since it can be re-arranged to {"aaa", "aab", "bbb"  and "baa"}
input = {"aaa", "bbb"}, return false
*/


public class Solution {
  public boolean formRing(String[] input) {
    // Write your solution here
    HashMap<Character, Integer> check = new HashMap<>();
    for(int i = 0; i < input.length; i++) {
      char curr = input[i].charAt(0);
      check.put(curr, check.getOrDefault(curr, 0) + 1);
    }
    for(int i = 0; i < input.length; i++) {
      char curr = input[i].charAt(input[i].length() - 1);
      if(!check.containsKey(curr)) {
        return false;
      }
      if(check.get(curr) == 1) {
        check.remove(curr);
      }
      else {
        check.put(curr, check.get(curr) - 1);
      }
    }
    return check.size() == 0;
  }
}

