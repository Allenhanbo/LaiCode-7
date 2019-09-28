
/*
Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

Assumptions

The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree
Examples

preorder traversal = {5, 3, 1, 4, 8, 11}

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
  public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
    // Write your solution here
    if(inOrder.length == 0 || preOrder.length == 0) {
      return null;
    }
    HashMap<Integer, Integer> inOrderMap = new HashMap<>();
    for(int i = 0; i < inOrder.length; i++) {
      inOrderMap.put(inOrder[i], i);
    }
    return reconstructHelper(inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length - 1, inOrderMap);
  }

  public TreeNode reconstructHelper(int[] inOrder, int inLeft, int inRight, 
  int[] preOrder, int preLeft, int preRight, HashMap<Integer, Integer> inOrderMap) {
    /*
    index     0  1  2  3  4  5  6
    pre-order 10 5  2  7  15 12 20
    in-order  2  5  7  10 12 15 20
    preOrder第一个永远是当前的subtree的root node
    在inOrder里面找到它，然后把它的左右再recursion，因为它的左右就是left subtree和right subtree
    */
    if(inLeft > inRight) {
      return null;
    }
    TreeNode root = new TreeNode(preOrder[preLeft]);
    int inOrderIndex = inOrderMap.get(preOrder[preLeft]);
    int inOrderLeftLength = inOrderIndex - inLeft;
    root.left = reconstructHelper(inOrder, inLeft, inLeft + inOrderLeftLength - 1, 
    preOrder, preLeft + 1, preLeft + inOrderLeftLength, inOrderMap);
    root.right = reconstructHelper(inOrder, inLeft + inOrderLeftLength + 1, inRight, 
    preOrder, preLeft + inOrderLeftLength + 1, preRight, inOrderMap);
    return root;
  }
}





