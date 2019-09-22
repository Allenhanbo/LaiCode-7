
/*
Given a linked list and an sorted array of integers as the indices in the list. Delete all the nodes at the indices in the original list.

Examples

1 -> 2 -> 3 -> 4 -> NULL, indices = {0, 3, 5}, after deletion the list is 2 -> 3 -> NULL.

Assumptions

the given indices array is not null and it is guaranteed to contain non-negative integers sorted in ascending order.
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
  public ListNode deleteNodes(ListNode head, int[] indices) {
    // Write your solution here
    if(head == null || indices.length == 0){
        return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode cur = head;
    int i = 0;
    int count = 0;
    while(cur.next != null && i < indices.length) {
        if(count == indices[i]){
            prev.next = cur.next;
            cur = prev.next;
            i++;
        }
        else{
            prev = cur;
            cur = cur.next;
        }
        count++;
    }
    if(i < indices.length && count == indices[i]){
        prev.next = null;
    }
    return dummy.next;
  }
}


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
  public ListNode deleteNodes(ListNode head, int[] indices) {
    // Write your solution here
    if(head == null || indices.length == 0) {
        return head;
    }
    int i = 0;
    int count = 0;
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    ListNode curr = head;
    prev.next = curr;
    while(i < indices.length && curr != null) {
        if(count == indices[i]) {
            prev.next = curr.next;
            curr = prev.next;
            i++;
        }
        else{
            prev = curr;
            curr = curr.next;
        }
        count++;
    }
    return dummy.next;
  }
}
