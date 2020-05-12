
/*
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.
*/


public class Solution {
  public int shortestWordDistance(String[] words, String word1, String word2) {
    // Write your solution here
    if(words == null || words.length <= 1) {
      return -1;
    }
    int min = -1;
    if(word1.equals(word2)) {
      min = sameWords(words, word1);
    }
    else {
      min = diffWords(words, word1, word2);
    }
    return min;
  }

  private int sameWords(String[] words, String word1) {
    int min = words.length;
    ArrayList<Integer> word1s = new ArrayList<>();
    for(int i = 0; i < words.length; i++) {
      if(words[i].equals(word1)) {
        word1s.add(i);
      }
    }
    for(int i = 0; i < word1s.size(); i++) {
      for(int j = i + 1; j < word1s.size(); j++) {
        int diff = Math.abs(word1s.get(i) - word1s.get(j));
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

  private int diffWords(String[] words, String word1, String word2) {
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
