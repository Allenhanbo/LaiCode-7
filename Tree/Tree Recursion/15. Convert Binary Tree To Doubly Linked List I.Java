
/*
Given a binary tree, convert it to a doubly linked list in place (use the left pointer as previous, use the right pointer as next).

The values in the nodes of the doubly linked list should follow the in-order traversal sequence of the binary tree.

Examples:

    10

   /  \

  5    15

 /

2

Output:  2 <-> 5 <-> 10 <-> 15
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
  public static class DoublyLinkedList {
		public TreeNode head;
		public TreeNode prev;
	}

	public TreeNode toDoubleLinkedList(TreeNode root) {
	    // Write your solution here.
	    if(root == null || root.left == null && root.right == null) {
	      return root;
	    }
	    //TreeNode head = null;
	    //TreeNode prev = null;
	    DoublyLinkedList dll = new DoublyLinkedList();
	    toDoubleLinkedListHelper(root, dll);
	    return dll.head;
	  }
	
	  public void toDoubleLinkedListHelper(TreeNode root, DoublyLinkedList dll) {
	    if(root == null) {
	      return;
	    }
	    toDoubleLinkedListHelper(root.left, dll);
	    if(dll.prev == null) {
	      dll.head = root;
	    }
	    else {
	      root.left = dll.prev; 
	      dll.prev.right = root;
	    }
	    dll.prev = root;
	    toDoubleLinkedListHelper(root.right, dll);
	  }
}





