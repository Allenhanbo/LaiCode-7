
/*
Implement an iterative, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Post-order traversal is [1, 4, 3, 11, 8, 5]

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
  public List<Integer> postOrder(TreeNode root) {
    // Write your solution here
    List<Integer> list = new ArrayList<>();
    if (root == null) {
        return list;
    }
    postOrder(root, list);
    return list;
  }
    public void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.key);
    }
}



public class Solution {
  public List<Integer> postOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root == null) {
      return result;
    }
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode prev = null;
    stack.offerFirst(root);
    while(!stack.isEmpty()) {
      TreeNode curr = stack.peekFirst();
      if(prev == null || curr == prev.left || curr == prev.right) {
        if(curr.left != null) {
          stack.offerFirst(curr.left);
        }
        else if(curr.right != null) {
          stack.offerFirst(curr.right);
        }
        else {
          result.add(curr.key);
          stack.pollFirst();
        }
      }
      else if(prev == curr.left) {
        if(curr.right != null) {
          stack.offerFirst(curr.right);
        }
        else {
          result.add(curr.key);
          stack.pollFirst();
        }
      }
      else {
        result.add(curr.key);
        stack.pollFirst();
      }
      prev = curr;
    }
    return result;
  }
}







