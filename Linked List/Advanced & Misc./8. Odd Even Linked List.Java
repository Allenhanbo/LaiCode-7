
/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
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
  public ListNode oddEvenList(ListNode head) {
    // Write your solution here
    ListNode dummyOdd = new ListNode(-1);
    ListNode dummyEven = new ListNode(-1);
    ListNode currOdd = dummyOdd;
    ListNode currEven = dummyEven;
    int i = 1;
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
    currOdd.next = dummyEven.next;
    currEven.next = null;
    return dummyOdd.next;
  }
}





