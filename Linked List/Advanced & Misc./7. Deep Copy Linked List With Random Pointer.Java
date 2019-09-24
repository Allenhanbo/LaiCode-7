
/*
Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. Make a deep copy of the original list.
*/

/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    // Write your solution here.
    if(head == null) {
      RandomListNode newHead = null;
      return newHead;
    }
    HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode newHead = new RandomListNode(head.value);
    RandomListNode curr = newHead;
    map.put(head, curr);
    while(head != null) {
      if(head.next != null) {
        if(!map.containsKey(head.next)) {
          RandomListNode node = new RandomListNode(head.next.value);
          map.put(head.next, node);
        }
        curr.next = map.get(head.next);
      }
      if(head.random != null) {
        if(!map.containsKey(head.random)) {
          RandomListNode node = new RandomListNode(head.random.value);
          map.put(head.random, node);
        }
        curr.random = map.get(head.random);
      }
      head = head.next;
      curr = curr.next;
    }
    return newHead;
  }
}


