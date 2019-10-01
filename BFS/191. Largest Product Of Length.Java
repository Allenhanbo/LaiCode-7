
/*
Given a dictionary containing many words, find the largest product of two words’ lengths, such that the two words do not share any common characters.

Assumptions

The words only contains characters of 'a' to 'z'
The dictionary is not null and does not contains null string, and has at least two strings
If there is no such pair of words, just return 0
Examples

dictionary = [“abcde”, “abcd”, “ade”, “xy”], the largest product is 5 * 2 = 10 (by choosing “abcde” and “xy”)
*/

public class Solution {
  public int largestProduct(String[] dict) {
    // Write your solution here
    Arrays.sort(dict, new StringLengthComparator());
    PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
    maxHeap.offer(new Pair(0, dict[0], 1, dict[1]));
    // poll(i, j), offer(i+1, j), offer(i, j+1)
    // poll(0, 1), offer(1, 1), offer(0, 2)
    // poll(0, 2), offer(1, 2), offer(0, 3)
    while(!maxHeap.isEmpty()) {
      Pair curr = maxHeap.poll();
      if(compareString(curr.word1, curr.word2)) {
        int i = curr.index1;
        int j = curr.index2;
        if(i + 1 != j && i + 1 < dict.length && j < dict.length) {
          maxHeap.offer(new Pair(i + 1, dict[i + 1], j, dict[j]));
        }
        if(j + 1 != i && j + 1 < dict.length && i < dict.length) {
          maxHeap.offer(new Pair(i, dict[i], j + 1, dict[j + 1]));
        }
      }
      else {
        return curr.word1.length() * curr.word2.length();
      }
    }
    return 0;
  }

  class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
      if(a.length() == b.length()) {
        return 0;
      }
      return a.length() < b.length() ? 1 : -1;
    }
  }

  public boolean compareString(String a, String b) {
    if(a.length() == 0 || b.length() == 0) {
      return false;
    }
    char[] aChar = a.toCharArray();
    char[] bChar = b.toCharArray();
    Arrays.sort(aChar);
    Arrays.sort(bChar);
    int i = 0;
    int j = 0;
    while(i < aChar.length && j < bChar.length) {
      if(aChar[i] == bChar[j]) {
        return true;
      }
      else if(aChar[i] < bChar[j]) {
        i++;
      }
      else {
        j++;
      }
    }
    return false;
  }

  public class Pair implements Comparable<Pair>{
    int index1;
    String word1;
    int index2;
    String word2;
    public Pair(int index1, String word1, int index2, String word2) {
      this.index1 = index1;
      this.index2 = index2;
      this.word1 = word1;
      this.word2 = word2;
    }
    @Override
    public int compareTo(Pair other) {
      int product1 = this.word1.length() * this.word2.length();
      int product2 = other.word1.length() * other.word2.length();
      if(product1 == product2) {
        return 0;
      }
      return product1 < product2 ? 1 : -1;
    }
  }
}

