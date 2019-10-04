
/*
Rotate an N * N matrix clockwise 90 degrees.

Assumptions

The matrix is not null and N >= 0
Examples

{ {1,  2,  3}

  {8,  9,  4},

  {7,  6,  5} }

after rotation is

{ {7,  8,  1}

  {6,  9,  2},

  {5,  4,  3} }
*/

public class Solution {
  public void rotate(int[][] matrix) {
    // Write your solution here
    // 1  2  3  4     13  9  5  1
    // 5  6  7  8     14  10 6  2
    // 9  10 11 12    15  11 7  3
    // 13 14 15 16    16  12 8  4
    // [0][0] -> [0][3] -> [3][3] -> [3][0]
    // [0][1] -> [1][3] -> [3][2] -> [2][0]
    // [0][2] -> [2][3] -> [3][1] -> [1][0]
    // [0][i] -> [i][n] -> [n][n - i] -> [n - i][0]
    // [offset][offset + i] -> [offset + i][offset + size - 1] -> 
    // [offset + size - 1][offset + size - 1 - i] -> [offset + size - 1 - i][offset]
    if(matrix.length == 1) {
      return;
    }
    rotateHelper(matrix, 0, matrix.length);
  }
  private void rotateHelper(int[][] matrix, int offset, int size) {
    if(size <= 1) {
      return;
    }
    for(int i = 0; i < size - 1; i++) {
      int temp1 = matrix[offset][offset + i]; // [0][0] 
      int temp2 = matrix[offset + i][offset + size - 1]; // [0][3]
      int temp3 = matrix[offset + size - 1][offset + size - 1 - i]; // [3][3]
      int temp4 = matrix[offset + size - 1 - i][offset]; // [3][0]
      matrix[offset + i][offset + size - 1] = temp1; // [0][3] = 1;
      matrix[offset + size - 1][offset + size - 1 - i] = temp2; // [3][3] = 4
      matrix[offset + size - 1 - i][offset] = temp3; // [3][0] = 16
      matrix[offset][offset + i] = temp4; // [0][0] = 13
    }
    rotateHelper(matrix, offset + 1, size - 2);
  }
}






