
/*
Given the postorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

Assumptions

The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree
Examples

postorder traversal = {1, 4, 3, 11, 8, 5}

inorder traversal = {1, 3, 4, 5, 8, 11}

the corresponding binary tree is

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
  public TreeNode reconstruct(int[] inOrder, int[] postOrder) {
    // Write your solution here
    /*
    index     0  1  2  3  4  5  6
    postOrder 1  3  2  6  8  7  5
    inOrder   1  2  3  5  6  7  8
    */
    if(inOrder.length == 0) {
      return null;
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < inOrder.length; i++) {
      map.put(inOrder[i], i);
    }
    return reconstructHelper(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1, map);
  }
  public TreeNode reconstructHelper(int[] inOrder, int inLeft, int inRight, 
  int[] postOrder, int postLeft, int postRight, HashMap<Integer, Integer> map) {
    if(inLeft > inRight) {
      return null;
    }
    TreeNode root = new TreeNode(postOrder[postRight]);
    int inOrderIndex = map.get(root.key);
    int inOrderLeftLength = inOrderIndex - inLeft;
    root.left = reconstructHelper(inOrder, inLeft, inLeft + inOrderLeftLength - 1,
    postOrder, postLeft, postLeft + inOrderLeftLength - 1, map);
    root.right = reconstructHelper(inOrder, inLeft + inOrderLeftLength + 1, inRight,
    postOrder, postLeft + inOrderLeftLength, postRight - 1, map);
    return root;
  }
}



