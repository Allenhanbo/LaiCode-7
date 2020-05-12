
/*
Implement a least recently used cache. It should provide set(), get() operations. If not exists, return null (Java), false (C++), -1(Python).
*/


public class Solution<K, V> {
  // limit is the max capacity of the cache
  /*
Solution: 
When a new element X <key_x, value_x> comes in
Case 1: we need to determine whether X is already in the caches or not.
Case 1.1: if X is already in the cache, we need to update X's priority 
by moving it to the head of the cache(== cache is hit).
Case 1.2: if X is not in the cache,
1.2.1 if the cache is full, we need to delete the tail element in the cache
1.2.2 if the cache is not full, we just insert X to the head of the cache
  */
  public class Node {
    K key;
    V value;
    Node prev;
    Node next;
    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      prev = null;
      next = null;
    }
  }
  public HashMap<K, Node> cache;
  public int limit;
  public int count;
  public Node head;
  public Node tail;
  public Node dummy;
  public Solution(int limit) {
    cache = new HashMap<>();
    this.limit = limit;
    count = 0;
	  dummy = new Node(null, null);
	  dummy.next = head;
	  dummy.prev = tail;
	  head = null;
	  tail = null;
  }
  public void set(K key, V value) {
    if(cache.containsKey(key)) {
      Node curr = cache.get(key);
      curr.value = value;
      // 把Node curr放到list最前面, 更新head指针
	    curr.prev.next = curr.next;
	    curr.next.prev = curr.prev;
	    curr.next = head;
	    curr.prev = dummy;
	    head.prev = curr;
	    dummy.next = curr;
	    head = curr;
    }
    else {
      if(count == 0){
        count++;
        Node newNode = new Node(key, value);
	      newNode.prev = dummy;
	      newNode.next = dummy;
	      head = newNode;
	      tail = newNode;
	      cache.put(key, head);
      } 
      // 删除List最后一个节点，然后把新的节点插入头部
      else if(count == limit) {
        cache.remove(tail.key);
	    	// 删除tail
	      tail = tail.prev;
	      tail.next = dummy;
	      dummy.prev = tail;
	      // 加入new node
	      Node newNode = new Node(key, value);
	      head.prev = newNode;
	      dummy.next = newNode;
	      newNode.next = head;
	      newNode.prev = dummy;
	      head = head.prev;
	      cache.put(key, head);
      } 
      // 在头部插入一个节点，然后更新count
      else {
        Node newNode = new Node(key, value);
	      newNode.next = head;
	      newNode.prev = dummy;
	      dummy.next = newNode;
	      head.prev = newNode;
	      head = head.prev;
	      cache.put(key, head);
	      count++;
      }
    }
    return;
  }
  public V get(K key) {
    if(cache.containsKey(key)) {
      Node curr = cache.get(key);
      if(curr == head) {
		    return curr.value;
	    }
      // 把curr放到第一个的位置
	    curr.prev.next = curr.next;
	    curr.next.prev = curr.prev;
	    curr.next = head;
	    curr.prev = dummy;
	    dummy.next = curr;
	    head.prev = curr;
	    head = curr;
	    tail = dummy.prev;

	    return curr.value;
    }
    return null;
  }
}
