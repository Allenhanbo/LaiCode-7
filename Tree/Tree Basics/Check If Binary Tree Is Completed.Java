
/*
Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.
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
  public boolean isCompleted(TreeNode root) {
    // Write your solution here
    if(root == null) {
      return true;
    }
    // int height = getHeight(root);
    // 是否之前出现了一个node是null
    boolean flag = false;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      if(curr == null) {
        flag = true;
      }
      else {
        if(flag) {
          return false;
        }
        queue.offer(curr.left);
        queue.offer(curr.right);
      }
    }    
    return true;
  }
  /*
  public int getHeight(TreeNode root) {
    if(root == null) {
      return 0;
    }
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    return Math.max(left, right) + 1;
  }
  */
}





