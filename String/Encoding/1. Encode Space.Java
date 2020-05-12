
/*
In URL encoding, whenever we see an space " ", we need to replace it with "20%". Provide a method that performs this encoding for a given string.

Examples

"google/q?flo wer market" → "google/q?flo20%wer20%market"
Corner Cases

If the given string is null, we do not need to do anything.
*/

public class Solution {
  public String encode(String input) {
    // Write your solution here
    int count = 0;
    for(int i = 0; i < input.length(); i++) {
      if(input.charAt(i) == ' ') {
        count++;
      }
    }
    int newLength = input.length() + 2 * count;
    char[] inputCharArray = input.toCharArray();
    char[] result = new char[newLength];
    for(int i = 0; i < inputCharArray.length; i++) {
      result[i] = inputCharArray[i];
    }
    int slow = result.length - 1;
    int fast = inputCharArray.length - 1;
    while(fast >= 0 && slow >= 0) {
      if(result[fast] != ' ') {
        result[slow--] = result[fast--];
      }
      else {
        result[slow--] = '%';
        result[slow--] = '0';
        result[slow--] = '2';
        fast--;
      }
    }
    return String.valueOf(result);
  }
}

