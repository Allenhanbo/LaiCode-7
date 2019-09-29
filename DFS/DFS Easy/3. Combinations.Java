
/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

E.g.    Input: n = 4, k = 2

    Output: [

                     [2,4],

                     [3,4],

                     [2,3],

                     [1,2],

                     [1,3],

                     [1,4]

        ]
*/


public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    if(k > n) {
      return result;
    }
    List<Integer> curr = new ArrayList<>();
    if(k == n) {
      for(int i = 1; i <= n; i++) {
        curr.add(i);
      }
      result.add(curr);
      return result;
    }
    combineHelper(n, k, 1, curr, result);
    return result;
  }
  private void combineHelper(int n, int k, int index, List<Integer> curr, 
  List<List<Integer>> result) {
    // base case
    // 这里不能写curr.size() == k 因为有的leaf只有0个或者1个元素，长度永远<k，这样就是stackoverflow
    // 这里不能写index > n && curr.size() == k，原因和上面一样，有些分支永远不满足这个条件就无法return，然后stackoverflow
    if(index > n) {
      if(curr.size() == k) {
        result.add(new ArrayList<Integer>(curr));
      }
      return;
    } 
    curr.add(index);
    combineHelper(n, k, index + 1, curr, result);
    curr.remove(curr.size() - 1);
    combineHelper(n, k, index + 1, curr, result);
  }
}
