
/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Input:  1->2->3->3->4->4->5

Output: 1->2->5    

Input:  1->1->1

Output: NULL
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
  public ListNode removeDup(ListNode head) {
    // Write your solution here
    if(head == null || head.next == null){
        return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode cur = head;
    int duplicate = -1;
    while(cur.next != null){
        if(cur.value == cur.next.value || cur.value == duplicate){
            duplicate = cur.value;
            prev.next = cur.next;
            cur = prev.next;
        }
        else {
            prev = cur;
            cur = cur.next;
        } 
    }
    if(cur.value == duplicate){
        prev.next = null;
    }
    return dummy.next;
  }
}

