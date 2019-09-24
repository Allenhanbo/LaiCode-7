
/*
Merge K sorted lists into one big sorted list in ascending order.

Assumptions

ListOfLists is not null, and none of the lists is null.
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
   public ListNode mergeKLists(ListNode[] lists) {
    // 方法1：遍历所有node，把value放进一个array，然后sort，在放回一个Linked List
    // time complexity: O(k * nlog(k * n))
    // space complexity:O(k * n)
    if(lists == null || lists.length == 0) {
    	return null;
    }
    List<Integer> all_nodes = new ArrayList<>();
    for(ListNode node: lists) {
    	while(node != null) {
    		all_nodes.add(node.val);
    		node = node.next;
    	}
    }
    Collections.sort(all_nodes);
    // dummy node
    ListNode ret = new ListNode(0);
    ListNode cur = ret;
    for(Integer node_val: all_nodes) {
    	ListNode temp = new ListNode(node_val);
    	cur.next = temp;
    	cur = cur.next;
    }
    return ret.next;
  }
}



public class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
    // 方法2：比较k nodes 当前指向各个linked list最小的，在这些最小的中再找最小的
    // compare every k nodes(head of every linked list) and get the node with the smallest value.
    // extend the final sorted linked list with the selected nodes.
    // time complexity: O(k * n)
    // space complexity:O(1)
    // k is the number of linked list, n is the average length of a linked list.
    if(lists == null || lists.length == 0) {
    	return null;
    }
    ListNode res = new ListNode(0);
    ListNode cur = res;
    ListNode temp = null;
    // temp is for checking whether all list nodes are traversed.
    do {
    	temp = findMinAndMove(lists);
    	cur.next = temp;
    	cur = cur.next;
    } while(temp != null) {
    	return res.next;
    } 
  }

  // find the smallest node in all of linked list's head/pointer.
  private ListNode findMinAndMove(ListNode[] lists) {
  	int min_value = Integer.MAX_VALUE;
  	int ret_i = -1;
  	for(int i = 0; i < lists.length; i++) {
  		if(lists[i] == null) {
  			continue;
  		}
  		if(list[i].val < min_value) {
  			min_value = lists[i].val;
  			ret_i = i;
  		}
  	}
  	ListNode ret_node = null;
  	if(ret_i != -1) {
  		ret_node = lists[ret_i];
  		lists[ret_i] = lists[ret_i].next;
  	}
  	return ret_node;
  }
}



public class Solution {
  public ListNode merge(List<ListNode> listOfLists) {
    // 方法3：PriorityQueue
    // base on solution2: use PriorityQueue to get the smallest number every time
    // PriorityQueue(heap) can return the min/max number in O(logn) time.
    // time complexity: O(nlog(k))
    // space complexity:O(k)

  }

  static class MyComparator implements Comparator<ListNode> {
  	public int compare(ListNode arg0, ListNode arg1) {
  		return arg0.val - arg1.val;
  	}
  }

  public ListNode mergeKLists(ListNode[] lists) {
  	if(lists == null || lists.length == 0) {
    	return null;
    }
    // dummy node
    ListNode res = new ListNode(0);
    ListNode cur = res;
    PriotiryQueue<ListNode> heap = new PriorityQueue(lists.length, new MyComparator());
    // insert the head of all lists
    for(ListNode listHead: lists) {
    	if(listHead != null) {
    		heap.add(listHead);
    	}
    }
    while(!heap.isEmpty()) {
    	ListNode popNode = heap.poll();
    	cur.next = popNode;
    	cur = cur.next;
    	if(popNode.next != null) {
    		heap.add(popNode.next);
    	}
    }
    return res.next;
  }
}











































