
/*
Only reverse the vowels('a', 'e', 'i', 'o', 'u') in a given string, the other characters should not be moved or changed.

Assumptions:

The given string is not null, and only contains lower case letters.
Examples:

"abbegi" --> "ibbega"
*/

public class Solution {
  public String reverse(String input) {
    // Write your solution here
    if(input.length() == 0) {
      return input;
    }
    char[] inputCharArray = input.toCharArray();
    HashSet<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    int i = 0;
    int j = input.length() - 1;
    boolean containI = false;
    boolean containJ = false;
    while(i <= j) {
      if(containI == false && vowels.contains(inputCharArray[i])) {
        containI = true;
      }
      if(containJ == false && vowels.contains(inputCharArray[j])) {
        containJ = true;
      }
      if(containI && !containJ) {
        j--;
      }
      else if(!containI && containJ) {
        i++;
      }
      else if(containI && containJ) {
        char temp = inputCharArray[i];
        inputCharArray[i] = inputCharArray[j];
        inputCharArray[j] = temp;
        i++;
        j--;
        containI = false;
        containJ = false;
      }
      else {
        i++;
        j--;
      }
    }
    return String.valueOf(inputCharArray);
  }
}

