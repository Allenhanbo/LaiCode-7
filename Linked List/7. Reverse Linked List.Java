
/*
Reverse a singly-linked list.

Examples

L = null, return null
L = 1 -> null, return 1 -> null
L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
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
  public ListNode reverse(ListNode head) {
    // Write your solution here
    if(head == null || head.next == null){
        return head;
    }
    ListNode prev = head;
    ListNode cur = head.next;
    prev.next = null;
    while(cur.next != null){
        ListNode nextNode = cur.next;
        cur.next = prev;
        prev = cur;
        cur = nextNode;
    }
    cur.next = prev;
    return cur;
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
  public ListNode reverse(ListNode head) {
    // Write your solution here
    if(head == null || head.next == null) {
          return head;
      }
      ListNode prev = null;
      while(head != null) {
          ListNode temp = head.next;
          head.next = prev;
      prev = head;
          head = temp;
      }
    //head.next = null;
      return prev;
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
  public ListNode reverse(ListNode head) {
    // Write your solution here
    if(head == null || head.next == null){
        return head;
    }
    ListNode curr = head;
    ListNode newHead = reverse(curr.next);
    curr.next.next = curr;
    curr.next = null;
    return newHead;
  }
}

