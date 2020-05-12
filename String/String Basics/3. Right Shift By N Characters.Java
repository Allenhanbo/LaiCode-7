
/*
Right shift a given string by n characters.

Assumptions

The given string is not null.
n >= 0.
Examples

"abc", 4 -> "cab"
*/

public class Solution {
  public String rightShift(String input, int n) {
    // Write your solution here
    if(input.length() == 0 || n % input.length() == 0) {
      return input;
    }
    int i = n % input.length();
    String result = input.substring(input.length() - i) + input.substring(0, input.length() - i);
    return result;
  }
}


public class Solution {
  public String rightShift(String input, int n) {
    // Write your solution here
    if(input.length() == 0 || n % input.length() == 0) {
      return input;
    }
    int begin = input.length() - n % input.length();
    char[] inputCharArray = input.toCharArray();
    reverse(inputCharArray, 0, begin - 1);
    reverse(inputCharArray, begin, inputCharArray.length - 1);
    reverse(inputCharArray, 0, inputCharArray.length - 1);
    return String.valueOf(inputCharArray);
  }
  private void reverse(char[] inputCharArray, int i, int j) {
    while(i <= j) {
      char temp = inputCharArray[i];
      inputCharArray[i] = inputCharArray[j];
      inputCharArray[j] = temp;
      i++;
      j--;
    }
  }
}
