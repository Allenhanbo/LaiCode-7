
/*
Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.

Assumptions

N > 0
Return

A list of ways of putting the N Queens
Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
Example

N = 4, there are two ways of putting 4 queens:

[1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3, the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.

[2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0, the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.
*/


public class Solution {
  public List<List<Integer>> nqueens(int n) {
	    // Write your solution here
	    int[][] board = new int[n][n];
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> curr = new ArrayList<Integer>();
	    nqueensHelper(n, 0, board, curr, result);
	    return result;
	  }
	
	  public void nqueensHelper(int n, int row, int[][] board, List<Integer> curr, List<List<Integer>> result) {
	    if(row == n) {
	    	List<Integer> queens = getQueens(curr);
	      result.add(queens);
	      return;
	    }
	    for(int col = 0; col < n; col++) {
	      if(check(row, col, board)) {
	        curr.add(col);
	        board[row][col] = 1;
	        nqueensHelper(n, row + 1, board, curr, result);
	        board[row][col] = 0;
	        curr.remove(curr.size() - 1);
	      } 
	    }
	  }
	  
	  public boolean check(int row, int col, int[][] board) {
	    for(int i = 0; i < row; i++) {
	      if(board[i][col] == 1) {
	        return false;
	      }
	      for(int j = 0; j < board.length; j++) {
	        if(board[i][j] == 1) {
	          if(Math.abs(i - row) == Math.abs(j - col)) {
	            return false;
	          }
	        }
	      }
	    }
	    return true;
	  }
	  
	  public List<Integer> getQueens(List<Integer> curr) {
		  List<Integer> queens = new ArrayList<>();
		  for(int i = 0; i < curr.size(); i++) {
			  queens.add(curr.get(i));
		  }
		  return queens;
	  }
}
