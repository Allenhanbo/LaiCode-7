
/*
Given two sorted arrays A and B, of sizes m and n respectively. Define s = a + b, where a is one element from A and b is one element from B. Find the Kth smallest s out of all possible s'.

Assumptions

A is not null and A is not of zero length, so as B
K > 0 and K <= m * n
Examples

A = {1, 3, 5}, B = {4, 8}

1st smallest s is 1 + 4 = 5
2nd smallest s is 3 + 4 = 7
3rd, 4th smallest s are 9 (1 + 8, 4 + 5) 
5th smallest s is 3 + 8 = 11
*/


public class Solution {
  public int kthSum(int[] A, int[] B, int k) {
	    // 这个题目不能用two pointers
	    // 因为 A = {1, 3, 5}, B = {4, 8} 
	    // 1 + 8 = 9, 4 + 5 = 9, two pointers 可以找到4+5，不能找到1+8
	    PriorityQueue<Element> minHeap = new PriorityQueue<>();
      Element start = new Element(A[0], 0, B[0], 0);
	    minHeap.offer(start);
	    HashSet<Element> set = new HashSet<>();
	    set.add(start);
	    for(int i = 0; i < k - 1; i++) {
	      Element curr = minHeap.poll();
	      int aIndex = curr.aIndex;
	      int bIndex = curr.bIndex;
	      if(aIndex + 1 < A.length) {
	    	  	Element next = new Element(A[aIndex + 1], aIndex + 1, B[bIndex], bIndex);
	    	  	if(!set.contains(next)) {
	    	  		 minHeap.offer(next);
	    	  		 set.add(next);
	    	  	}
	      }
	      if(bIndex + 1 < B.length) {
	    	  	Element next = new Element(A[aIndex], aIndex, B[bIndex + 1], bIndex + 1);
	    	  	if(!set.contains(next)) {
	    	  		 minHeap.offer(next);
	    	  		 set.add(next);
	    	  	}
	      }
	    }
	    Element result = minHeap.peek();
	    //System.out.println("aValue = " + result.aValue + ", bValue = " + result.bValue);
	    return result.aValue + result.bValue;
	  }
	  public class Element implements Comparable<Element>{
	    int aValue;
	    int aIndex;
	    int bValue;
	    int bIndex;
	    public Element(int aValue, int aIndex, int bValue, int bIndex) {
	      this.aValue = aValue;
	      this.aIndex = aIndex;
	      this.bValue = bValue;
	      this.bIndex = bIndex;
	    }
	    @Override
	    public boolean equals(Object obj) {
	    		if(this == obj) {
	    			return true;
	    		}
	    		if(!(obj instanceof Element)) {
	    			return false;
	    		}
	    		Element another = (Element)obj;
	    		return this.aIndex == another.aIndex && this.bIndex == another.bIndex;
	    }
	    @Override
	    public int hashCode() {
	    		return this.aIndex * 31 + this.bIndex;
	    }
	    @Override
	    public int compareTo(Element another) {
	      int sum1 = this.aValue + this.bValue;
	      int sum2 = another.aValue + another.bValue;
	      if(sum1 == sum2) {
	        return 0;
	      }
	      return sum1 < sum2 ? -1 : 1;
	    }
	  }
}
