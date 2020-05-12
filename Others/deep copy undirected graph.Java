
/*
Make a deep copy of an undirected graph, there could be cycles in the original graph.

Assumptions

The given graph is not null
*/


/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // Write your solution here.
    if(graph == null || graph.size() == 0) {
      return graph;
    }
    HashMap<GraphNode, GraphNode> map = new HashMap<>();
    Queue<GraphNode> queue = new LinkedList<>();
    List<GraphNode> newGraph = new ArrayList<>();
    for(int i = 0; i < graph.size(); i++) {
      GraphNode curr = graph.get(i);
      if(!map.containsKey(curr)) {
        GraphNode newNode = new GraphNode(curr.key);
        newNode.neighbors = new ArrayList<GraphNode>();
        map.put(curr, newNode);
      }
      queue.offer(curr);
      newGraph.add(curr);
    }
    // 放入queue之前，先new GraphNode，new neighbors
    while(!queue.isEmpty()) {
      GraphNode currOldNode = queue.poll();
      GraphNode currNewNode = map.get(currOldNode);
      for(int j = 0; j < currOldNode.neighbors.size(); j++) {
          GraphNode curr = currOldNode.neighbors.get(j);
          currNewNode.neighbors.add(curr);
          if(!map.containsKey(curr)) {
            GraphNode newNode = new GraphNode(curr.key);
            newNode.neighbors = new ArrayList<GraphNode>();
            map.put(curr, newNode);
          }
          queue.offer(curr);
        }
      }
    return newGraph;
  }
}
