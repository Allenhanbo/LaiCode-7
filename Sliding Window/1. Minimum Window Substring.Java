
/*
156. Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T

Input: S = “ADOBECODEBANC”

          T = “ABC”

Output: “BANC”
*/


public class Solution {
  public String minWindow(String source, String target) {
    if(source.length() < target.length()) {
      return "";
    }
    int left = 0, right = 0, index = 0, minLength = Integer.MAX_VALUE, matched = 0;
    Map<Character, Integer> map = new HashMap<>();
    for(char ch: target.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    /*
    k == target.length, put each character in target into a map<Character, Integer>
    if map.containsKey(right++)
      map.put(next, count - 1);
      if count == 0, matched++;
      while matched == map.size()
        if map.containsKey(left++)
          count += 1, if count > 0, matched --;
        else left++;
    else right++;
    */
    for(right = 0; right < source.length(); right++) {
      char curr = source.charAt(right);
      Integer count = map.get(curr);
      if(count == null) {
        continue;
      }
      map.put(curr, count - 1);
      if(count == 1) {
        matched++;
      }
      while(matched == map.size()) {
        if(right - left + 1 < minLength) {
          index = left;
          minLength = right - left + 1;
        }
        char leftmost = source.charAt(left);
        left++;
        Integer leftCount = map.get(leftmost);
        if(leftCount == null) {
          continue;
        }
        map.put(leftmost, leftCount + 1);
        if(leftCount == 0) {
          matched--;
        }
      }// end while
    }// end for
    return minLength == Integer.MAX_VALUE ? "" : source.substring(index, index + minLength);
  }
}
