
/*
Determine if the characters of a given string are all unique.

Assumptions

We are using ASCII charset, the value of valid characters are from 0 to 255
The given string is not null
Examples

all the characters in "abA+\8" are unique
"abA+\a88" contains duplicate characters
*/


public class Solution {
  public boolean allUnique(String word) {
    // Write your solution here
    if(word.length() == 0) {
      return true;
    }
    int[] uniqueChar = new int[8];
    // row = index / 32;
    // col = index % 32;
    for(int i = 0; i < word.length(); i++) {
      int index = word.charAt(i);
      int row = index / 32;
      int col = index % 32;
      if((uniqueChar[row] >> col & 1) == 1) {
        return false;
      }
      else {
        uniqueChar[row] = uniqueChar[row] | 1 << col;
      }
    }
    return true;
  }
}
