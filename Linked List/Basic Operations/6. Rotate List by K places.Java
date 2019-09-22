
/*
Given a list, rotate the list to the right by k places, where k is non-negative.

Input: 1->2->3->4->5->NULL, k = 2

Output: 4->5->1->2->3->NULL

Input: 1->2->3->4->5->NULL, k = 12

Output: 4->5->1->2->3->NULL
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
  public ListNode rotateKplace(ListNode head, int n) {
    // Write your solution here
    if(head == null || n < 0){
        return head;
    }
    ListNode tail = head;
    int count = 1;
    while(tail.next != null) {
        count ++;
        tail = tail.next;
    }
    if(n % count == 0){
        return head;
    }
    int pos = count - n % count;
    ListNode cur = head;
    while(pos > 1){
        cur = cur.next;
        pos--;
    }
    ListNode newHead = cur.next;
    cur.next = null;
    tail.next = head;
    return newHead;
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
  public ListNode rotateKplace(ListNode head, int n) {
    // Write your solution here
    if(head == null) {
        return head;
    }
    int size = 1;
    ListNode tail = head;
    while(tail.next != null) {
        size++;
        tail = tail.next;
    }
    tail.next = head;
    int i = size - n % size;
    ListNode curr = head;
    while(i > 1) {
        curr = curr.next;
        i--;
    }
    ListNode newHead = curr.next;
    curr.next = null;
    return newHead;
  }
}

