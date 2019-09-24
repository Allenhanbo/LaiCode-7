
/*
Check if a given binary tree is balanced. A balanced binary tree is one in which the depths of every node’s left and right subtree differ by at most 1.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

is balanced binary tree,

        5

      /

    3
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
  public boolean isBalanced(TreeNode root) {
    // Write your solution here
    if (root == null) {
        return true;
    }
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    if (Math.abs(left - right) > 1) {
        return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }

  public int getHeight(TreeNode root) {
      if (root == null) {
          return 0;
      }
      int left = getHeight(root.left);
      int right = getHeight(root.right);
      return 1 + Math.max(left, right);
  }
}



public class Solution {
  public boolean isBalanced(TreeNode root) {
    // Write your solution here
    if(root == null) {
      return true;
    }
    int result = getHeight(root);
    return result < 0 ? false : true;
  }
  // if Math.abs(leftSubtree - rightSubtree) > 1, return -1; 
  // else, return the max height of one path = the height of the tree
  public int getHeight(TreeNode root) {
    // base case
    if(root == null) {
      return 0;
    }
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    if(Math.abs(right - left) > 1 || left == -1 || right == -1) {
      return -1;
    }
    return Math.max(left, right) + 1;
  }
}




