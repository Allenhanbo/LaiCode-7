
/*
Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

Assumptions

The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree
Examples

levelorder traversal = {5, 3, 8, 1, 4, 11}

inorder traversal = {1, 3, 4, 5, 8, 11}

the corresponding binary tree is

        5

      /    \

    3        8

  /   \        \

1      4        11

How is the binary tree represented?

We use  level order traversal sequence with a special symbol "#" denoting the null node.

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
  public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
    // Write your solution here
    if(inOrder.length == 0) {
      return null;
    }
    List<Integer> level = new ArrayList<>();
    for(int i = 0; i < levelOrder.length; i++) {
      level.add(levelOrder[i]);
    }
    HashMap<Integer, Integer> inOrderMap = new HashMap<>();
    for(int i = 0; i < inOrder.length; i++) {
      inOrderMap.put(inOrder[i], i);
    }
    return reconstructHelper(inOrder, 0, inOrder.length - 1, level, inOrderMap);
  }
  public TreeNode reconstructHelper(int[] inOrder, int inLeft, int inRight, 
  List<Integer> level, HashMap<Integer, Integer> inOrderMap) {
    if(inLeft > inRight) {
      return null;
    }
    TreeNode root = new TreeNode(level.get(0));
    if(level.size() == 1) {
      return root;
    }
    /*
    index = 0  1  2  3  4  5  6
    inorder 4  8  10 12 14 20 22
    lorder  20 8  22 4  12 10 14
    */
    // 找到levelOrder 第一个就是当前的root
    List<Integer> leftLevel = new ArrayList<>();
    List<Integer> rightLevel = new ArrayList<>();
    int rootInOrderIndex = inOrderMap.get(root.key);
    // 遍历levelOrder，查找每个元素的在in-order的顺序
    // < index of root.key 放入leftLevel; > root.key 放入rightLevel
    // 保持原有level-order的顺序
    for(int i = 1; i < level.size(); i++) {
      if(inOrderMap.get(level.get(i)) < rootInOrderIndex) {
        leftLevel.add(level.get(i));
      }
      else {
        rightLevel.add(level.get(i));
      }
    }
    root.left = reconstructHelper(inOrder, inLeft, rootInOrderIndex - 1, 
    leftLevel, inOrderMap);
    root.right = reconstructHelper(inOrder, rootInOrderIndex + 1, inRight, 
    rightLevel, inOrderMap);
    return root;
  }
}



