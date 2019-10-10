
/*
Given two sorted arrays of integers, find the Kth smallest number.

Assumptions

The two given arrays are not null and at least one of them is not empty
K >= 1, K <= total lengths of the two sorted arrays
Examples

A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
*/


public class Solution {
  public int kth(int[] a, int[] b, int k) {
    // Write your solution here
    return findKthSmallest(a, 0, b, 0, k);
  }
  public int findKthSmallest(int[] a, int aLeft, int[] b, int bLeft, int k) {
    if(aLeft >= a.length) {
      return b[bLeft + k - 1];
    }
    if(bLeft >= b.length) {
      return a[aLeft + k - 1];
    }
    if(k == 1) {
      return Math.min(a[aLeft], b[bLeft]);
    }
    int aLeftKth = aLeft + k/2 - 1 < a.length ? a[aLeft + k/2 - 1] : Integer.MAX_VALUE;
    int bLeftKth = bLeft + k/2 - 1 < b.length ? b[bLeft + k/2 - 1] : Integer.MAX_VALUE;
    if(aLeftKth > bLeftKth) {
      return findKthSmallest(a, aLeft, b, bLeft + k/2 , k - k/2);
    }
    else {
      return findKthSmallest(a, aLeft + k/2, b, bLeft, k - k/2);
    }
  }
}




