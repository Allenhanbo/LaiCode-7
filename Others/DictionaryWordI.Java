
/*
Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

Assumptions

The given word is not null and is not empty
The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty
Examples

Dictionary: {“bob”, “cat”, “rob”}

Word: “robob” return false
Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
*/


public class Solution {
  public boolean canBreak(String input, String[] dict) {
    // Write your solution here
    HashSet<String> dictSet = new HashSet<>();
    for(int i = 0; i < dict.length; i++) {
      dictSet.add(dict[i]);
    }
    return canBreakHelper(input, dictSet);
  }
  public boolean canBreakHelper(String input, HashSet<String> dictSet) {
    boolean[] result = new boolean[input.length() + 1];
    result[0] = false;
    for(int i = 1; i < input.length() + 1; i++) {
      if(dictSet.contains(input.substring(0, i))) {
        result[i] = true;
        continue;
      }
      // result[0]是字符串为空的时候
      // result[1]是只有一个字符的时候
      for(int j = 1; j < i; j++) {
        if(result[j] && dictSet.contains(input.substring(j, i))) {
          result[i] = true;
          break;
        }
      }
    }
    return result[input.length()];
  }
}
