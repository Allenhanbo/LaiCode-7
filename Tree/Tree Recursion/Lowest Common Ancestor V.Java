
/*
Given two nodes in a K-nary tree, find their lowest common ancestor.

Assumptions

-There is no parent pointer for the nodes in the K-nary tree.

-The given two nodes are guaranteed to be in the K-nary tree.

Examples



        5

      /   \

     9   12

   / | \      \

 1 2   3      14



The lowest common ancestor of 2 and 14 is 5.

The lowest common ancestor of 2 and 9 is 9.
*/


/**
 * public class KnaryTreeNode {
 *     int key;
 *     List<KnaryTreeNode> children;
 *     public KnaryTreeNode(int key) {
 *         this.key = key;
 *         this.children = new ArrayList<>();
 *     }
 * }
 */

public class Solution {
  public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
    // Write your solution here
    if(root == null || root == a || root == b) {
      return root;
    }
    int counter = 0;
    KnaryTreeNode temp = null;
    for(int i = 0; i < root.children.size(); i++) {
      KnaryTreeNode node = lowestCommonAncestor(root.children.get(i), a, b);
      if(node != null) {
        counter++;
        if(counter == 2) {
          return root;
        }
        temp = node;
      }
    }
    return temp;
  }
}