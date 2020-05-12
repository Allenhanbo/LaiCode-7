
/*
Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.

Assumptions

s is not null or empty.
l is not null.
Examples

l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
*/


public class Solution {
  /*
  这版用的HashMap，charTypeToMatch，List<Integer> result
  下一班用char直接转成Int
  */
  public List<Integer> allAnagrams(String sh, String lo) {
    // Write your solution here
    HashMap<Character, Integer> shortStringMap = new HashMap<>();
    addToMap(shortStringMap, sh, 0, sh.length());
    // HashSet<Character> shortStringSet = new HashSet<>();
    // addToSet(shortStringSet, sh, 0, sh.length())'
    List<Integer> result = new ArrayList<>();
    // 先删除再移动slow
    // 先添加再移动fast
    // [slow, fast)
    int slow = 0;
    int fast = 0;
    char fastChar = ' ';
    char slowChar = ' ';
    Integer fastCount = null;
    int slowCount = 0;
    int charTypeToMatch = shortStringMap.size();
    while(fast < lo.length()) {
      // 需要移动slow
      if(fast - slow == sh.length()) {
        slowChar = lo.charAt(slow);
        slowCount = shortStringMap.get(slowChar);
        shortStringMap.put(slowChar, slowCount + 1);
        // 1. 下面这两行debug一个小时
        // 因为是先考虑slow，所以不会出现slowCount < 0的情况
        if(shortStringMap.get(slowChar) == 1) {
          charTypeToMatch++;
        }
        slow++;
      }
      // 不管怎样都需要移动fast
      fastChar = lo.charAt(fast);
      fastCount = shortStringMap.get(fastChar);    
      // fastChar is not in long String
      if(fastCount == null) {
        fast = fast + 1;
        slow = fast;
        shortStringMap.clear();
        addToMap(shortStringMap, sh, 0, sh.length());
        charTypeToMatch = shortStringMap.size();
      }
      // fastChar is in long String
      else {
        shortStringMap.put(fastChar, fastCount - 1);
        // 2. 下面这两行debug一个小时
        if(shortStringMap.get(fastChar) == 0) {
          charTypeToMatch--;
        }
        fast++;
      }

      if(charTypeToMatch == 0) {
        result.add(slow);
      }
    }
    return result;
  }

  private void addToMap(HashMap<Character, Integer> map, String sh, int begin, int end) {
    for(int i = begin; i < end; i++) {
      char curr = sh.charAt(i);
      Integer count = map.get(curr);
      if(count == null) {
        count = 1;
      }
      else {
        count++;
      }
      map.put(curr, count);
    }
  }
}



public class Solution {
  public List<Integer> allAnagrams(String sh, String lo) {
    // Write your solution here
    // add each char in short to a Map<Character, Integer>
    // right - left == sh.length()
    // left++: if char left in Map, add it
    // right++: if char left in Map, reduce by 1 or remove it
    List<Integer> result = new ArrayList<>();
    if(lo.length() == 0) {
      return result;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < sh.length(); i++) {
      Integer count = map.get(sh.charAt(i));
      if(count == null) {
        count = 1;
      }
      else {
        count++;
      }
      map.put(sh.charAt(i), count);
    }
    int left = 0; 
    int right = 0;
    int charLeftToCheck = map.size();
    while(right < lo.length()) {
      // need to move left
      if(right - left == sh.length()) {
        char leftChar = lo.charAt(left);
        if(map.containsKey(leftChar)) {
          int leftCount = map.get(leftChar);
          if(leftCount == 0) {
            charLeftToCheck++;
          }
          map.put(leftChar, leftCount + 1);
        }
        left++;
      }
      // always need to move right
      char rightChar = lo.charAt(right);
      if(map.containsKey(rightChar)){
        int rightCount = map.get(rightChar);
        if(rightCount == 1){
          map.put(rightChar, 0);
          charLeftToCheck--;
        }
        else {
          map.put(rightChar, rightCount - 1);
        }
      }
      right++;
      if(charLeftToCheck == 0) {
        result.add(left);
      }
    }
    return result;
  }
}
































