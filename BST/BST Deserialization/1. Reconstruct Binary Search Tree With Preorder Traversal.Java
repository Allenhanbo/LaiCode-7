
/*
Given the preorder traversal sequence of a binary search tree, reconstruct the original tree.

Assumptions

The given sequence is not null
There are no duplicate keys in the binary search tree
Examples

preorder traversal = {5, 3, 1, 4, 8, 11}

The corresponding binary search tree is

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
  public TreeNode reconstruct(int[] pre) {
    // Write your solution here
/*
     10 
   /    \
  5      15
 / \     / \
2   7  12   20
index     0  1  2  3  4  5  6
pre-order 10 5  2  7  15 12 20
*/
    if(pre.length == 0) {
      return null;
    }
    List<Integer> preOrder = new ArrayList<>();
    for(int i = 0; i < pre.length; i++) {
      preOrder.add(pre[i]);
    }
    return reconstructHelper(preOrder);
  }
  public TreeNode reconstructHelper(List<Integer> preOrder) {
    if(preOrder.size() == 0) {
      return null;
    }
    TreeNode root = new TreeNode(preOrder.get(0));
    if(preOrder.size() == 1) {
      return root;
    }
    List<Integer> preLeft = new ArrayList<>();
    List<Integer> preRight = new ArrayList<>();
    for(int i = 1; i < preOrder.size(); i++) {
      if(preOrder.get(i) < root.key) {
        preLeft.add(preOrder.get(i));
      }
      else {
        preRight.add(preOrder.get(i));
      }
    }
    root.left = reconstructHelper(preLeft);
    root.right = reconstructHelper(preRight);
    return root;
  }
}



