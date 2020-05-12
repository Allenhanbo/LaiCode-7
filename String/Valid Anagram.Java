
/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

public class Solution {
  public boolean isAnagram(String source, String target) {
    // Write your solution here
    if(source == null || target == null) {
      return false;
    }
    if(source.length() == 0 && target.length() == 0) {
      return true;
    }
    if(source.length() == 0 || target.length() == 0) {
      return false;
    }
    HashSet<Character> targetSet = new HashSet<>();
    for(int i = 0; i < target.length(); i++) {
      targetSet.add(target.charAt(i));
    }
    for(int j = 0; j < source.length(); j++) {
      if(!targetSet.contains(source.charAt(j))) {
        return false;
      }
    }
    return true;
  }
}
