
/*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.


Example 1:

Input: "aba"
Output: True
Example 2:

Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:

The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/

public class Solution {
  public boolean validPalindrome(String input) {
    // Write your solution here
    if(input == null) {
      return false;
    }
    if(input.length() < 2) {
      return true;
    }
    return validPalindromeHelper(input, 0, input.length() - 1, 0);
  }

  private boolean validPalindromeHelper(String input, int left, int right, int count) {
    while(left <= right) {
      if(input.charAt(left) != input.charAt(right)) {
        if(count >= 1) {
          return false;
        }
        return validPalindromeHelper(input, left + 1, right, 1) || validPalindromeHelper(input, left, right - 1, 1);
      }
      left++;
      right--;
    }
    return true;
  }
}

