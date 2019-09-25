
/*
Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).

Return null If any of the nodes is not in the tree.

Assumptions

There is no parent pointer for the nodes in the binary tree
The given two nodes are not guaranteed to be in the binary tree
Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
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
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
    // write your solution here
    if(root == null || one == null || two == null) {
      return null;
    }
    TreeNode curr = lowestCommonAncestorHelper(root, one, two);
    if(curr == null) {
      return null;
    }
    else if(curr != one && curr != two) {
      return curr;
    }
    else if(curr == one) {
      return findTreeNode(one, two) == true ? one : null;
    }
    else {
       return findTreeNode(two, one) == true ? two : null;
    }
  }

  public TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode one, TreeNode two) {
    if(root == null || root == one || root == two) {
      return root;
    }
    TreeNode left = lowestCommonAncestorHelper(root.left, one, two);
    TreeNode right = lowestCommonAncestorHelper(root.right, one, two);
    if(left == null && right == null){
      return null;
    }
    else if(left == null) {
      return right;
    }
    else if(right == null) {
      return left;
    }
    else {
      return root;
    }
  }
  private boolean findTreeNode(TreeNode root, TreeNode target) {
    if(root == null) {
      return false;
    }
    if(root == target) {
      return true;
    }
    return findTreeNode(root.left, target) || findTreeNode(root.right, target);
  }
}
