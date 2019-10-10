
/*
Find all common elements in 3 sorted arrays.

Assumptions

The 3 given sorted arrays are not null
There could be duplicate elements in each of the arrays
Examples

A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, the common elements are [2, 2]
*/

public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if(a.length == 0 || b.length == 0 || c.length == 0) {
      return result;
    }
    int i = 0;
    int j = 0; 
    int k = 0;
    while(i < a.length && j < b.length && k < c.length) {
      if(a[i] == b[j] && b[j] == c[k]) {
        result.add(a[i]);
        i++;
        j++;
        k++;
      }
      else {
        int curr = Math.min(a[i], b[j]);
        int min = Math.min(curr, c[k]);
        if(min == a[i]) {
          i++;
        }
        else if(min == b[j]) {
          j++;
        }
        else {
          k++;
        }
      }
    }
    return result;
  }
}


public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if(a.length == 0 || b.length == 0 || c.length == 0) {
      return result;
    }
    List<Integer> array1 = new ArrayList<>();
    for(int i = 0; i < a.length; i++) {
      array1.add(a[i]);
    }
    List<Integer> array2 = new ArrayList<>();
    for(int i = 0; i < b.length; i++) {
      array2.add(b[i]);
    }
    List<Integer> array3 = new ArrayList<>();
    for(int i = 0; i < c.length; i++) {
      array3.add(c[i]);
    }
    List<Integer> curr = findCommon(array1, array2);
    result = findCommon(array3, curr);
    return result;
  }
  private List<Integer> findCommon(List<Integer> a, List<Integer> b) {
    List<Integer> result = new ArrayList<>();
    List<Integer> min;
    List<Integer> max;
    if(a.size() < b.size()) {
      min = a;
      max = b;
    }
    else {
      min = b;
      max = a;
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < min.size(); i++) {
      Integer curr = min.get(i);
      map.put(curr, map.getOrDefault(curr, 0) + 1);
    }
    for(int i = 0; i < max.size(); i++) {
      Integer curr = max.get(i);
      Integer count = map.get(curr);
      if(count != null) {
        if(count == 1) {
          map.remove(curr);
        }
        else {
          map.put(curr, count - 1);
        }
        result.add(curr);
      }
    }
    return result;
  }
}
