
/*
Implement an iterative, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

In-order traversal is [1, 3, 4, 5, 8, 11]

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
  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here
    List<Integer> list = new ArrayList<>();
    if (root == null) {
        return list;
    }
    inOrder(root, list);
    return list;
  }
  public void inOrder(TreeNode root, List<Integer> list) {
      if (root == null) {
          
      }
      inOrder(root.left, list);
      list.add(root.key);
      inOrder(root.right, list);
  }
}



public class Solution {
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root == null) {
      return result;
    }
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode curr = root;
    while(curr != null || !stack.isEmpty()) {
      if(curr != null) {
        stack.offerFirst(curr);
        curr = curr.left;
      }
      else {
        curr = stack.pollFirst();
        result.add(curr.key);
        curr = curr.right;
      }
    }
    return result;
  }
}





