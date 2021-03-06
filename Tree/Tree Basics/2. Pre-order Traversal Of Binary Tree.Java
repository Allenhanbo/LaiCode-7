
/*
Implement an iterative, pre-order traversal of a given binary tree, return the list of keys of each node in the tree as it is pre-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Pre-order traversal is [5, 3, 1, 4, 8, 11]

Corner Cases

What if the given binary tree is null? Return an empty list in this case.
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
  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here
    List<Integer> list = new ArrayList<>();
    if (root == null) {
        return list;
    }
    preOrder(root, list);
    return list;
  }
  public void preOrder(TreeNode root, List<Integer> list) {
      if (root == null) {
          return;
      }
      list.add(root.key);
      preOrder(root.left, list);
      preOrder(root.right, list);
  }
}



public class Solution {
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root == null) {
      return result;
    }
    Deque<TreeNode> stack = new LinkedList<>();
    stack.offerFirst(root);
    while(!stack.isEmpty()) {
      root = stack.pollFirst();
      result.add(root.key);
      if(root.right != null) {
        stack.offerFirst(root.right);
      }
      if(root.left != null) {
        stack.offerFirst(root.left);
      }
    }
    return result;
  }
}







