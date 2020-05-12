
/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 <=k <= BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
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
  public int kthSmallest(TreeNode root, int k) {
    // Write your solution here
    if(root == null) {
        return -1;
    }
    TreeNode nextNode = root;
    Deque<TreeNode> stack = new LinkedList<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
    int i = 0;
    while(nextNode != null || !stack.isEmpty()) {
        if(nextNode != null) {
            stack.offerFirst(nextNode);
            nextNode = nextNode.left;
        }
        else {
            nextNode = stack.pollFirst();
            if(i < k) {
                maxHeap.offer(nextNode.key);
                i++;
            }
            else {
                if(nextNode.key < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(nextNode.key);
                }
            }
            nextNode = nextNode.right;
        }
    }
    return maxHeap.peek();
  }
}

