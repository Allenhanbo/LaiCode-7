
/*
Given a linked list, remove the nth node from the end of list and return its head.

Assumptions
If n is not valid, you do not need to do anything to the original list.
Try to do this in one pass.

Examples

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
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
  public ListNode removeNthFromEnd(ListNode head, int n) {
    // Write your solution here
    if(head == null){
        return head;
    }
    ListNode cur = head;
    int count = 1;
    while(cur.next.next != null){
        cur = cur.next;
        count++;
    }
    if(n == 1){
        cur.next = null;
        return head;
    }
    else{
        count++;
    }
    if(count < n){
        return head;
    }
    if(count == n){
        return head.next;
    }
    int step = count - n;
    cur = head;
    while(step > 1){
        cur = cur.next;
        step--;
    }
    cur.next = cur.next.next;
    return head;
  }
}

