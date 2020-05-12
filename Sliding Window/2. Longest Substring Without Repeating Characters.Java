
/*
Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.

For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
*/

public class Solution {
  public int longest(String input) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        int i = 0;
        int j = 0;
        while (i < input.length() && j < input.length()) {
            // try to extend the range [i, j]
            if (!set.contains(input.charAt(j))){
                set.add(input.charAt(j++));
                result = Math.max(result, j - i);
            }
            else {
                set.remove(input.charAt(i++));
            }
        }
        return result;

        /**
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
        */
  }
}



public class Solution {
  public int longest(String input) {
    // Write your solution here
    if(input == null || input.length() == 0) {
      return 0;
    }
    HashSet<Character> set = new HashSet<>();
    int left = 0;
    int right = 0;
    int max = 0;
    // map.add() return false, left++
    // map.add() return true, right++
    while(right < input.length()) {
      if(set.add(input.charAt(right))) {
        right++;
      }
      else {
        set.remove(input.charAt(left));
        left++;
      }
      if(right - left > max) {
        max = right - left;
      }
    }
    return max;
  }
}
