
/*
Given a stream of characters, find the first non-repeating character from stream. You need to tell the first non-repeating character in O(1) time at any moment.

Implement two methods of the class:

read() - read one character from the stream
firstNonRepeating() - return the first non-repoeating character from the stream at any time when calling the method, return null if there does not exist such characters
Examples:

read:

a   b   c   a   c   c    b

firstNonRepeating:

a   a   a   b   b   b   null
*/


public class Solution {
/*
when a new char comes in, 
1. check whether it is in the map
1.1 if so, remove it from map and linked list
1.2 else, add it to the map and the tail of linked list
*/
  public class Node {
    char value;
    Node prev;
    Node next;
    public Node (Character value) {
      this.value = value;
      prev = null;
      next = null;
    }
  }
  public HashMap<Character, Node> map;
  public HashSet<Character> repeated;
  public Node head;
  public Node tail;
  public Node dummy;
  public Solution() {
    map = new HashMap<>();
    repeated = new HashSet<>();
    head = null;
    tail = null;
    dummy = new Node('0');
  }
  public void read(char ch) {
    if(repeated.contains(ch)) {
			return;
		}
    if(map.containsKey(ch)) {
      Node curr = map.get(ch);
      curr.prev.next = curr.next;
      curr.next.prev = curr.prev;
      curr.prev = null;
      curr.next = null;
      if(map.size() == 0) {
	    	head = null;
	    	tail = null;
	    }
	    else {
	    	head = dummy.next;
        tail = dummy.prev;
	    }
	    map.remove(ch);
      repeated.add(ch);
    }
    else {
      Node newNode = new Node(ch);
      if(map.size() == 0) {
        dummy.next = newNode;
        dummy.prev = newNode;
        newNode.next = dummy;
        newNode.prev = dummy;
        head = newNode;
        tail = newNode;
      }
      else {
        tail.next = newNode;
        dummy.prev = newNode;
        newNode.next = dummy;
        newNode.prev = tail;
        tail = newNode;
      }
      map.put(ch, tail);
    }
  }
  public Character firstNonRepeating() {
    // Implement this method here.
    if(map.size() != 0) {
      return head.value;
    }
    return null;
  }
}

