
/*
Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences. If the character does not has any adjacent, repeated occurrences, it is not changed.

Assumptions

The string is not null
The characters used in the original string are guaranteed to be ‘a’ - ‘z’
Examples

“abbcccdeee” → “ab2c3de3”
*/


public class Solution {
  public String compress(String input) {
    // Write your solution here
    if(input.length() == 0) {
      return input;
    }
    char[] inputCharArray = input.toCharArray();
    int slow = 0;
    int fast = 0;
    while(fast < input.length()) {
      char currChar = inputCharArray[fast++];
      int count = 1;
      if(fast == input.length()){
          inputCharArray[slow++] = currChar;
          break;
      }
      while(inputCharArray[fast] == currChar) {
        count++;
        fast++;
        if(fast == input.length()){
          break;
        }
      }
      inputCharArray[slow++] = currChar;
      if(count != 1) {
        int countLength = (count + "").length();
        int digit = 0;
        for(int i = countLength - 1; i >= 0; i--) {
          if(i == 0) {
            digit = count;
          }
          else {
            digit = count / (10 * i);
            count = count % (10 * i);
          }
          inputCharArray[slow++] = (char)(digit + '0');
        }
      }
    }
    return String.valueOf(inputCharArray).substring(0, slow);
  }
}
