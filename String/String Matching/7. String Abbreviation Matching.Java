
/*
Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.

Assumptions:

The original string only contains alphabetic characters.
Both input and pattern are not null.
Pattern would not contain invalid information like "a0a","0".
Examples:

pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
*/


public class Solution {
  public boolean match(String input, String pattern) {
    // Write your solution here
    if(input.length() == 0 && pattern.length() == 0) {
      return true;
    }
    if(input.length() == 0 && pattern.length() != 0 || input.length() != 0 && pattern.length() == 0) {
      return false;
    }
    int i = 0; 
    int j = 0;
    while(j < pattern.length()) {
      int count = 0;
      if(Character.isDigit(pattern.charAt(j))) {
        if(j + 1 < pattern.length() && Character.isDigit(pattern.charAt(j + 1))) {
          count = Integer.parseInt(pattern.substring(j, j + 2));
        }
        else {
          count = Integer.parseInt(String.valueOf(pattern.charAt(j)));
          j++;
        }
        while(count > 0) {
          i++;
          count--;
          if(i == input.length()) {
            if(count == 0){
              return true;
            }
            else {
              return false;
            }
          }
        }
      }
      else if(Character.isLetter(pattern.charAt(j))) {
        if(input.charAt(i) == pattern.charAt(j)) {
          i++;
          j++;
        }
        else {
            return false;
        }
      }
    }
    if(i != input.length()) {
      return false;
    }
    return true;
  }
}



public class Solution {
  public boolean match(String input, String pattern) {
    // Write your solution here
    if(input.length() == 0 && pattern.length() == 0) {
      return true;
    }
    if(input.length() == 0 || pattern.length() == 0) {
      return false;
    }
    // input.charAt(0) is a number
    if(Character.isDigit(pattern.charAt(0))) {
      int i = 0;
      int num = 0;
      while(i < pattern.length() && Character.isDigit(pattern.charAt(i))) {
        num = num * 10 + (int)(pattern.charAt(i) - '0');
        i++;
      }
      if(num > input.length()) {
        return false;
      }
      return match(input.substring(num), pattern.substring(i));
    }
    else {
      if(input.charAt(0) != pattern.charAt(0)) {
        return false;
      }
      return match(input.substring(1), pattern.substring(1));
    }
  }
}



