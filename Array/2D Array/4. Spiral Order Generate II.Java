
/*
124. Spiral Order Generate II
Generate an M * N 2D array in spiral order clock-wise starting from the top left corner, using the numbers of 1, 2, 3, …, M * N in increasing order.

Assumptions

M >= 0, N >= 0
Examples

M = 3, N = 4, the generated matrix is

{ {1,  2,  3,  4}

  {10, 11, 12, 5},

  {9,  8,  7,  6} }
*/

public class Solution {
  public int[][] spiralGenerate(int m, int n) {
    // Write your solution here
    int[][] result = new int[m][n];
    int[] value = new int[1];
    value[0] = 1;
    spiralGenerateHelper(0, m, n, value, result);
    return result;
  }
  public void spiralGenerateHelper(int start, int m, int n, int[] value, int[][] result) {
    if(m <= 0 || n <= 0) {
      return;
    }
    if(m == 1 && n == 1) {
      result[start][start] = value[0];
      value[0]++;
    }
    if(m == 1) {
	    for(int i = 0; i < n; i++) {
	    	result[start][start + i] = value[0];
	    	value[0]++;
	    }
	    return;
	  }
	  if(n == 1) {
	    for(int i = 0; i < m; i++) {
	    	result[start + i][start] = value[0];
	    	value[0]++;
	    }
	    return;
	  }
    for(int i = 0; i <= n - 2; i++) {
      result[start][start + i] = value[0];
      value[0]++;
    }
    for(int i = 0; i <= m - 2; i++) {
      result[start + i][start + n - 1] = value[0];
      value[0]++;
    }
    for(int i = n - 1; i >= 1; i--) {
      result[start + m - 1][start + i] = value[0];
      value[0]++;
    }
    for(int i = m - 1; i >= 1; i--) {
      result[start + i][start] = value[0];
      value[0]++;
    }
    spiralGenerateHelper(start + 1, m - 2, n - 2, value, result);
  }
}
