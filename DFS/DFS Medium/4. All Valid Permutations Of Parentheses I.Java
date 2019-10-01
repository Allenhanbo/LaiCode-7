
/*
Given N pairs of parentheses “()”, return a list with all the valid permutations.

Assumptions

N > 0
Examples

N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
*/


public class Solution {
  public List<String> validParentheses(int n) {
    // Write your solution here
    List<String> result = new ArrayList<>();
    if(n == 1) {
      result.add("()");
      return result;
    }
    StringBuilder solution = new StringBuilder();
    DFS(n, 0, 0, solution, result);
    return result;
  }

  private void DFS(int n, int left, int right, StringBuilder solution, List<String> result) {
    if(left + right == n * 2) {
      result.add(solution.toString());
      return;
    }
    if(left < n) {
      solution.append("(");
      DFS(n, left + 1, right, solution, result);
      solution.deleteCharAt(solution.length() - 1);
    }
    if(right < left) {
      solution.append(")");
      DFS(n, left, right + 1, solution, result);
      solution.deleteCharAt(solution.length() - 1);
    }
  }
}
