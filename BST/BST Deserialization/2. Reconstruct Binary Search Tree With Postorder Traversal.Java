
/*
Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.

Assumptions

The given sequence is not null
There are no duplicate keys in the binary search tree
Examples

postorder traversal = {1, 4, 3, 11, 8, 5}

the corresponding binary search tree is

        5

      /    \

    3        8

  /   \        \

1      4        11

How is the binary tree represented?

We use the pre order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, #, #, 3, 4, #, #, #] represents the following binary tree:

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
  public TreeNode reconstruct(int[] post) {
	    // Write your solution here
	    if(post.length == 0) {
	      return null;
	    }
	    return reconstructHelper(post, 0, post.length - 1);
	  }
	  /*
	        5
	      /    \
	    3        8
	  /   \        \
	1      4        11
	0  1  2  3   4  5
	1, 4, 3, 11, 8, 5
	  */
	  public TreeNode reconstructHelper(int[] post, int postLeft, int postRight) {
	    if(postLeft > postRight) {
	      return null;
	    }
	    TreeNode root = new TreeNode(post[postRight]);
	    if(postLeft == postRight) {
	      return root;
	    }
	    int rightPostleftIndex = -1;
	    //System.out.println("postLeft = " + postLeft);
	    //System.out.println("postRight = " + postRight);
	    for(int i = postLeft; i < postRight; i++) {
	    	  //System.out.println("test1");
	      if(post[i] > post[postRight]) {
	        rightPostleftIndex = i;
	        break;
	      }
	    }
	    if(rightPostleftIndex == -1) {
    			rightPostleftIndex = postRight;
	    }
	    // System.out.println("leftPostRightIndex = " + leftPostRightIndex);
	    //System.out.println("left: begin = " + postLeft + "; end = " + rightPostleftIndex);
	    root.left = reconstructHelper(post, postLeft, rightPostleftIndex - 1);
	    root.right = reconstructHelper(post, rightPostleftIndex, postRight - 1);
	    return root;
	  }
}

