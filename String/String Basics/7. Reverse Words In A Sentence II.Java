
/*
Reverse the words in a sentence and truncate all heading/trailing/duplicate space characters.

Examples

“ I  love  Google  ” → “Google love I”
Corner Cases

If the given string is null, we do not need to do anything.
*/

public class Solution {
  public String reverseWords(String input) {
    // Write your solution here
    if (input == null || input.length() < 2) {
      return input;
    }
    char[] inputCharArray = removeSpace(input).toCharArray();
    int left = 0;
    int right = 0;
    while(right <= inputCharArray.length) {
      if(right == inputCharArray.length || inputCharArray[right] == ' ') {
        reverseWordHelper(inputCharArray, left, right - 1);
        right++;
        left = right;
      }
      else {
        right++;
      }
    }
    reverseWordHelper(inputCharArray, 0, inputCharArray.length - 1);
    return String.valueOf(inputCharArray);
  }

    private String removeSpace(String input) {
      char[] inputCharArray = input.toCharArray();
      int fast = 0;
      int slow = 0;
      int count = 0;
      while(true) {
        while(fast < input.length() && inputCharArray[fast] == ' ') {
          fast++;
        }
        if(fast == input.length()) {
          break;
        }
        if(count > 0) {
          inputCharArray[slow++] = ' ';
        }
        while(fast < input.length() && inputCharArray[fast] != ' ') {
          inputCharArray[slow++] = inputCharArray[fast++];
        }
        count++;
      }
      String result = String.valueOf(inputCharArray).substring(0, slow);
      return result;
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
    int count = 0;
    int begin = 0;
    while(fast < inputCharArray.length) {
      if(inputCharArray[fast] == ' ') {
        while(fast < inputCharArray.length && inputCharArray[fast] == ' ') {
          fast++;
        }
        if(fast ==  inputCharArray.length) {
          break;
        }
        if(count > 0) {
          inputCharArray[slow++] = ' ';
        }
      }
      else {
        begin = slow;
        while(fast < inputCharArray.length && inputCharArray[fast] != ' ') {
          inputCharArray[slow++] = inputCharArray[fast++];
        }
        reverse(inputCharArray, begin, slow - 1);
      }
      count++;
    }
    reverse(inputCharArray, 0, slow - 1);
    return String.valueOf(inputCharArray).substring(0, slow);
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
























