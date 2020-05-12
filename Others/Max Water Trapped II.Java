
/*
Given a non-negative integer 2D array representing the heights of bars in a matrix. Suppose each bar has length and width of 1. Find the largest amount of water that can be trapped in the matrix. The water can flow into a neighboring bar if the neighboring bar's height is smaller than the water's height. Each bar has 4 neighboring bars to the left, right, up and down side.

Assumptions

The given matrix is not null and has size of M * N, where M > 0 and N > 0, all the values are non-negative integers in the matrix.
Examples

{ { 2, 3, 4, 2 },

  { 3, 1, 2, 3 },

  { 4, 3, 5, 4 } }

the amount of water can be trapped is 3, 

at position (1, 1) there is 2 units of water trapped,

at position (1, 2) there is 1 unit of water trapped.
*/


public class Solution {
  public int maxTrapped(int[][] matrix) {
    // Write your solution here
    /*
    for every point Pi <xi, yi, zi> on the border, set the water level to <zi> 
    for every point Pj not on the border, set the water level to infinity
    insert all Pi into minHeap(= set of active points)
    while minHeap is not empty: // best first search(BFS2)
      p = minHeap.pop(); // select the active point P with minimum level
	    sum += level(p) - height(p);
	    for every point q adjacent to p: 
		    level(q) = max(height(q), min(level(q)), level(p))）
		    if level(q) was changed: add q to the minHeap if it is not there yet
height[] 表示木桶有多高; level[] 表示水面有多高
*/
    int row = matrix.length;
    int col = matrix[0].length;
    if(row <= 2 || col <= 2) {
      return 0;
    }
    int[][] level = new int[row][col];
    PriorityQueue<Bar> minHeap = new PriorityQueue<>();
    HashSet<Bar> set = new HashSet<>();
    // initialize height[][]
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        if(i == 0 || i == row - 1 || j == 0 || j == col - 1) {
          level[i][j] = matrix[i][j];
          Bar curr = new Bar(i, j, level[i][j]);
          minHeap.offer(curr);
          set.add(curr);
        }
        else {
          level[i][j] = Integer.MAX_VALUE;
        }
      }
    }
    /*
     while minHeap is not empty: // best first search(BFS2)
      p = minHeap.pop(); // select the active point P with minimum level
	    sum += level(p) - height(p);
	    for every point q adjacent to p: 
		    level(q) = max(height(q), min(level(q)), level(p))）
		    if level(q) was changed: add q to the minHeap if it is not there yet
    */
    int sum = 0;
    while(!minHeap.isEmpty()) {
      Bar curr = minHeap.poll();
      int currRow = curr.row;
      int currCol = curr.col;
      //int level = curr.level;
      // 这里特别巧妙！！！不用以后再遍历level[][]
      sum += level[currRow][currCol] - matrix[currRow][currCol];
       // top
      if(currRow - 1 >= 0) {
        level[currRow - 1][currCol] = Math.max(matrix[currRow - 1][currCol], Math.min(level[currRow][currCol], level[currRow - 1][currCol]));
        Bar top = new Bar(currRow - 1, currCol, level[currRow - 1][currCol]);
        if(!set.contains(top)) {
          minHeap.offer(top);
          set.add(top);
        }
      }
      // bottom
      if(currRow + 1 < row) {
        level[currRow + 1][currCol] = Math.max(matrix[currRow + 1][currCol], Math.min(level[currRow][currCol], level[currRow + 1][currCol]));
        Bar bottom = new Bar(currRow + 1, currCol, level[currRow + 1][currCol]);
        if(!set.contains(bottom)) {
          minHeap.offer(bottom);
          set.add(bottom);
        }
      }
      // left
      if(currCol - 1 >= 0) {
        level[currRow][currCol - 1] = Math.max(matrix[currRow][currCol - 1], Math.min(level[currRow][currCol], level[currRow][currCol - 1]));
        Bar left = new Bar(currRow, currCol - 1, level[currRow][currCol - 1]);
        if(!set.contains(left)) {
          minHeap.offer(left);
          set.add(left);
        }
      }
      // right
      if(currCol + 1 < col) {
        level[currRow][currCol + 1] = Math.max(matrix[currRow][currCol + 1], Math.min(level[currRow][currCol], level[currRow][currCol + 1]));
        Bar right = new Bar(currRow, currCol + 1, level[currRow][currCol + 1]);
        if(!set.contains(right)) {
          minHeap.offer(right);
          set.add(right);
        }
      }
    }
    return sum;
  }
  public class Bar implements Comparable<Bar> {
    int row;
    int col;
    int level;
    public Bar(int row, int col, int level) {
      this.row = row;
      this.col = col;
      this.level = level;
    }
    public int compareTo(Bar another) {
      if(this.level == another.level) {
        return 0;
      }
      return this.level < another.level ? -1 : 1;
    }
    public boolean equals(Object obj) {
      if(obj == this) {
        return true;
      }
      if(!(obj instanceof Bar)) {
        return false;
      }
      Bar another = (Bar)obj;
      return this.row == another.row && this.col == another.col;
    }
    public int hashCode() {
      return this.row * 31 + this.col;
    }
  }
}




