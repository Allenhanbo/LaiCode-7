
/*
Given a linked list, reverse alternate nodes and append at the end.

Examples:

Input List:    1 -> 2 -> 3 -> 4 -> 5 -> 6

Output List: 1 -> 3 -> 5 -> 6 -> 4 -> 2

Input List:    1 -> 2 -> 3 -> 4 -> 5

Output List: 1 -> 3 -> 5 -> 4 -> 2
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
  public ListNode reverseAlternate(ListNode head) {
    // Write your solution here
    if(head == null || head.next == null) {
        return head;
    }
    int i = 1;
    ListNode dummyOdd = new ListNode(-1);
    ListNode dummyEven = new ListNode(-1);
    ListNode currOdd = dummyOdd;
    ListNode currEven = dummyEven;
    while(head != null) {
        if(i % 2 == 1) {
            currOdd.next = head;
            currOdd = currOdd.next;
        }
        else {
            currEven.next = head;
            currEven = currEven.next;
        }
        head = head.next;
        i++;
    }
    currEven.next = null;
    ListNode evenHead = reverse(dummyEven.next);
    currOdd.next = evenHead;
    return dummyOdd.next;
  }
    public ListNode reverse(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

