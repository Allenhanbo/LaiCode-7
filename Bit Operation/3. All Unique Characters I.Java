
/*
Determine if the characters of a given string are all unique.

Assumptions

The only set of possible characters used in the string are 'a' - 'z', the 26 lower case letters.
The given string is not null.
Examples

the characters used in "abcd" are unique
the characters used in "aba" are not unique
*/


public class Solution {
  public boolean allUnique(String word) {
    // Write your solution here
    if (word.length() == 0) {
      return true;
    }
    int result = 0;
    for(int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if ((result >> index & 1) == 1) {
        return false;
      }
      else {
        result = result | 1 << index;
      }
    }
    return true;
  }
}