
/*
Merge two sorted lists into one large sorted list.

Examples

L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
L1 = null, L2 = null, merge L1 and L2 to null
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
  public ListNode merge(ListNode one, ListNode two) {
    // Write your solution here
    if(one == null){
        return two;
    }
    if(two == null){
        return one;
    }
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    ListNode cur1 = one;
    ListNode cur2 = two;
    while(cur1 != null && cur2 != null){
        if(cur1.value < cur2.value){
            cur.next = cur1;
            cur1 = cur1.next;
        }
        else {
            cur.next = cur2;
            cur2 = cur2.next;
        }
        cur = cur.next;
    }
    if(cur1 != null){
        while(cur1 != null){
            cur.next = cur1;
            cur = cur.next;
            cur1 = cur1.next;
        }
    }
    if(cur2 != null){
        while(cur2 != null){
            cur.next = cur2;
            cur = cur.next;
            cur2 = cur2.next;
        }
    }
    cur.next = null;
    return dummy.next;
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
  public ListNode merge(ListNode one, ListNode two) {
    // Write your solution here
    if(one == null && two == null) {
        return null;
    }
    if(one == null && two != null) {
        return two;
    }
     if(one != null && two == null) {
        return one;
    }
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    while(one != null && two != null) {
        if(one.value < two.value) {
            curr.next = one;
            one = one.next;
        }
        else {
            curr.next = two;
            two = two.next;
        }
        curr = curr.next;
    }
    while(one != null) {
        curr.next = one;
        curr = curr.next;
        one = one.next;
    }
    while(two != null) {
        curr.next = two;
        curr = curr.next;
        two = two.next;
    }
    return dummy.next;
  }
}

