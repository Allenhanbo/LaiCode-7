
/*
Given an integer number, return all possible combinations of the factors that can multiply to the target number.

Example

Give A = 24

since 24 = 2 x 2 x 2 x 3

              = 2 x 2 x 6

              = 2 x 3 x 4

              = 2 x 12

              = 3 x 8

              = 4 x 6

your solution should return

{ { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }

note: duplicate combination is not allowed.
*/


public class Solution {
  public List<List<Integer>> combinations(int target) {
	    // Write your solution here
	    List<List<Integer>> result = new ArrayList<>();
	    List<Integer> curr = new ArrayList<>();
	    combinationsHelper(target, 2, curr, result);
	    return result;
	  }
	  private void combinationsHelper(int n, int index, List<Integer> curr, List<List<Integer>> result) {
	    if(n == 1) {
	    		if(curr.size() > 1) {
	    			result.add(new ArrayList<Integer>(curr));
	    		}
	       return;
	    }
	    for(int i = index; i <= n; i++) {
	      if(n % i == 0) {
	        curr.add(i);
	        combinationsHelper(n/i, i, curr, result);
	        curr.remove(curr.size() - 1);
	      }
	    }
	  }
}


