
/*
Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any node (the start node and the end node can be the same). 

Assumptions

​The root of the given binary tree is not null
Examples

   -1

  /    \

2      11

     /    \

    6    -14

one example of paths could be -14 -> 11 -> -1 -> 2

another example could be the node 11 itself

The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
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
  public int maxPathSum(TreeNode root) {
    // Write your solution here
    int[] maxSum = new int[1];
    maxSum[0] = Integer.MIN_VALUE;
    maxPathSumHelper(root, maxSum);
    return maxSum[0];
  }
  // return the max sum for one path from current node and its children
  public int maxPathSumHelper(TreeNode root, int[] maxSum) {
    if(root == null) {
      return 0;
    }
    int left = maxPathSumHelper(root.left, maxSum);
    int right = maxPathSumHelper(root.right, maxSum);
    left = left > 0 ? left : 0;
    right = right > 0 ? right : 0;
    maxSum[0] = Math.max(maxSum[0], root.key + left + right);
    return left > right ? (left + root.key) : (right + root.key);
  }
}





