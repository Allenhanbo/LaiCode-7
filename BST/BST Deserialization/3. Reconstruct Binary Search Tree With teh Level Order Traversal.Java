
/*
Given the levelorder traversal sequence of a binary search tree, reconstruct the original tree.

Assumptions

The given sequence is not null
There are no duplicate keys in the binary search tree
Examples

levelorder traversal = {5, 3, 8, 1, 4, 11}

the corresponding binary search tree is

        5

      /    \

    3        8

  /   \        \

1      4        11

How is the binary tree represented?

We use the pre order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:

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
  public TreeNode reconstruct(int[] level) {
    // Write your solution here
    if(level.length == 0) {
      return null;
    }
    List<Integer> levelOrder = new ArrayList<>();
    for(int i = 0; i < level.length; i++) {
      levelOrder.add(level[i]);
    }
    return reconstructHelper(levelOrder);
  }
  public TreeNode reconstructHelper(List<Integer> level) {
    if(level.size() == 0) {
      return null;
    }
    TreeNode root = new TreeNode(level.get(0));
    if(level.size() == 1) {
      return root;
    }
    List<Integer> leftLevel = new ArrayList<>();
    List<Integer> rightLevel = new ArrayList<>();
    for(int i = 1; i < level.size(); i++) {
      if(level.get(i) < root.key) {
        leftLevel.add(level.get(i));
      }
      else {
        rightLevel.add(level.get(i));
      }
    }
    root.left = reconstructHelper(leftLevel);
    root.right = reconstructHelper(rightLevel);
    return root;
  }
}


