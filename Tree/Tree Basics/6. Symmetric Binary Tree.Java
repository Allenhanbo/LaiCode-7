
/*
Check if a given binary tree is symmetric.

Examples

        5

      /    \

    3        3

  /   \    /   \

1      4  4      1

is symmetric.

        5

      /    \

    3        3

  /   \    /   \

1      4  1      4

is not symmetric.

Corner Cases

What if the binary tree is null? Return true in this case.
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
  public boolean isSymmetric(TreeNode root) {
    // Write your solution here
    if (root == null) {
        return true;
    }
    return isSymmetric(root.left, root.right);
  }

  public boolean isSymmetric(TreeNode root1, TreeNode root2) {
      if (root1 == null && root2 == null) {
          return true;
      }
      else if (root1 == null || root2 == null) {
          return false;
      }
      else if (root1.key != root2.key) {
          return false;
      }
      return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
  }
}

