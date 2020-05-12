
/*
Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

get the keys in [2, 5] in ascending order, result is  [3, 4, 5]

Corner Cases

What if there are no keys in the given range? Return an empty list in this case.
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
  public List<Integer> getRange(TreeNode root, int min, int max) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if(root == null) {
        return result;
    }
    TreeNode nextNode = root;
    Deque<TreeNode> stack = new LinkedList<>();
    while(nextNode != null || !stack.isEmpty()) {
        if(nextNode != null) {
            stack.offerFirst(nextNode);
            nextNode = nextNode.left;
        }
        else {
            nextNode = stack.pollFirst();
            if(nextNode.key >= min && nextNode.key <= max) {
                result.add(nextNode.key);
            }
            nextNode = nextNode.right;
        }
    }
    return result;
  }
}

