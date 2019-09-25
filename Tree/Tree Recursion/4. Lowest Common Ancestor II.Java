
/*
Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.

Assumptions

There is parent pointer for the nodes in the binary tree
The given two nodes are not guaranteed to be in the binary tree
Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
*/


/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // Write your solution here.
    if(one == null || two == null) {
      return null;
    }
    ArrayList<TreeNodeP> pathOne = getPath(one);
    ArrayList<TreeNodeP> pathTwo = getPath(two);
    int i = pathOne.size() - 1;
    int j = pathTwo.size() - 1;
    TreeNodeP result = null;
    while(i >= 0 && j >= 0) {
      if(pathOne.get(i) != pathTwo.get(j)) {
        break;
      }
      result = pathOne.get(i);
      i--;
      j--;
    }
    return result;
  }
  private ArrayList<TreeNodeP> getPath(TreeNodeP root) {
    ArrayList<TreeNodeP> result = new ArrayList<>();
    while(root != null) {
      result.add(root);
      root = root.parent;
    }
    return result;
  }
}