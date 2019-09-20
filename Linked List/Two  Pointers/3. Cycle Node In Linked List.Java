
/*
Check if a given linked list has a cycle. Return the node where the cycle starts. Return null if there is no cycle.
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
  public ListNode cycleNode(ListNode head) {
    // write your solution here
    if(head == null || head.next == null){
        return null;
    }
    ListNode fast = head;
    ListNode slow = head;
    while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            break;
        }
    }
    if(fast.next == null || fast.next.next == null){
        return null;
    }
    fast = head;
    while(slow != fast){
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
  }
}

