
/*
Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).

Assumptions

In each of the two sorted arrays, there could be duplicate numbers.
Both two arrays are not null.
Examples

A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
*/

public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if(A.size() == 0 || B.size() == 0) {
      return result;
    } 
    List<Integer> min = A;
    List<Integer> max = B;
    if(min.size() > max.size()) {
      min = B;
      max = A;
    }
    HashMap<Integer, Integer> minMap = new HashMap<>();
    for(int i = 0; i < min.size(); i++) {
      Integer count = minMap.get(min.get(i));
      if(count == null) {
        count = 1;
      }
      else {
        count++;
      }
      minMap.put(min.get(i), count);
    }
    for(int j = 0; j < max.size(); j++) {
      Integer count = minMap.get(max.get(j));
      if(count != null) {
        if(count == 1) {
          minMap.remove(max.get(j));
        }
        else {
          minMap.put(max.get(j), count - 1);
        }
        result.add(max.get(j));
      }
    }
    return result;
  }
}


// 1. two pointers
public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if(A.size() == 0 || B.size() == 0) {
      return result;
    }
    Collections.sort(A);
    Collections.sort(B);
    int i = 0;
    int j = 0;
    while(i < A.size() && j < B.size()) {
      if(A.get(i).equals(B.get(j))) {
        result.add(A.get(i));
        i++;
        j++;
      }
      else if(A.get(i) > B.get(j)) {
        j++;
      }
      else {
        i++;
      }
    }
    return result;
  }
}


// 2. hash set
public List<Integer> common(List<Integer> A, List<Integer> B) {
    List<Integer> result = new ArrayList<>();
    if(A.size() == 0 && B.size() == 0) {
      return result;
    }
    List<Integer> min;
    List<Integer> max;
    if(A.size() < B.size()) {
      min = A;
      max = B;
    }
    else {
      min = B;
      max = A;
    }
    HashMap<Integer, Integer> minMap = new HashMap<>();
    for(int i = 0; i < min.size(); i++) {
      minMap.put(min.get(i), minMap.getOrDefault(min.get(i), 0) + 1);
    }
    for(int i = 0; i < max.size(); i++) {
      Integer curr = max.get(i);
      Integer count = minMap.get(curr);
      if(count != null) {
        result.add(curr);
        if(count == 1) {
          minMap.remove(curr);
        }
        else {
          minMap.put(curr, count - 1);
        }
      }
    }
    return result;
}


// 3. binary search
public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    // 3. binary search
    List<Integer> result = new ArrayList<>();
    if(A.size() == 0 || B.size() == 0) {
      return result;
    }
    Collections.sort(A);
    Collections.sort(B);
    List<Integer> min;
    List<Integer> max;
    if(A.size() < B.size()) {
      min = A;
      max = B;
    }
    else {
      min = B;
      max = A;
    }
    for(int i = 0; i < min.size(); i++) {
      if(binarySearch(min.get(i), max)) {
        result.add(min.get(i));
      }
    }
    return result;
  }
  private boolean binarySearch(Integer target, List<Integer> list) {
    int left = 0;
    int right = list.size() - 1;
    while(left <= right) {
      int mid = left + (right - left) / 2;
      if(list.get(mid).equals(target)) {
        return true;
      }
      else if(list.get(mid) < target) {
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }
    return false;
  }
}

/*
方法三：有重复的元素时候失败了
Input: java.util.Arrays.asList(1,2,3,4,5,6), java.util.Arrays.asList(1,3,3,3)
expected:<[1, 3]> but was:<[1, 3, 3, 3]>
*/







