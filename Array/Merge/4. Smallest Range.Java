
/*
Given k sorted integer arrays, pick k elements (one element from each of sorted arrays), what is the smallest range.

Assumptions:

k >= 2
None of the k arrays is null or empty
Examples:

{ { 1, 4, 6 },

  { 2, 5 },

  { 8, 10, 15} }

pick one element from each of 3 arrays, the smallest range is {5, 8} (pick 6 from the first array, pick 5 from the second array and pick 8 from the third array).
*/


public class Solution {
  public int[] smallestRange(int[][] arrays) {
	    // class Element(value, indexOfArray, indexOfValue)
	    // sort array Element[k]
	    // poll maxHeap(Element[k]), get Element[0].index
	    // offer arrays[Element[0].indexOfArray][Element[0].indexOfArray + 1]

	    // method 1: k pointers
  		// 关键是任何一个最小到达终点（也就是array最后一个）就可以停止了
	    int[] result = new int[2];
	    result[0] = 0;
	    result[1] = Integer.MAX_VALUE;
	    int[] index = new int[arrays.length];
	    for(int i = 0; i < arrays.length; i++) {
	      index[i] = 0;
	    }
	    while(true) { // O(k)
	      int currMin = Integer.MAX_VALUE;
	      int currMax = Integer.MIN_VALUE;
	      // minIndex是指int[]的index，不是int的index
	      int minIndex = 0;
	     // int maxIndex = -1;
	      for(int i = 0; i < arrays.length; i++) {
	        if(arrays[i][index[i]] < currMin) {
	          currMin = arrays[i][index[i]];
	          minIndex = i;
	        }
	        if(arrays[i][index[i]] > currMax) {
	          currMax = arrays[i][index[i]];
	          // maxIndex = i;
	        }
	      }
	      if(currMax - currMin < result[1] - result[0]) {
	        result[0] = currMin;
	        result[1] = currMax;
	      }
	      if(index[minIndex] == arrays[minIndex].length - 1) {
	        break;
	      }
	      index[minIndex] += 1;
	    }
	    return result;
	  }
}

