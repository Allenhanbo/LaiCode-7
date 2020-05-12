
/*
Given an original string input, and two strings S and T, replace all occurrences of S in input with T.

Assumptions

input, S and T are not null, S is not empty string
Examples

input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
input = "dodododo", S = "dod", T = "a", input becomes "aoao"
*/

public class Solution {
  public String replace(String input, String source, String target) {
    // Write your solution here
    // if match, replace source with target
    // otherwise, copy right to left
    if(input.length() == 0) {
      return input;
    }
    char[] inputCharArray = input.toCharArray();
    if(source.length() >= target.length()) {
      // from left to right
      int fast = 0;
      int slow = 0;
      while(fast < inputCharArray.length) {
        if(findSourceFromLeftToRight(input, source, fast)) {
          // replace source with target
          for(int i = 0; i < target.length(); i++) {
            inputCharArray[slow++] = target.charAt(i);
          }
          fast = fast + source.length();
        }
        else {
          inputCharArray[slow++] = inputCharArray[fast++];
        }
      }
      return String.valueOf(inputCharArray).substring(0, slow);
    } 
    // from right to left
    int count = countSource(input, source);
    int size = input.length() + count * (target.length() - source.length());
    char[] result = new char[size];
    int inputChar = 0;
    int resultChar = 0;
    while(resultChar < size && inputChar < input.length()) {
      if(findSourceFromLeftToRight(input, source, inputChar)) {
        for(int i = 0; i < target.length(); i++) {
          result[resultChar++] = target.charAt(i);
        }
        inputChar = inputChar + source.length();
      }
      else {
        result[resultChar++] = inputCharArray[inputChar++];
      }
    }
    return String.valueOf(result);
  }

  private boolean findSourceFromLeftToRight(String input, String source, int i) {
    if(input.length() - i < source.length()) {
      return false;
    }
    for(int j = 0; j < source.length(); j++) {
      if(input.charAt(i++) != source.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  private int countSource(String input, String source) {
    int count = 0;
    for(int i = 0; i <= input.length() - source.length(); i++) {
      int j = 0;
      for(j = 0; j < source.length(); j++) {
        if(input.charAt(i + j) != source.charAt(j)) {
          break;
        }
      }
      if(j == source.length()) {
        count++;
        i = i + source.length() - 1;
      }
    }
    return count;
  }

}








