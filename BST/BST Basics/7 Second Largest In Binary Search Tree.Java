
/*
Find the second largest key in the given binary search tree.

If there does not exist the second largest key, return Integer.MIN_VALUE.

Assumptions:

The given binary search tree is not null.
Examples:

    2

  /   \

 1     4

      /

    3

the second largest key is 3.
*/


/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */

public class Solution {
  public int secondLargest(TreeNode root) {
    // Write your solution here
    if(root.right == null && root.left == null) {
        return Integer.MIN_VALUE;
    }
    TreeNode nextNode = root;
    Deque<TreeNode> stack = new LinkedList<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(2);
    int i = 0;
    while(nextNode != null || !stack.isEmpty()) {
        if(nextNode != null) {
            stack.offerFirst(nextNode);
            nextNode = nextNode.left;
        }
        else {
            nextNode = stack.pollFirst();
            if(i < 2) {
                minHeap.offer(nextNode.key);
                i++;
            }
            else {
                if(nextNode.key > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(nextNode.key);
                }
            }
            nextNode = nextNode.right;
        }
    }
    return minHeap.peek();
  }
}










