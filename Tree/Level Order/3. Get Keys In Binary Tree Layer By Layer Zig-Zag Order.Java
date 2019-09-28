
/*
Get the list of keys in a given binary tree layer by layer in zig-zag order.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

the result is [5, 3, 8, 11, 4, 1]

Corner Cases

What if the binary tree is null? Return an empty list in this case.
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
  public List<Integer> zigZag(TreeNode root) {
    // Write your solution here
    // 5 那层是偶数层，3 8 是奇数层
    // 奇数层：pollFirst，offerLast， 1 4 11
    // 偶数层：pollLast, offerFirst
    List<Integer> result = new ArrayList<>();
    if(root == null) {
      return result;
    }
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offerLast(root);
    int level = 0;
    while(!deque.isEmpty()) {
      int size = deque.size();
      TreeNode curr = null;
      for(int i = 0; i < size; i++) {
        if(level % 2 == 1) {
          curr = deque.pollFirst();
          if(curr.left != null) {
            deque.offerLast(curr.left);
          }
          if(curr.right != null) {
            deque.offerLast(curr.right);
          }
        }
        else {
          curr = deque.pollLast();
           if(curr.right != null) {
            deque.offerFirst(curr.right);
          }
          if(curr.left != null) {
            deque.offerFirst(curr.left);
          }
        }
        result.add(curr.key);
      }
      level++;
    }
    return result;
  }
}


