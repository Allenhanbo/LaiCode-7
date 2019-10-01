
/*
Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.

Assumptions

K >= 1
Examples

the smallest is 3 * 5 * 7 = 105
the 2nd smallest is 3 ^ 2 * 5 * 7 = 315
the 3rd smallest is 3 * 5 ^ 2 * 7 = 525
the 5th smallest is 3 ^ 3 * 5 * 7 = 945
*/


public class Solution {
  public long kth(int k) {
    // poll (i, j, k)
    // offer(i+1, j, k), (i, j+1, k), (i, j, k+1)
    PriorityQueue<Element> minHeap = new PriorityQueue<>();
    HashSet<Element> set = new HashSet<>();
    int count = 0;
    minHeap.offer(new Element(1, 1, 1));
    while(count < k - 1) {
      Element curr = minHeap.poll();
      Element next = new Element(curr.i + 1, curr.j, curr.k);
      if(!set.contains(next)) {
        set.add(next);
        minHeap.offer(next);
      }
      next = new Element(curr.i, curr.j + 1, curr.k);
      if(!set.contains(next)) {
        set.add(next);
        minHeap.offer(next);
      }
      next = new Element(curr.i, curr.j, curr.k + 1);
      if(!set.contains(next)) {
        set.add(next);
        minHeap.offer(next);
      }
      count++;
    }
    Element result = minHeap.poll();
    return compute(result.i, result.j, result.k);
  }

  public class Element implements Comparable<Element> {
    int i;
    int j;
    int k;
    public Element(int i, int j, int k) {
      this.i = i;
      this.j = j;
      this.k = k;
    }
    public int compareTo(Element other) {
      long currElement = compute(this.i, this.j, this.k);
      long otherElement = compute(other.i, other.j, other.k);
      if(currElement == otherElement) {
        return 0;
      }
      return currElement < otherElement ? -1 : 1;
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
      return this.i == other.i && this.j == other.j && this.k == other.k;
    }
    @Override
    public int hashCode() {
      return i * 31 * 31 + j * 31 + k;
    }
  }

  public long compute(int i, int j, int k) {
    return (long)(Math.pow(3, i) * Math.pow(5, j) * Math.pow(7, k));
  }
}




