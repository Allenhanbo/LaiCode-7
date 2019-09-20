
/*
Check if a given linked list has a cycle. Return true if it does, otherwise return false.

 

Assumption:

You can assume there is no duplicate value appear in the linked list.
*/

/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public boolean hasCycle(ListNode head) {
    // write your solution here
    if(head == null || head.next == null){
        return false;
    }
    ListNode fast = head;
    ListNode slow = head;
    while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(fast == slow) {
            return true;
        }
    }
    return false;
  }
}
