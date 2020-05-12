
/*
Given a string, remove all leading/trailing/duplicated empty spaces.

Assumptions:

The given string is not null.
Examples:

“  a” --> “a”
“   I     love MTV ” --> “I love MTV”
*/

public class Solution {
  public String removeSpaces(String input) {
    // Write your solution here
    if(input == null) {
      return "";
    }
    char[] solution = input.toCharArray();
    int fast = 0;
    int slow = 0;
    int count = 0;
    while(true) {
      while(fast < input.length() && solution[fast] == ' ') {
        fast++;
      }
      if(fast == input.length()) {
        break;
      }
      if(count > 0) {
        solution[slow++] = ' ';
      }
      while(fast < input.length() && solution[fast] != ' ') {
        solution[slow++] = solution[fast++];
      }
      count++;
    }
    String result = String.valueOf(solution).substring(0, slow);
    return result;
  }
}

