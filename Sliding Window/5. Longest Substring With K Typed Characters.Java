
/*
Given a string, return the longest contiguous substring that contains exactly k type of characters.

Return null if there does not exist such substring.

Assumptions:

The given string is not null.
k >= 0.
Examples:

input = "aabcc", k = 3, output = "aabcc".
input = "aabcccc", k = 2, output = "bcccc".
*/


public class Solution {
  public String longest(String input, int k) {
    // Write your solution here.
    if(k == 0) {
      return "";
    }
    if(input.length() == 0) {
      return null;
    }
    // int max: record the longest length of substring 
    // int begin = slow: when substring length == max 
    // int fast: when map.size() <= k
    // int slow: when map.size() > k
    // map: record all different char
    char[] inputCharArray = input.toCharArray();
    int slow = 0;
    int fast = 0;
    int max = 0;
    int begin = 0;
    char curr = ' ';
    Integer count = null;
    HashMap<Character, Integer> inputMap = new HashMap<>();
    while(fast < inputCharArray.length) {
      if(inputMap.size() <= k) {
        curr = inputCharArray[fast++];
        count = inputMap.get(curr);
        if(count == null) {
          count = 1;
        }
        else {
          count++;
        }
        inputMap.put(curr, count);
      }
      else {
        curr = inputCharArray[slow++];
        count = inputMap.get(curr);
        if(count != null) {
          if(count == 1) {
            inputMap.remove(curr);
          }
          else {
            inputMap.put(curr, count - 1);
          }
        }
      }
      if((inputMap.size() == k) && (fast - slow > max)) {
        max = fast - slow;
        begin = slow;
      }
    }
    if(max == 0) {
      return null;
    }
    char[] result = new char[max];
    for(int i = 0; i < max; i++) {
      result[i] = inputCharArray[begin + i];
    }
    return String.valueOf(result);
  }
}