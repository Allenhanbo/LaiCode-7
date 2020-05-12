
/*
Given an array of integers (without any duplicates), shuffle the array such that all permutations are equally likely to be generated.

Assumptions

The given array is not null
*/


public class Solution {
  public void shuffle(int[] array) {
    // Write your solution here.
    // 随机产生一个index, 让当前index和随机index互换元素
    if(array.length == 0) {
      return;
    }
    for(int i = 0; i < array.length; i++) {
      int randomIndex = (int)(Math.random() * array.length);
      int temp = array[i];
      array[i] = array[randomIndex];
      array[randomIndex] = temp;
    }
  }
}

