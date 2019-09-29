
/*
Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that each subset returned will be sorted to remove the sequence.

Assumptions

There could be duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
*/


public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<>();
    if(set == null) {
      return result;
    }
    if(set.length() == 0) {
      result.add("");
      return result;
    }
    StringBuilder solution = new StringBuilder();
    char[] inputCharArray = set.toCharArray();
    Arrays.sort(inputCharArray);
    String input = String.valueOf(inputCharArray);
    findSubSet(input, 0, solution, result);
    return result;
  }
  public void findSubSet(String set, int index, StringBuilder solution, List<String> result) {
    if(index == set.length()) {
      result.add(solution.toString());
      return;
    }
    solution.append(set.charAt(index));
    findSubSet(set, index + 1, solution, result);
    solution.deleteCharAt(solution.length() - 1);
    while(index + 1 < set.length() && set.charAt(index + 1) == set.charAt(index)) {
      index++;
    }
    findSubSet(set, index + 1, solution, result);
  }
}
