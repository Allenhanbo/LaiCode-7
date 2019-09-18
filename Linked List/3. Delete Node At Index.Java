
/*
Delete the node at the given index for the given linked list.

Examples

[1, 2, 3], delete at 1 --> [1, 3]

[1, 2, 3], delete at 4 --> [1, 2, 3]

[1, 2, 3], delete at 0 --> [2, 3]
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
  public ListNode deleteNode(ListNode head, int index) {
    // Write your solution here
    if(head == null){
        return head;
    }
    if(index == 0){
        return head.next;
    }
    ListNode cur = head;
    ListNode prev = null;
    while(index > 0 && cur.next != null){
        prev = cur;
        cur = cur.next;
        index--;
    }

    if(index > 0) {
        return head;
    }
    if(index == 0 && cur.next == null){
        prev.next = null;
    }
    else {
        prev.next = cur.next;
    }
    return head;
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
  public ListNode deleteNode(ListNode head, int index) {
    // Write your solution here
    if(head == null) {
        return head;
    }
    if(index == 0) {
        return head.next;
    }
    ListNode prev = null;
    ListNode curr = head;
    while(index > 0 && curr != null) {
        prev = curr;
        curr = curr.next;
        index--;
    }
    if(curr != null) {
        prev.next = curr.next;
        curr.next = null;
    }
    return head;
  }
}

