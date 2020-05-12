
/*
Reverse the words in a sentence.

Assumptions

Words are separated by single space
There are no heading or tailing white spaces
Examples

“I love Google” → “Google love I”
Corner Cases

If the given string is null, we do not need to do anything.
*/

public class Solution {
  public String reverseWords(String input) {
    // Write your solution here
    if (input == null || input.length() < 2) {
      return input;
    }
    char[] inputCharArray = input.toCharArray();
    int left = 0;
    int right = 0;
    while(right <= input.length()) {
      if(right == input.length() || inputCharArray[right] == ' ') {
        reverseWordHelper(inputCharArray, left, right - 1);
        right++;
        left = right;
      }
      else {
        right++;
      }
    }
    // reverseWordHelper(inputCharArray, left, input.length() - 1);
    reverseWordHelper(inputCharArray, 0, input.length() - 1);
    return String.valueOf(inputCharArray);
  }
    private void reverseWordHelper(char[] inputCharArray, int left, int right) {
      while(left <= right) {
        char temp = inputCharArray[left];
        inputCharArray[left] = inputCharArray[right];
        inputCharArray[right] = temp;
        left++;
        right--;
      }
    }
}


public class Solution {
  public String reverseWords(String input) {
    // Write your solution here
    if(input == null || input.length() <= 1) {
      return input;
    }
    char[] inputCharArray = input.toCharArray();
    int fast = 0;
    int slow = 0;
    while(fast < inputCharArray.length) {
      if(inputCharArray[fast] != ' ') {
        while(fast < inputCharArray.length && inputCharArray[fast] != ' ') {
          fast++;
        }
        reverse(inputCharArray, slow, fast - 1);
        slow = fast;
      }
      else {
        fast++;
        slow++;
      }
    }
    reverse(inputCharArray, 0, inputCharArray.length - 1);
    return String.valueOf(inputCharArray);
  }
  public void reverse(char[] inputCharArray, int i, int j) {
    while(i <= j) {
      char temp = inputCharArray[i];
      inputCharArray[i] = inputCharArray[j];
      inputCharArray[j] = temp;
      i++;
      j--;
    }
  }
}



















