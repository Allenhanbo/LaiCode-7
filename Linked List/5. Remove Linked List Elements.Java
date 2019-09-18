
/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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
  public ListNode removeElements(ListNode head, int val) {
    // Write your solution here
    if(head == null){
        return head;
    }
    ListNode dummy = new ListNode(-1);
    ListNode cur = head;
    ListNode prev = dummy;
    dummy.next = cur;
    if(cur.next == null && cur.value == val) {
        dummy.next = cur.next;
    }
    while(cur.next != null) {
        if(cur.value == val) {
            prev.next = cur.next;
            cur = prev.next;
        }
        else {
            prev = cur;
            cur = cur.next;
        }
    }
    if(cur.next == null && cur.value == val) {
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
  public ListNode removeElements(ListNode head, int val) {
    // Write your solution here
    if(head == null) {
        return head;
    }
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    ListNode curr = head;
    prev.next = curr;
    while(curr != null){
        if(curr.value == val){
            prev.next = curr.next;
            curr = prev.next;
        }
        else {
            prev = curr;
            curr = curr.next;
        }
    }
    return dummy.next;
  }
}

