
/*
Reverse a given string.

Assumptions

The given string is not null.
*/

public class Solution {
  public String reverse(String input) {
    // Write your solution here
    if(input.length() == 0) {
      return input;
    }
    char[] inputCharArray = input.toCharArray();
    int i = 0;
    int j = input.length() - 1;
    while(i <= j) {
      char temp = inputCharArray[i];
      inputCharArray[i] = inputCharArray[j];
      inputCharArray[j] = temp;
      i++;
      j--;
    }
    return String.valueOf(inputCharArray);
  }
}

