
/*
Given a binary tree in which each node contains an integer number. Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), the sum of the numbers on the path is the given target number.

Examples

    5

  /    \

2      11

     /    \

    6     14

  /

 3

If target = 17, There exists a path 11 + 6, the sum of the path is target.

If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.

If target = 10, There does not exist any paths sum of which is target.

If target = 11, There exists a path only containing the node 11.

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
  public boolean exist(TreeNode root, int target) {
    // Write your solution here
    if(root == null) {
      return false;
    }
    List<Integer> keys = new ArrayList<>();
    boolean[] found = new boolean[1];
    found[0] = false;
    existHelper(root, target, keys, found);
    return found[0];
  }
  public void existHelper(TreeNode root, int target, List<Integer> keys, boolean[] found) {
    if(root == null) {
      return;
    }
    keys.add(root.key);
    if(calculateSum(target, keys)) {
      found[0] = true;
    }
    existHelper(root.left, target, keys, found);
    existHelper(root.right, target, keys, found);
    keys.remove(keys.size() - 1);
  }
  public boolean calculateSum(int target, List<Integer> keys) {
    int sum = 0;
    for(int i = keys.size() - 1; i >= 0; i--) {
      sum += keys.get(i);
      if(sum == target) {
        return true;
      }
    }
    return false;
  }
}



public class Solution {
  public boolean exist(TreeNode root, int target) {
    // Write your solution here
    if(root == null) {
      return false;
    }
    HashSet<Integer> set = new HashSet<>();
    boolean[] found = new boolean[1];
    found[0] = false;
    existHelper(root, target, set, found, 0);
    return found[0];
  }
  public void existHelper(TreeNode root, int target, HashSet<Integer> set, boolean[] found, int sum) {
    if(root == null) {
      return;
    }
    sum += root.key;
    if(set.contains(sum - target)) {
      found[0] = true;
    }
    set.add(sum);
    existHelper(root.left, target, set, found, sum);
    existHelper(root.right, target, set, found, sum);
    set.remove(sum);
    sum -= root.key;
  }
}



