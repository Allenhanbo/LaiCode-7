
/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions

There are no duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
*/

public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<String>();
    if(set == null || set.length() == 0) {
      return result;
    }
    char[] solution = new char[set.length()];
    findSubSet(set, 0, solution, result);
    return result;
  }
  private void findSubSet(String input, int index, char[] solution, List<String> result) {
    if(index == input.length()) {
      result.add(solution.toString());
    }
    solution[index] = input.charAt(index);
    findSubSet(input, index + 1, solution, result);
    solution[index] = '\0';

    findSubSet(input, index + 1, solution, result);
  }
}

public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<String>();
    if(set == null || set.length() == 0) {
      return Arrays.asList(new String[0]);
    }
    StringBuilder solution = new StringBuilder();
    findSubSet(set, 0, solution, result);
    return result;
  }
  private void findSubSet(String input, int index, StringBuilder solution, List<String> result) {
    if(index == input.length()) {
      result.add(solution.toString());
    }
    solution.append(input.charAt(index));
    findSubSet(input, index + 1, solution, result);
    solution.deleteCharAt(index);

    findSubSet(input, index + 1, solution, result);
  }
}


// 上面两个都是错误答案，下面才是正确答案
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
    subSetsHelper(set, 0, solution, result);
    return result;
  }
  public void subSetsHelper(String set, int index, StringBuilder solution, List<String> result) {
    // base case
    if(index == set.length()) {
      result.add(solution.toString());
      return;
    }
    solution.append(set.charAt(index));
    subSetsHelper(set, index + 1, solution, result);
    solution.deleteCharAt(solution.length() - 1);
    subSetsHelper(set, index + 1, solution, result);
  } 
}










