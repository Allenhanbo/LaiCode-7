
/*
Insert a value in a sorted linked list.

Examples

L = null, insert 1, return 1 -> null
L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
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
  public ListNode insert(ListNode head, int value) {
    // Write your solution here
    if(head == null){
        return new ListNode(value);
    }
    if(value < head.value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        return newNode;
    }
    ListNode cur = head;
    ListNode prev = null;
    while(cur.next != null && cur.value <= value){
        prev = cur;
        cur = cur.next;
    }
    ListNode newNode = new ListNode(value);
    if(cur.next == null){
        cur.next = newNode;
        newNode.next = null;
    }
    else {
        prev.next = newNode;
        newNode.next = cur;
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
  public ListNode insert(ListNode head, int value) {
    // Write your solution here
    if(head == null) {
        return new ListNode(value);
    }
    if(value <= head.value) {
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        return newHead;
    }
    ListNode prev = null;
    ListNode curr = head;
    while(curr != null && curr.value < value) {
        prev = curr;
        curr = curr.next;
    }
    ListNode newNode = new ListNode(value);
    if(curr == null) {
        prev.next = newNode;
        newNode.next = null;
    }
    else {
        prev.next = newNode;
        newNode.next = curr;
    }
    return head;
  }
}
