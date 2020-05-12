
/*
481. Count Univalue Subtrees

Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,

              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
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

// Method 1: return int each subtree
// if a node return Integer.MIN_VALUE, it means the node is null;
// if a node return Integer.MAX_VALUE, it means the subtree is not univalue.
// else return node's key
public class Solution {
  public int countUnivalSubtrees(TreeNode root) {
    // Write your solution here
    if(root == null) {
      return 0;
    }
    int[] result = new int[1];
    result[0] = 0;
    countUnivalSubtreesHelper(root, result);
    return result[0];
  }
  
  public int countUnivalSubtreesHelper(TreeNode root, int[] result) {
    if(root == null) {
      return Integer.MIN_VALUE;
    }
    if(root.left == null && root.right == null) {
      result[0]++;
      return root.key;
    }
    int left = countUnivalSubtreesHelper(root.left, result);
    int right = countUnivalSubtreesHelper(root.right, result);
    if(left == right && left == root.key) {
      result[0]++;
      return root.key;
    }
    else if(left == Integer.MIN_VALUE && right == root.key) {
      result[0]++;
      return root.key;
    }
    else if(right == Integer.MIN_VALUE && left == root.key) {
      result[0]++;
      return root.key;
    }
    else {
      return Integer.MAX_VALUE;
    }
  }
}


// Method 2: 
public class Solution {
  public int countUnivalSubtrees(TreeNode root) {
    // Write your solution here
    if(root == null) {
      return 0;
    }
    int[] result = new int[1];
    result[0] = 0;
    countUnivalSubtreesHelper(root, result);
    return result[0];
  }
  
  public boolean countUnivalSubtreesHelper(TreeNode root, int[] result) {
    if(root == null) {
      return true;
    }
    boolean left = countUnivalSubtreesHelper(root.left, result);
    boolean right = countUnivalSubtreesHelper(root.right, result);
    if(left && right && (root.left == null || root.left.key == root.key) && (root.right == null || root.right.key == root.key)) {
      result[0]++;
      return true;
    }
    return false;
  }
}


