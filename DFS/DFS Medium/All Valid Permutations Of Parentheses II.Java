
/*
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

Assumptions

l, m, n >= 0
l + m + n > 0
Examples

l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
*/


public class Solution {
  public List<String> validParentheses(int l, int m, int n) {
    // Write your solution here
    //int[] brace, int[] bracket, int[] parenthesis
    //每个int[], 3 elements, [0]一共有几个，[1]左边用了几个，[2]右边用了几个
    List<String> result = new ArrayList<>();
    Deque<String> stack = new LinkedList<>();
    int[] parentheses = new int[3];
    parentheses[0] = l;
    int[] bracket = new int[3];
    bracket[0] = m;
    int[] brace = new int[3];
    brace[0] = n;
    StringBuilder curr = new StringBuilder();
    validParenthesesHelper(parentheses, bracket, brace, stack, curr, result);
    return result;
  }
  private void validParenthesesHelper(int[] parentheses, int[] bracket, int[] brace, 
  Deque<String> stack, StringBuilder curr, List<String> result) {
    // base case
    if(parentheses[1] + parentheses[2] == 2 * parentheses[0] && bracket[1] + bracket[2] == 2 * bracket[0] 
    && brace[1] + brace[2] == 2 * brace[0]) {
      result.add(curr.toString());
      return;
    }
    // add (
    if(parentheses[1] < parentheses[0]) {
      curr.append("(");
      stack.push("(");
      parentheses[1] += 1;
      validParenthesesHelper(parentheses, bracket, brace, stack, curr, result);
      parentheses[1] -= 1;
      stack.pop();
      curr.deleteCharAt(curr.length() - 1);
    }
    // add )
    if(parentheses[2] < parentheses[1] && stack.peek() == "(") {
      curr.append(")");
      stack.pop();
      parentheses[2] += 1;
      validParenthesesHelper(parentheses, bracket, brace, stack, curr, result);
      parentheses[2] -= 1;
      stack.push("(");
      curr.deleteCharAt(curr.length() - 1);
    }
    // add <
    if(bracket[1] < bracket[0]) {
      curr.append("<");
      stack.push("<");
      bracket[1] += 1;
      validParenthesesHelper(parentheses, bracket, brace, stack, curr, result);
      bracket[1] -= 1;
      stack.pop();
      curr.deleteCharAt(curr.length() - 1);
    }
    // add >
    if(bracket[2] < bracket[1] && stack.peek() == "<") {
      curr.append(">");
      stack.pop();
      bracket[2] += 1;
      validParenthesesHelper(parentheses, bracket, brace, stack, curr, result);
      bracket[2] -= 1;
      stack.push("<");
      curr.deleteCharAt(curr.length() - 1);
    }
    // add {
    if(brace[1] < brace[0]) {
      curr.append("{");
      stack.push("{");
      brace[1] += 1;
      validParenthesesHelper(parentheses, bracket, brace, stack, curr, result);
      brace[1] -= 1;
      stack.pop();
      curr.deleteCharAt(curr.length() - 1);
    }
    // add }
    if(brace[2] < brace[1] && stack.peek() == "{") {
      curr.append("}");
      stack.pop();
      brace[2] += 1;
      validParenthesesHelper(parentheses, bracket, brace, stack, curr, result);
      brace[2] -= 1;
      stack.push("{");
      curr.deleteCharAt(curr.length() - 1);
    }
  }
}



