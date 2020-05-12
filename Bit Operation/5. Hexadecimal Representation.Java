
/*
Generate the hexadecimal representation for a given non-negative integer number as a string. The hex representation should start with "0x".

There should not be extra zeros on the left side.

Examples

0's hex representation is "0x0"
255's hex representation is "0xFF"
*/

public class Solution {
  public String hex(int number) {
    // Write your solution here
    // 0 1 2 3 4 5 6 7 8 9
    // 10 11 12 13 14 15
    // A  B  C  D  E  F
    if(number == 0) {
      return "0x0";
    }
    StringBuilder result = new StringBuilder();
    int curr = 0;
    char ch = ' ';
    while(number > 0) {
      curr = number % 16;
      number = number / 16;
      if(curr < 10) {
        ch = (char)(curr + '0');
      }
      else {
        curr = curr % 10;
        ch = (char)(curr + 'A');
      }
      result.append(ch);
    }
    result.append("x0");
    result.reverse();
    return result.toString();
  }
}
