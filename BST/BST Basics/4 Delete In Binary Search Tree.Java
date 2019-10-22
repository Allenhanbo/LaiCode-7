
/*
Delete the target key K in the given binary search tree if the binary search tree contains K. Return the root of the binary search tree.

Find your own way to delete the node from the binary search tree, after deletion the binary search tree's property should be maintained.

Assumptions

There are no duplicate keys in the binary search tree

The smallest larger node is first candidate after deletion
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
  public TreeNode deleteTree(TreeNode root, int key) {
    // Write your solution here
    if(root == null) {
        return root;
    }
    if(root.key > key) {
        root.left = deleteTree(root.left, key);
        return root;
    }
    else if(root.key < key) {
        root.right = deleteTree(root.right, key);
        return root;
    }
    // root != null && root.key = key
    if(root.left == null) {
        return root.right;
    }
    if(root.right == null) {
        return root.left;
    }
    // root.left != null && root.right != null
    if(root.right.left == null) {
        root.right.left = root.left;
        return root.right;
    }
    TreeNode smallest = rightSubTreeSmallest(root.right);
    smallest.left = root.left;
    smallest.right = root.right;
    return smallest;
  }
  private TreeNode rightSubTreeSmallest(TreeNode root) {
      TreeNode prev = root;
      TreeNode curr = root.left;
      while(curr.left != null) {
          prev = curr;
          curr = curr.left;
      }
      prev.left = curr.right;
      return curr;
  }
}



public class Solution {
  public TreeNode deleteTree(TreeNode root, int key) {
    // Write your solution here
    if(root == null) {
      return root;
    }
    if(root.key < key) {
      root.right = deleteTree(root.right, key);
      return root;
    }
    else if(root.key > key) {
      root.left = deleteTree(root.left, key);
      return root;
    }
    // root.key = key
    if(root.left == null) {
      return root.right;
    }
    if(root.right == null) {
      return root.left;
    }
    // root.left != null && root.right != null
/*3
 / \
2   8 (root)
   / \
  6   10 (root.right)
       \
        12
  3
 / \
2   10
   /  \
  6    12
*/
    // insert the smallest in the right subtree
    if(root.right.left == null) {
      root.right.left = root.left;
      return root.right;
    }
/*3
 / \
2   10
   /  \
  6    12
      /  \
    11    14
   /
  9
   \
    10
  3
 / \
2   9
   / \
  6   12
      /  \
    11    14
   /
 10
*/
    // insert the largest in the left subtree
    TreeNode smallest = findSmallest(root.right);
    smallest.left = root.left;
    smallest.right = root.right;
    return smallest;
  }
  private TreeNode findSmallest(TreeNode curr) {
    TreeNode prev = curr;
    curr = prev.left;
    while(curr.left != null) {
      prev = curr;
      curr = curr.left;
    }
    prev.left = prev.left.right;
    return curr;
  }
}

























