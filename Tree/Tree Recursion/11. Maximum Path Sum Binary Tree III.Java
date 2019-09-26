
/*
Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node).

Assumptions

The root of given binary tree is not null
Examples

   -5

  /    \

2      11

     /    \

    6     14

           /

        -3

The maximum path sum is 11 + 14 = 25

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
  public int maxPathSumHelper(TreeNode root, int[] maxSum) {
    if(root == null) {
      return 0;
    }
    int left = maxPathSumHelper(root.left, maxSum);
    int right = maxPathSumHelper(root.right, maxSum);
    left = left > 0 ? left : 0;
    right = right > 0 ? right : 0;
    int max = left > right ? left : right;
    maxSum[0] = Math.max(maxSum[0], max + root.key);
    return max + root.key;
  }
}





