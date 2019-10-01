
/*
Given three arrays sorted in ascending order. Pull one number from each array to form a coordinate <x,y,z> in a 3D space. Find the coordinates of the points that is k-th closest to <0,0,0>.

We are using euclidean distance here.

Assumptions

The three given arrays are not null or empty, containing only non-negative numbers
K >= 1 and K <= a.length * b.length * c.length
Return

a size 3 integer list, the first element should be from the first array, the second element should be from the second array and the third should be from the third array
Examples

A = {1, 3, 5}, B = {2, 4}, C = {3, 6}
The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)
The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)
*/


public class Solution {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    // Write your solution here
    PriorityQueue<Element> minHeap = new PriorityQueue<>();
    HashSet<Element> set = new HashSet<>();
    int count = 0;
    minHeap.offer(new Element(0, a[0], 0, b[0], 0, c[0]));
    while(count < k - 1) {
      Element curr = minHeap.poll();
      if(curr.aIndex + 1 < a.length) {
        Element next1 = new Element(curr.aIndex + 1, a[curr.aIndex + 1], curr.bIndex, b[curr.bIndex], curr.cIndex, c[curr.cIndex]);
        if(!set.contains(next1)) {
          set.add(next1);
          minHeap.offer(next1);
        }
      }
      if(curr.bIndex + 1 < b.length) {
        Element next2 = new Element(curr.aIndex, a[curr.aIndex], curr.bIndex + 1, b[curr.bIndex + 1], curr.cIndex, c[curr.cIndex]);
        if(!set.contains(next2)) {
          set.add(next2);
          minHeap.offer(next2);
        }
      }
      if(curr.cIndex + 1 < c.length) {
        Element next3 = new Element(curr.aIndex, a[curr.aIndex], curr.bIndex, b[curr.bIndex], curr.cIndex + 1, c[curr.cIndex + 1]);
        if(!set.contains(next3)) {
          set.add(next3);
          minHeap.offer(next3);
        }
      }
      count++;
    }
    Element curr = minHeap.poll();
    List<Integer> result = new ArrayList<>();
    result.add(curr.aValue); 
    result.add(curr.bValue); 
    result.add(curr.cValue); 
    return result;
  }
  
  public class Element implements Comparable<Element> {
    int aIndex;
    int aValue;
    int bIndex;
    int bValue;
    int cIndex;
    int cValue;
    public Element (int aIndex, int aValue, int bIndex, int bValue, int cIndex, int cValue) {
      this.aIndex = aIndex;
      this.aValue = aValue;
      this.bIndex = bIndex;
      this.bValue = bValue;
      this.cIndex = cIndex;
      this.cValue = cValue;
    }
    @Override
    public int compareTo(Element other) {
      int curr = compute(this.aValue, this.bValue, this.cValue);
      int another = compute(other.aValue, other.bValue, other.cValue);
      if(curr == another) {
        return 0;
      }
      return curr - another < 0 ? -1 : 1;
    }
    @Override
    public boolean equals(Object obj) {
      if(obj == this) {
        return true;
      }
      if(!(obj instanceof Element)) {
        return false;
      }
      Element other = (Element)obj;
      return this.aValue == other.aValue && this.bValue == other.bValue && this.cValue == other.cValue;
    }
    @Override
    public int hashCode() {
      return aValue * 31 * 31 + bValue * 31 + cValue;
    }
  }

  public int compute(int a, int b, int c) {
    return (int)(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
  }
}





