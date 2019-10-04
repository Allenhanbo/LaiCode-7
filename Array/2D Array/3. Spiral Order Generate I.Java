
/*
123. Spiral Order Generate I
Generate an N * N 2D array in spiral order clock-wise starting from the top left corner, using the numbers of 1, 2, 3, …, N * N in increasing order.

Assumptions

N >= 0
Examples

N = 3, the generated matrix is

{ {1,  2,  3}

  {8,  9,  4},

  {7,  6,  5} }
*/


public class Solution {
  public int[][] spiralGenerate(int n) {
    int[][] result = new int[n][n];
    int[] value = new int[1];
    value[0] = 1;
    spiralGenerateHelper(0, n, value, result);
    return result;
  }
  public void spiralGenerateHelper(int start, int size, int[] value, int[][] result) {
    if(size <= 0) {
      return;
    }
    if(size == 1) {
      result[start][start] = value[0];
      return;
    }
    for(int i = 0; i <= size - 2; i++) {
      result[start][start + i] = value[0];
      value[0]++;
    }
    for(int i = 0; i <= size - 2; i++) {
      result[start + i][start + size - 1] = value[0];
       value[0]++;
    }
    for(int i = size - 1; i >= 1; i--) {
      result[start + size - 1][start + i] = value[0];
       value[0]++;
    }
    for(int i = size - 1; i >= 1; i--) {
      result[start + i][start] =  value[0];
       value[0]++;
    }
    spiralGenerateHelper(start + 1, size - 2, value, result);
  }
}




