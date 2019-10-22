
/*
In a binary search tree, find the node containing the largest number smaller than the given target number.

If there is no such number, return -2^31.

Assumptions:

The given root is not null.
There are no duplicate keys in the binary search tree.
Examples

    5

  /    \

2      11

     /    \

    6     14

largest number smaller than 1 is Integer.MIN_VALUE(Java) or INT_MIN(c++)

largest number smaller than 10 is 6

largest number smaller than 6 is 5

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
  public int largestSmaller(TreeNode root, int target) {
    // Write your solution here
    if(root == null) {
        return (int)(-1 * Math.pow(2, 31));
    }
    TreeNode nextNode = root;
    Deque<TreeNode> stack = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    while(nextNode != null || !stack.isEmpty()) {
        if(nextNode != null) {
            stack.offerFirst(nextNode);
            nextNode = nextNode.left;
        }
        else {
            nextNode = stack.pollFirst();
            result.add(nextNode.key);
            nextNode = nextNode.right;
        }
    }
    int i = 0;
    for(i = result.size() - 1; i >= 0; i--) {
        if(result.get(i) < target) {
            break;
        }
    }
    if(i == -1) {
        return Integer.MIN_VALUE;
    }
    return result.get(i);
  }
}















