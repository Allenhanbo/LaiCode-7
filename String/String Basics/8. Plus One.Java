
/*
Given a non-negative number represented as an array of digits, plus one to the number.

Input: [2, 5, 9]

Output: [2, 6, 0]
*/

public class Solution {
  public int[] plus(int[] digits) {
    // Write your solution here
    int[] result = digits;
    boolean flag = false;
    for(int i = result.length - 1; i >= 0; i--) {
      if(flag || i == result.length - 1) {
        result[i] += 1;
        flag = false;
        if(result[i] == 10) {
          result[i] = 0;
          flag = true;
        }
      }
      else {
        break;
      }
    }
    if(result[0] == 0) {
      result = new int[digits.length + 1];
      for(int i = digits.length; i >= 1; i--) {
        result[i] = digits[i - 1];
      }
      result[0] = 1;
    }
    return result;
  }
}

