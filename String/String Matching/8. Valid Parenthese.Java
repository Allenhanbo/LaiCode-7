
/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. The brackets must close in the correct order.

Examples

"()" and "()[]{}", "[{()}()]" are all valid but "(]" and "([)]" are not.
*/


public class Solution {
  public boolean isValid(String input) {
    // Write your solution here
    if(input == null || input.length() == 0) {
      return false;
    }
    HashMap brackets = new HashMap<Character, Character>();
    brackets.put(')', '(');
    brackets.put('}', '{');
    brackets.put(']', '[');

    Stack<Character> stack = new Stack<>();
    int i = 0;
    while(i < input.length()) {
      char curr = input.charAt(i);
      if(stack.isEmpty()) {
        stack.push(curr);
      }
      else {
        if(brackets.containsKey(curr)) {
          if(stack.pop() != brackets.get(curr)) {
            return false;
          }
        }
        else{
          stack.push(curr);
        }
      }
      i++;
    }
    return stack.isEmpty();
  }
}
