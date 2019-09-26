
/*
Given M nodes in a K-nary tree, find their lowest common ancestor.

Assumptions

- M >= 2.

- There is no parent pointer for the nodes in the K-nary tree.

- The given M nodes are guaranteed to be in the K-nary tree.

Examples

        5

      /   \

     9   12

   / | \      \

  1 2 3     14



The lowest common ancestor of 2, 3, 14 is 5.

The lowest common ancestor of 2, 3, 9 is 9.
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
  public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
    // Write your solution here
    if(root == null) {
      return root;
    }
    HashSet<KnaryTreeNode> nodeSet = new HashSet<>();
    for(int i = 0; i < nodes.size(); i++) {
      nodeSet.add(nodes.get(i));
    }
    return lowestCommonAncestorHelper(root, nodeSet);
  }

  private KnaryTreeNode lowestCommonAncestorHelper(KnaryTreeNode root, HashSet<KnaryTreeNode> nodeSet) {
    if(root == null || nodeSet.contains(root)) {
      return root;
    }
    KnaryTreeNode temp = null;
    int counter = 0;
    for(int i = 0; i < root.children.size(); i++) {
      KnaryTreeNode curr = lowestCommonAncestorHelper(root.children.get(i), nodeSet);
      if(curr != null) {
        counter++;
        if(counter == 2) {
          return root;
        }
        temp = curr;
      }
    }
    return temp;
  }
}