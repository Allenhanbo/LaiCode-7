
/*
Determine if a small string is a substring of another large string.

Return the index of the first occurrence of the small string in the large string.

Return -1 if the small string is not a substring of the large string.

Assumptions

Both large and small are not null
If small is empty string, return 0
Examples

“ab” is a substring of “bcabc”, return 2
“bcd” is not a substring of “bcabc”, return -1
"" is substring of "abc", return 0
*/

public class Solution {
  public int strstr(String large, String small) {
    // Write your solution here
    if(small.length() == 0) {
        return 0;
    }
    int i = 0;
    int j = 0;
    for(i = 0; i <= large.length() - small.length(); i++) {
      for(j = 0; j < small.length(); j++) {
        if(large.charAt(i + j) != small.charAt(j)) {
          break;
        }
      }
      if(j == small.length()) {
        return i;
      }
    }
    return -1;
  }
}