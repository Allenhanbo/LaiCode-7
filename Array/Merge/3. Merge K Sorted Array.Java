
/*
Merge K sorted array into one big sorted array in ascending order.

Assumptions

The input arrayOfArrays is not null, none of the arrays is null either.
*/

public class Solution {
  public int[] merge(int[][] arrayOfArrays) {
    // Write your solution here
    if(arrayOfArrays == null || arrayOfArrays.length == 0) {
      return new int[0];
    }
    int row = arrayOfArrays.length;
    List<Integer> result = new ArrayList<>();
    PriorityQueue<Element> minHeap = new PriorityQueue<Element>(row);
    for(int i = 0; i < row; i++) {
      if(arrayOfArrays[i].length == 0) {
        continue;
      }
      minHeap.offer(new Element(i, 0, arrayOfArrays[i][0]));
    }
    while(!minHeap.isEmpty()) {
      Element curr = minHeap.poll();
      result.add(arrayOfArrays[curr.row][curr.col]);
      int col = arrayOfArrays[curr.row].length;
      if(curr.col + 1 < col) {
        minHeap.offer(new Element(curr.row, curr.col + 1, arrayOfArrays[curr.row][curr.col + 1]));
      }
    }
    int[] solution = new int[result.size()];
    for(int i = 0; i < result.size(); i++) {
      solution[i] = result.get(i);
    }
    return solution;
  }
  public class Element implements Comparable<Element>{
    public int row;
    public int col;
    public int value;
    public Element(int row, int col, int value) {
      this.row = row;
      this.col = col;
      this.value = value;
    }
    @Override
    public int compareTo(Element other) {
      if(this.value == other.value) {
        return 0;
      }
      return this.value < other.value ? -1 : 1;
    }
  }
}




