
/*
Get the list of list of keys in a given binary tree layer by layer. Each layer is represented by a list of keys and the keys are traversed from left to right.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

the result is [ [5], [3, 8], [1, 4, 11] ]

Corner Cases

What if the binary tree is null? Return an empty list of list in this case.
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
  public List<List<Integer>> layerByLayer(TreeNode root) {
    // Write your solution here
    // 用一个queue实现，expand 1 node, generate 2 nodes
    List<List<Integer>> result = new ArrayList<>();
    if(root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currList = new ArrayList<>();
      for(int i = 0; i < size; i++) {
        TreeNode currNode = queue.poll();
        currList.add(currNode.key);
        if(currNode.left != null) {
          queue.offer(currNode.left);
        }
        if(currNode.right != null) {
          queue.offer(currNode.right);
        }
      }
      result.add(currList);
    }
    return result;
  }
}

