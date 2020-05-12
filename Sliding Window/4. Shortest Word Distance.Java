
/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/


public class Solution {
  public int shortestDistance(String[] words, String word1, String word2) {
    // Write your solution here
    if(words == null || words.length <= 1) {
      return -1;
    }
    ArrayList<Integer> word1s = new ArrayList<>();
    ArrayList<Integer> word2s = new ArrayList<>();
    for(int i = 0; i < words.length; i++) {
      if(words[i].equals(word1)) {
        word1s.add(i);
      }
      if(words[i].equals(word2)) {
        word2s.add(i);
      }
    }
    int min = words.length;
    for(int i = 0; i < word1s.size(); i++) {
      for(int j = 0; j < word2s.size(); j++) {
        int diff = Math.abs(word1s.get(i) - word2s.get(j));
        if(diff < min) {
          min = diff;
        }
      }
    }
    if(min == words.length) {
      return -1;
    }
    return min;
  }
}
