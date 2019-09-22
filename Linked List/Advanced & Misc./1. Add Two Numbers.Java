
/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.  

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

Output: 7 -> 0 -> 8
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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Write your solution here
    if(l1 == null || l2 == null) {
        return null;
    }
    if(l1 == null && l2 != null) {
        return l2;
    }
    if(l1 != null && l2 == null) {
        return l1;
    }
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    boolean plus = false;
    int value = 0;
    while(l1 != null && l2 != null) {
        if(plus == true){
            value = l1.value + l2.value + 1;
            plus = false;
        }
        else {
            value = l1.value + l2.value;
        }
        if(value >= 10){
            value = value - 10;
            plus = true;
        }
        curr.next = new ListNode(value);
        curr = curr.next;
        l1 = l1.next;
        l2 = l2.next;
    }
    while(l1 != null) {
        if(plus == true) {
            value = l1.value + 1;
            plus = false;
        }
        else {
            value = l1.value;
        }
        if(value >= 10){
            value = value - 10;
            plus = true;
        }
        curr.next = new ListNode(value);
        l1 = l1.next;
        curr = curr.next;
    }
    while(l2 != null) {
        if(plus == true) {
            value = l2.value + 1;
            plus = false;
        }
        else {
            value = l2.value;
        }
        if(value >= 10){
            value = value - 10;
            plus = true;
        }
        curr.next = new ListNode(value);
        l2 = l2.next;
        curr = curr.next;
    }
    if(plus == true) {
        curr.next = new ListNode(1);
    }
    return dummy.next;
  }
}


