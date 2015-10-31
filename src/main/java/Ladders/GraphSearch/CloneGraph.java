package GraphSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Clone an undirected graph.
 * Each node in the graph contains a label and a list of its neighbors.
 * 
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
Analysis: 
 -> A queue is used to do breath first traversal
 -> A map is used to store the visited nodes. 
    It is the map between original node and copied node.
 
         
*/
public class CloneGraph {
	private class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) {
			label = x; 
			neighbors = new ArrayList<UndirectedGraphNode>();
			
		}
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
		
		queue.add(node);
		map.put(node, newHead);
		
		while(!queue.isEmpty()) {
			UndirectedGraphNode current = queue.pop();
			ArrayList<UndirectedGraphNode> currentNeighbors = current .neighbors;
			
			for (UndirectedGraphNode aNeighbor: currentNeighbors){
				if (!map.containsKey(aNeighbor)){
					UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
					map.put(aNeighbor,copy);
					map.get(current).neighbors.add(copy);
					queue.addFirst(aNeighbor);
					
				} else {
					map.get(current).neighbors.add(map.get(aNeighbor));
				}
			}
		}
		
		return newHead;
	}
	
	// Another version
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        //bug 1: can't use queue, should use LinkedList
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        
        // copy the root node nad then put it into the map
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.poll();
            // get out the copy node. We guarantee that it has been copied 
            // Because we always put into the map before put into the queue
            UndirectedGraphNode curCopy = map.get(current);
            // go through all the children node
            // java.util.ConcurrentModificationException.
            //Use current instead of curCopy
            for (UndirectedGraphNode child: current.neighbors){
                if (map.containsKey(child)){
                    curCopy.neighbors.add(map.get(child));
                } else {
                    // Only add the child into the map when it is not visited
                    queue.offer(child);
                    // bug 3: forget to add the node into the map
                    UndirectedGraphNode childCopy = new UndirectedGraphNode(child.label);
                    curCopy.neighbors.add(childCopy);
                    map.put(child, childCopy);
                }
            }
        }
        return map.get(node);
    }
	

}
