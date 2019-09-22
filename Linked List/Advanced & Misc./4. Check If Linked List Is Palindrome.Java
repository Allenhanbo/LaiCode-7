
/*
Given a linked list, check whether it is a palindrome.

Examples:

Input:   1 -> 2 -> 3 -> 2 -> 1 -> null

output: true.

Input:   1 -> 2 -> 3 -> null  

output: false.

Requirements:

Space complexity must be O(1)
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
    public boolean isPalindrome(ListNode head) {
    // Write your solution here
        if(head == null || head.next == null) {
            return true;
        }
        ListNode mid = getMidNode(head);
        mid = mid.next;
        ListNode curr1 = head;
        ListNode curr2 = reverse(mid);
        while(curr1 != mid && curr2 != null) {
            if(curr1.value != curr2.value) {
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }

    public ListNode getMidNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;
        while(curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}


