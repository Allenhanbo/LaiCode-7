
/*
A message containing letters from A-Z is being encoded to numbers using the following ways:

         ‘A’ = 1

         ‘B’ = 2

         …

         ‘Z’ = 26

Given an encoded message containing digits, determine the total number of ways to decode it.

Input:    “212”

It can be either decoded as 2,1,2("BAB") or 2,12("BL") or 21,2("UB"), return 3.
*/


public class Solution {
  public int numDecodeWay(String input) {
    // Write your solution here
    // method 1: recursion
    int count[] = new int[1];
    count[0] = 0;
    char[] array = input.toCharArray();
    numDecodeWay(array, count, 0);
    return count[0];
  }
  public void numDecodeWay(char[] array, int[] count, int index) {
    if(index == array.length) {
      count[0]++;
      return;
    }
    if(array[index] == '0') {
      return;
    }
    if(index + 1 < array.length) {
      int num = (int)(array[index] - '0') * 10 + (int)(array[index + 1] - '0');
      if(num <= 26) {
        numDecodeWay(array, count, index + 2);
      }
    }
    numDecodeWay(array, count, index + 1);
  }
}
