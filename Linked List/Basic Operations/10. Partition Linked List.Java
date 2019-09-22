
/*
Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes larger than or equal to target value T. The original relative order of the nodes in each of the two partitions should be preserved.

Examples

L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
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
  public ListNode partition(ListNode head, int target) {
    // Write your solution here
    if(head == null){
        return null;
    }
    ListNode dummy1 = new ListNode(-1);
    ListNode cur1 = dummy1;
    ListNode dummy2 = new ListNode(0);
    ListNode cur2 = dummy2;
    ListNode cur = head;
    while(cur != null){
        if(cur.value < target){
            cur1.next = cur;
            cur1 = cur1.next;
        }
        else {
            cur2.next = cur;
            cur2 = cur2.next;
        }
        cur = cur.next;
    }
    cur1.next = dummy2.next;
    cur2.next = null;
    return dummy1.next;
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
  public ListNode partition(ListNode head, int target) {
    // Write your solution here
    if(head == null || head.next == null) {
        return head;
    }
    ListNode dummyLess = new ListNode(-1);
    ListNode currLess = dummyLess;
    ListNode dummyMore = new ListNode(-1);
    ListNode currMore = dummyMore;
    while(head != null){
        if(head.value < target){
            currLess.next = head;
            currLess = currLess.next;
        }
        else{
            currMore.next = head;
            currMore = currMore.next;
        }
        head = head.next;
    }
    currLess.next = dummyMore.next;
    currMore.next = null;
    return dummyLess.next;
  }
}
