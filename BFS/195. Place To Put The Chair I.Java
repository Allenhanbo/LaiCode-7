
/*
Given a gym with k pieces of equipment and some obstacles.  We bought a chair and wanted to put this chair into the gym such that  the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. The gym is represented by a char matrix, ‘E’ denotes a cell with equipment, ‘O’ denotes a cell with an obstacle, 'C' denotes a cell without any equipment or obstacle. You can only move to neighboring cells (left, right, up, down) if the neighboring cell is not an obstacle. The cost of moving from one cell to its neighbor is 1. You can not put the chair on a cell with equipment or obstacle.

Assumptions

There is at least one equipment in the gym
The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
It is guaranteed that each 'C' cell is reachable from all 'E' cells.
If there does not exist such place to put the chair, just return {-1, -1}
Examples

{ { 'E', 'O', 'C' },

  {  'C', 'E',  'C' },

  {  'C',  'C',  'C' } }

we should put the chair at (1, 0), so that the sum of cost from the chair to the two equipment is 1 + 1 = 2, which is minimal.
*/


public class Solution {
  public List<Integer> putChair(char[][] gym) {
	    // Write your solution here
	    List<Integer> result = new ArrayList<>();
	    result.add(-1);
	    result.add(-1);
	    int minSum = Integer.MAX_VALUE;
	    int row = gym.length;
	    int col = gym[0].length;
	    int[][] path = new int[row][col];
	    PriorityQueue<Cell> minHeap = new PriorityQueue<>();
        HashSet<Cell> visited = new HashSet<>();
	    for(int i = 0; i < row; i++) {
	      for(int j = 0; j < col; j++) {
	    	  	if(gym[i][j] == 'O' || gym[i][j] == 'E') {
	    	  		continue;
	    	  	}
	        int sum = 0;
	        minHeap.clear();
	        visited.clear();
	        // initialize path[][]	        
	        for(int m = 0; m < row; m++) {
	          for(int n = 0; n < col; n++) {
	            path[m][n] = -1;
	          }
	        }
	        //path[i][j] = 0;
	        Cell start = new Cell(i, j, 0);
	        minHeap.offer(start);
	        visited.add(start);
	        
	        while(!minHeap.isEmpty()) {
	          Cell curr = minHeap.poll();
	          int currRow = curr.row;
	          int currCol = curr.col;
	          int currDis = curr.distance;
	          // update distance in Path[][]
	            path[currRow][currCol] = currDis;
	        
	          // offer cell in 4 directions
	          if(currRow - 1 >= 0 && gym[currRow - 1][currCol] != 'O') {
	            Cell top = new Cell(currRow - 1, currCol , currDis + 1);
	            if(!visited.contains(top)) {
	            	 	minHeap.offer(top);
	            	 	visited.add(top);
	            }
	          }
	          if(currRow + 1 < row && gym[currRow + 1][currCol] != 'O') {
	            Cell bottom = new Cell(currRow + 1, currCol, currDis + 1);
	            if(!visited.contains(bottom)) {
	            		minHeap.offer(bottom);
	            		visited.add(bottom);
	            }
	          }
	          if(currCol - 1 >= 0 && gym[currRow][currCol - 1] != 'O') {
	            Cell left = new Cell(currRow, currCol - 1, currDis + 1);
	            if(!visited.contains(left)) {
	            		minHeap.offer(left);
	            		visited.add(left);
	            }
	          }
	           if(currCol + 1 < col && gym[currRow][currCol + 1] != 'O') {
	            Cell right = new Cell(currRow, currCol + 1, currDis + 1);
	            if(!visited.contains(right)) {
	            	 	minHeap.offer(right);
	            	 	visited.add(right);
	            }
	          }
	        }// end while
	        
	        for(int p = 0; p < row; p++) {
	          for(int q = 0; q < col; q++) {
	            if(gym[p][q] == 'E') {
	              sum += path[p][q];
	            }
	          }
	        }
	        
	        if(sum < minSum) {
	          minSum = sum;
	          result.clear();
	          result.add(i);
	          result.add(j);
	        }
	      }
	    }
	    return result;
	  }
	
	  public class Cell implements Comparable<Cell> {
	    int row;
	    int col;
	    int distance;
	    public Cell(int row, int col, int distance) {
	      this.row = row;
	      this.col = col;
	      this.distance = distance;
	    }
	    public int compareTo(Cell other) {
	      if(this.distance == other.distance) {
	        return 0;
	      }
	      return this.distance < other.distance ? -1 : 1;
	    }
	    public boolean equals(Object obj) {
	    		if(obj == this) {
	    			return true;
	    		}
	    		if(!(obj instanceof Cell)) {
	    			return false;
	    		}
	    		Cell another = (Cell)obj;
	    		return this.row == another.row && this.col == another.col;
	    }
	    public int hashCode() {
	    		return this.row * 31 * 31 + this.col * 31;
	    }
	  }
}
