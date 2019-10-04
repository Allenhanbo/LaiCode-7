
/*
Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

Assumptions

The 2D array is not null and has size of M * N where M, N >= 0
Examples

{ {1,  2,  3,  4},

  {5,  6,  7,  8},

  {9, 10, 11, 12} }

the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
*/

public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    int row = matrix.length;
    int col = matrix[0].length;
    spiralHelper(matrix, 0, row, col, result);
    return result;
  }

  private void spiralHelper(int[][] matrix, int offset, int row, int col, List<Integer> result) {
    // offset is the [x] and [y] coordinates of the upper-left corner of the box
    // row is the total row count for the current matrix
    // col is the total column count for the current matrix
    if(row == 0 || col == 0) {
      return;
    }
    if(row == 1 && col == 1) {
      result.add(matrix[offset][offset]);
      return;
    }
    // 6 7
    if(row == 1) {
      for(int i = 0; i < col; i++) {
        result.add(matrix[offset][offset + i]);
      }
      return;
    }
    // 
    if(col == 1) {
      for(int i = 0; i < row; i++) {
        result.add(matrix[offset + i][offset]);
      }
      return;
    }
    // 1 2 3
    for(int i = 0; i < col - 1; i++) {
      result.add(matrix[offset][offset + i]);
    }
    // 4 8
    for(int i = 0; i < row - 1; i++) {
      result.add(matrix[offset + i][offset + col - 1]);
    }
    // 12 11 10 
    for(int i = col - 1; i >= 1; i--) {
      result.add(matrix[offset + row - 1][offset + i]);
    }
    // 9 5
    for(int i = row - 1; i >= 1; i--) {
      result.add(matrix[offset + i][offset]);
    }
    spiralHelper(matrix, offset + 1, row - 2, col - 2, result);
  }
}



