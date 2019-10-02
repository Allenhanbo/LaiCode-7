
/*
Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

Assumptions

The 2D array is not null and has size of N * N where N >= 0
Examples

{ {1,  2,  3},

  {4,  5,  6},

  {7,  8,  9} }

the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
*/

public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    int size = matrix.length;
    spiralHelper(matrix, 0, size, result);
    return result;
  }

  private void spiralHelper(int[][] matrix, int offset, int size, List<Integer> result) {
    // offset is the [x] and [y] coordinates of the upper-left corner of the box
    // size is the column & row number for the current matrix
    if(size == 0) {
      return;
    }
    if(size == 1) {
      result.add(matrix[offset][offset]);
      return;
    }
    // 1 2
    for(int i = 0; i < size - 1; i++) {
      result.add(matrix[offset][offset + i]);
    }
    // 3 6
    for(int i = 0; i < size - 1; i++) {
      result.add(matrix[offset + i][offset + size - 1]);
    }
    // 9 8
    for(int i = size - 1; i >= 1; i--) {
      result.add(matrix[offset + size - 1][offset + i]);
    }
    // 7 4
    for(int i = size - 1; i >= 1; i--) {
      result.add(matrix[offset + i][offset]);
    }
    spiralHelper(matrix, offset + 1, size - 2, result);
  }
}




