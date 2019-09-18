
/*
nsert a new element at a specific index in the given linked list. The index is 0 based, and if the index is out of the list's scope, you do not need to do anything.

Examples:

1 -> 2 -> 3 -> null, insert 4 at index 3, --> 1 -> 2 -> 3 -> 4 -> null

1 -> 2 -> null, insert 4 at index 0, --> 4 -> 1 -> 2 -> null
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
  public ListNode insert(ListNode head, int index, int value) {
    // Write your solution here
    if(head == null){
        return new ListNode(value);
    }
    if(index == 0){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        return newNode;
    }
    
    ListNode prev = null;
    ListNode cur = head;
    while(index > 0 && cur.next != null) {
        prev = cur;
        cur = cur.next;
        index--;
    }
    // index = 0 || cur.next = null
    if(cur.next == null && index > 1){
        return head;
    }
    ListNode newNode = new ListNode(value);
    if(cur.next == null && index == 1){
        newNode.next = null;
        cur.next = newNode;
    }
    else {
        newNode.next = cur;
        prev.next = newNode;
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
  public ListNode insert(ListNode head, int index, int value) {
    // Write your solution here
    if(head == null) {
        return new ListNode(value);
    }
    if(index == 0 ) {
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        return newHead;
    }
    ListNode curr = head;
    ListNode prev = null;
    while(index > 0 && curr.next != null) {
        prev = curr;
        curr = curr.next;
        index--;
    }
    if(index == 0) {
        ListNode newNode = new ListNode(value);
        newNode.next = curr;
        prev.next = newNode;
    }
    else if(index == 1 && curr.next == null) {
        ListNode newNode = new ListNode(value);
        curr.next = newNode;
        newNode.next = null;
    }
    return head;
  }
}


