
/*
Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf node to another leaf node. If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).

Examples

  -15

  /    \

2      11

     /    \

    6     14

The maximum path sum is 6 + 11 + 14 = 31.

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
/*
  root
  / \
left right
*/
public class Solution {
  public int maxPathSum(TreeNode root) {
    // Write your solution here
    if(root == null) {
      return Integer.MIN_VALUE;
    }
    int[] maxSum = new int[1];
    maxSum[0] = Integer.MIN_VALUE;
    maxPathSumHelper(root, maxSum);
    return maxSum[0];
  }
  // return sum
  private int maxPathSumHelper(TreeNode root, int[] maxSum) {
    // base case
    if(root == null) {
      return 0;
    }
    int left = maxPathSumHelper(root.left, maxSum);
    int right = maxPathSumHelper(root.right, maxSum);
    if(root.left == null && root.right == null) {
      return root.key;
    }
    else if(root.left == null) {
      return right + root.key;
    }
    else if(root.right == null) {
      return left + root.key;
    }
    maxSum[0] = Math.max(maxSum[0], left + right + root.key);
    return Math.max(left, right) + root.key;
  }
}






