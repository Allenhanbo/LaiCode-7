
/*
Given an integer array of length L, find all numbers that occur more than 1/K * L times if any exist.

Assumptions

The given array is not null or empty
K >= 2
Examples

A = {1, 2, 1, 2, 1}, K = 3, return [1, 2]
A = {1, 2, 1, 2, 3, 3, 1}, K = 4, return [1, 2, 3]
A = {2, 1}, K = 2, return []
*/



public class Solution {
  public List<Integer> majority(int[] array, int k) {
    // Write your solution here
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < array.length; i++){
      if(map.size() < k - 1) {
        map.put(array[i], map.getOrDefault(array[i], 0) + 1);
      }
      else {
        if(map.containsKey(array[i])) {
          map.put(array[i], map.get(array[i]) + 2);
        }
        else {
          Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
          while(iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = iter.next();
            if(entry.getValue() == 1) {
              iter.remove();
            }
            else {
              map.put(entry.getKey(), entry.getValue() - 1);
            }
          }
        }
      } // end else
    } // end for
    HashMap<Integer, Integer> check = new HashMap<>();
    for(int i = 0; i < array.length; i++) {
      if(map.containsKey(array[i])) {
        check.put(array[i], check.getOrDefault(array[i], 0) + 1);
      }
    }
    int limit = array.length / k;
    List<Integer> result = new ArrayList<>();
    Iterator<Map.Entry<Integer, Integer>> iter = check.entrySet().iterator();
    while(iter.hasNext()) {
      Map.Entry<Integer, Integer> entry = iter.next();
      if(entry.getValue() > limit) {
        result.add(entry.getKey());
      }
    }
    return result;
  }
}



