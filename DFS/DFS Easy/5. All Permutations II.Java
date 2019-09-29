
/*
Given a string with possible duplicate characters, return a list with all permutations of the characters.

Examples

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
Set = "aba", all permutations are ["aab", "aba", "baa"]
Set = "", all permutations are [""]
Set = null, all permutations are []
*/


public class Solution {
  public List<String> permutations(String set) {
    // Write your solution here
    // Write your solution here
    List<String> result = new ArrayList<>();
    if(set.length() == 0) {
      result.add("");
      return result;
    }
    char[] input = set.toCharArray();
    DFS(input, 0, result);
    return result;
  }
  private void DFS(char[] input, int index, List<String> result) {
    if(index == input.length) {
      result.add(String.valueOf(input));
      return;
    }
    Set<Character> used = new HashSet<Character>();
    for(int i = index; i < input.length; i++) {
      if(used.add(input[i])) {
        swap(input, index, i);
        DFS(input, index + 1, result);
        swap(input, index, i);
      }
    }
  }
  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
