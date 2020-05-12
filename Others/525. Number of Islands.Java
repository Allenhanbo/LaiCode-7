
/*
Given a 2d grid map of 1s (land) and 0s (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/


public class Solution {
  public static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  public int numIslands(char[][] grid) {
    // Write your solution here
    // Assumption: grid != null && grid's size >= 1 * 1
    // idea: visited grid[row][col] = 2
    if(grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int count = 0;
    int row = grid.length;
    int col = grid[0].length;
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        if(grid[i][j] == '1') {
          count++;
          DFS(grid, row, col, i, j);
        }
      }
    }
    return count;
  }
  public void DFS(char[][] grid, int row, int col, int i, int j) {
    if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0' || grid[i][j] == '2') {
      return;
    }
    grid[i][j] = '2';
    for(int[] dir: dirs) {
      int x = i + dir[0];
      int y = j + dir[1];
      DFS(grid, row, col, x, y); 
    }
  }
}



