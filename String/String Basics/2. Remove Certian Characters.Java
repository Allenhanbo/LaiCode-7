
/*
Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.

Assumptions

The given input string is not null.
The characters to be removed is given by another string, it is guaranteed to be not null.
Examples

input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
*/

public class Solution {
  public String remove(String input, String t) {
    if(input.length() == 0 || t.length() == 0) {
      return input;
    }
    int slow = 0;
    int fast = 0;
    boolean flag = true;
    char[] inputCharArray = input.toCharArray();
    while(fast < input.length()) {
      for(int i = 0; i < t.length(); i++) {
        if(inputCharArray[fast] == t.charAt(i)) {
          fast++;
          flag = false;
          break;
        }
      }
      if(flag == true) {
        inputCharArray[slow++] = input.charAt(fast++);
      }
      else {
        flag = true;
      }
    }
    String result = String.valueOf(inputCharArray).substring(0, slow);
    return result;
  }
}

