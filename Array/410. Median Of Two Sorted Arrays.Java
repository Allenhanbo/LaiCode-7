
/*
Given two sorted arrays of integers in ascending order, find the median value.

Assumptions

The two given array are not null and at least one of them is not empty
The two given array are guaranteed to be sorted
Examples

A = {1, 4, 6}, B = {2, 3}, median is 3
A = {1, 4}, B = {2, 3}, median is 2.5
*/


public class Solution {
  public double median(int[] a, int[] b) {
    // (3 + 2 = 5) / 2 = 2
    // (2 + 2 = 4) / 2 = 2
    int medianIndex = (a.length + b.length) / 2;
    int reminder = (a.length + b.length) % 2;
    int i = 0;
    int j = 0;
    int count = 0;
    int median = 0;
    int medianMinusOne = 0;
    while(i < a.length && j < b.length) {
      // 这个 > debug 一次
      if(count > medianIndex) {
        break;
      }
      medianMinusOne = median;
      if(a[i] < b[j]) {
        median = a[i++];
      }
      else {
        median = b[j++];
      }
      count++;
    }
    // 这个<= debug 一次
    if(count <= medianIndex) {
      if(i < a.length) {
        while(count <= medianIndex) {
          medianMinusOne = median;
          median = a[i++];
          count++;
        }
      }
      else {
        while(count <= medianIndex) {
          medianMinusOne = median;
          median = b[j++];
          count++;
        }
      }
    }
    // 是奇数
    if(reminder == 1) {
      return median;
    }
    else {
      return (median + medianMinusOne) * 1.0 / 2;
    }
  }
}



public class Solution {
  public double median(int[] a, int[] b) {
    // Write your solution here
    // a = 3, b = 2, k = 6/2 = 3
    // a = 2, b = 2, k = 4/2 = 2
    int k = (a.length + b.length) / 2;
    int reminder = (a.length + b.length) % 2;
    if(reminder == 1) {
      return findMedian(a, 0, b, 0, k + 1);
    }
    else {
      return (findMedian(a, 0, b, 0, k) + findMedian(a, 0, b, 0, k + 1)) * 1.0 / 2;
    }
  }
    // aLeft, bLeft == remaining part the most left index 
  public double findMedian(int[] a, int aLeft, int[] b, int bLeft, int k) {
    if(aLeft >= a.length) {
      return b[bLeft + k - 1]; // base case 1: if nothing left in a;
    }
    if(bLeft >= b.length) {
      return a[aLeft + k - 1]; // case case 2: if nothing left in b;
    }
    if(k == 1) {
      return Math.min(a[aLeft], b[bLeft]); // base case 3
    }
    // since index is from 0, so the k/2-th element should be = left + k/2 - 1
    // why is correct? if a.size too small, then remove elements from b first.
    int aHalfKth = aLeft + k/2 - 1 < a.length ? a[aLeft + k/2 - 1] : Integer.MAX_VALUE; 
    int bHalfKth = bLeft + k/2 - 1 < b.length ? b[bLeft + k/2 - 1] : Integer.MAX_VALUE;
    // k - k/2 奇数偶数的一半
    // k = 4, k - k/2 = 4 - 2 = 2
    // k = 5, k - k/2 = 5 - 2 = 3
    if(aHalfKth < bHalfKth) {
      return findMedian(a, aLeft + k/2, b, bLeft, k - k/2);
    }
    else {
      return findMedian(a, aLeft, b, bLeft + k/2, k - k/2);
    }
  }
}
