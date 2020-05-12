
/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters('0'-'9','a'-'z','A'-'Z') and ignoring cases.

For example,
"an apple, :) elp pana#" is a palindrome.

"dia monds dn dia" is not a palindrome.
*/

public class Solution {
  public boolean valid(String input) {
    // Write your solution here
    if(input == null) {
      return false;
    }
    if(input.length() < 2) {
      return true;
    }
    int left = 0;
    int right = input.length() - 1;
    while(left <= right) {
      while(left <= input.length() - 1 && !Character.isDigit(input.charAt(left)) && !Character.isLetter(input.charAt(left))) {
        left++;
      }
      while(right >= 0 && !Character.isDigit(input.charAt(right)) && !Character.isLetter(input.charAt(right))) {
        right--;
      }
      if(left > input.length() - 1 || right < 0) {
        break;
      }
      if(input.charAt(left) != input.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}

