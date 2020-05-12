
/*
Consider an unlimited flow of data elements. How do you sample k element from this flow, such that at any point during the processing of the flow, you can return a random set of k elements from the n elements read so far. 

Assumptions

k >= 1
You will implement two methods for a sampling class:

read(int value) - read one number from the flow
sample() - return at any time the k samples as a list, return the list of all values read when the number of values read so fas <= k.
You may need to add more fields for the class.
*/


public class Solution {
  private final int k;
  private List<Integer> flow = new ArrayList<>();
  private List<Integer> result = new ArrayList<>();
  
  public Solution(int k) {
    // Complete the constructor if necessary.
    this.k = k;
  }
  
  public void read(int value) {
    // Write your implementation here.
    flow.add(value);
    if(flow.size() <= k) {
      result.add(value);
    }
  }
  
  public List<Integer> sample() {
    // Write your implementation here.
    if(flow.size() <= k) {
      return result;
    }
    int randomIndex = (int)(Math.random() * flow.size());
    if(randomIndex < k) {
      result.set(randomIndex, flow.get(flow.size() - 1));
    }
    return result;
  }
}
