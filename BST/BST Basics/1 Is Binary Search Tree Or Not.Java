
/*
Determine if a given binary tree is binary search tree.There should no be duplicate keys in binary search tree.

Assumptions

You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.
Corner Cases

What if the binary tree is null? Return true in this case.
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
  public boolean isBST(TreeNode root) {
    // Write your solution here
    if(root == null) {
        return true;
    }
    return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public boolean isBSTHelper(TreeNode root, int min, int max) {
    if(root == null) {
        return true;
    }
    if(root.key >= max || root.key <= min) {
        return false;
    }
    return isBSTHelper(root.left, min, root.key) && isBSTHelper(root.right, root.key, max);
  }
}

