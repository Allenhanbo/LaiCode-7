
/*
Determine if there exists three elements in a given array that sum to the given target number. Return all the triple of values that sums to target.

Assumptions

The given array is not null and has length of at least 3
No duplicate triples should be returned, order of the values in the tuple does not matter
Examples

A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
*/


public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    // Write your solution here
    Arrays.sort(array);
    List<List<Integer>> result = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i <= array.length - 3; i++) {
      List<List<Integer>> solution = findSum(array, i + 1, target - array[i]);
      if(solution.size() != 0) {
        for(int j = 0; j < solution.size(); j++) {
          int one = solution.get(j).get(0);
          int two = solution.get(j).get(1);
          if(!map.containsKey(array[i]) || map.get(array[i]) != one) {
            List<Integer> curr = new ArrayList<>();
            curr.add(array[i]);
            curr.add(one);
            curr.add(two);
            result.add(curr);
            map.put(array[i], one);
          }
        }
      }
    }
    return result;
  }


  private List<List<Integer>> findSum(int[] array, int left, int target) {
    List<List<Integer>> result = new ArrayList<>();
    int right = array.length - 1;
    while(left < right) {
      if(array[left] + array[right] == target) {
        List<Integer> curr = new ArrayList<>();
        curr.add(array[left]);
        curr.add(array[right]);
        result.add(curr);
        left++;
        right--;
        if(left >= right) {
          break;
        }
      }
      else if(array[left] + array[right] < target) {
        left++;
      }
      else {
        right--;
      }
    }
    return result;
  }
}




