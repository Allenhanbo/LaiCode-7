/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Input: 1->1->2

Output: 1->2
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
    ListNode prev = head;
    ListNode cur = head.next;
    while(cur.next != null){
        if(prev.value == cur.value){
            prev.next = cur.next;
            cur = prev.next;
        }
        else{
            prev = cur;
            cur = cur.next;
        }
    }
    if(prev.value == cur.value){
        prev.next = null;
    }
    return head;
  }
}

