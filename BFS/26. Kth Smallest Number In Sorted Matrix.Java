
/*
Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.

Assumptions

the matrix is not null, N > 0 and M > 0
K > 0 and K <= N * M
Examples

{ {1,  3,   5,  7},

  {2,  4,   8,   9},

  {3,  5, 11, 15},

  {6,  8, 13, 18} }

the 5th smallest number is 4
the 8th smallest number is 6
*/


public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    // Write your solution here
    PriorityQueue<Element> minHeap = new PriorityQueue<>(new ElementComparator());
    boolean[][] ifOfferToHeap = new boolean[matrix.length][matrix[0].length];
    minHeap.offer(new Element(matrix[0][0], 0, 0));
    for(int i = 0; i < k - 1; i++) {
      Element curr = minHeap.poll();
      if(curr.row + 1 < matrix.length && ifOfferToHeap[curr.row + 1][curr.col] == false) {
        minHeap.offer(new Element(matrix[curr.row + 1][curr.col], curr.row + 1, curr.col));
        ifOfferToHeap[curr.row + 1][curr.col] = true;
      }
       if(curr.col + 1 < matrix[0].length && ifOfferToHeap[curr.row][curr.col + 1] == false) {
        minHeap.offer(new Element(matrix[curr.row][curr.col + 1], curr.row, curr.col + 1));
        ifOfferToHeap[curr.row][curr.col + 1] = true;
      }
    }
    return minHeap.peek().value;
  }
  public class Element{
    int value;
    int row;
    int col;
    public Element(int value, int row, int col){
      this.value = value;
      this.row = row;
      this.col = col;
    }
  }

  public class ElementComparator implements Comparator<Element> {
    public int compare(Element e1, Element e2) {
      if(e1.value == e2.value) {
        return 0;
      }
      else if(e1.value < e2.value) {
        return -1;
      }
      else {
        return 1;
      }
    }
  }
}


