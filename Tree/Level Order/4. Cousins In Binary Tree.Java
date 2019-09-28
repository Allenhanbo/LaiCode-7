/*
Given a binary Tree and the two keys, determine whether the two nodes are cousins of each other or not. Two nodes are cousins of each other if they are at the same level and have different parents.

Assumptions:

It is not guranteed the two keys are all in the binary tree.
There are no duplicate keys in the binary tree.
Examples:

     6
   /   \
  3     5
 / \   / \

7   8 1   13
7 and 1, result is true.
3 and 5, result is false.
7 and 5, result is false.
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
  public boolean isCousin(TreeNode root, int a, int b) {
    // Write your solution here
    if(root == null || root.left == null && root.right == null) {
      return false;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      int size = queue.size();
      int count = 0;
      for(int i = 0; i < size; i++) {
        TreeNode curr = queue.poll();
        if(curr.left != null && curr.right != null) {
          if(curr.left.key == a && curr.right.key == b || curr.left.key == b && curr.right.key == a) {
            return false;
          }
        }
        if(curr.key == a || curr.key == b) {
          count++;
        }
        if( count == 2) {
          return true;
        }
        if(curr.left != null) {
          queue.offer(curr.left);
        }
        if(curr.right != null) {
          queue.offer(curr.right);
        }
      }
    }// end while
    return false;
  }
}





