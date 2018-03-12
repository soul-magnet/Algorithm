package main.java.ladders.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 137. Clone Graph - Medium

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

How we serialize an undirected graph:

Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

   1
  / \
 /   \
0 --- 2
     / \
     \_/

Example
return a deep copied graph.

Tags: Facebook Breadth First Search

Related Problems 
Medium Six Degrees 35 %
Easy Clone Binary Tree 47 %
Medium Route Between Two Nodes in Graph 36 %
 * */

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
     
     //BFS Approach
      public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
         // Note: The Solution object is instantiated only once and is reused by each test case.
         if(node == null)  return node;
         
         UndirectedGraphNode result = new UndirectedGraphNode(node.label);
         LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
         queue.add(node);
         Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
         map.put(node, result);
         
         while(!queue.isEmpty()){
             UndirectedGraphNode nodeInQueue = queue.poll();
             ArrayList<UndirectedGraphNode> neighbors = nodeInQueue.neighbors;
             for(int i = 0; i < neighbors.size(); i++){
                 UndirectedGraphNode n1 = neighbors.get(i);
                if(map.containsKey(n1)){
                     map.get(nodeInQueue).neighbors.add(map.get(n1));
                 } else {
                     UndirectedGraphNode n1clone = new UndirectedGraphNode(n1.label);
                     map.get(nodeInQueue).neighbors.add(n1clone);
                     map.put(n1, n1clone);
                     queue.add(n1);
                 }
             }
             
         }
         return result;
     }
 
     
     
     
     //DFS Appoach -1
      public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
          if(node == null) return null;
          
          return dfs(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
      }
      
      public UndirectedGraphNode dfs(UndirectedGraphNode root, HashMap<UndirectedGraphNode, UndirectedGraphNode>map){
          
          //If it has been copied, just return the copy node from the map. 
          UndirectedGraphNode rootCopy = map.get(root);
          if(rootCopy != null) return rootCopy;
          
           // if the root is not copied, create a new one.
          rootCopy = new UndirectedGraphNode(root.label);
          map.put(root, rootCopy);
          
          // copy all the child node. 
          for(UndirectedGraphNode child : root.neighbors){
              //call the recursion to create all the children and add the new children to the copy node. 
              rootCopy.neighbors.add(dfs(child, map));
          }
          
          return rootCopy;
      }
     
     
     //DFS Appoach -2
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
		if(node==null){
			return null;
		}
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node,copy);
		dfs1(map, copy, node);
		return copy;
	}

	private void dfs1(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode copy, UndirectedGraphNode node) {
			for(UndirectedGraphNode current: node.neighbors){
			
			if(map.containsKey(current)){//key already dfs, add to neighbor, iterator next neighbor
				copy.neighbors.add(map.get(current));
				
				continue;
			}
			else{//new neighbor: connect to copy, update it in map,  dfs new neighbor
				UndirectedGraphNode crtcopy = new UndirectedGraphNode(current.label);
				copy.neighbors.add(crtcopy);
				map.put(current, crtcopy);

				dfs1(map,crtcopy,current);

			}
		}
	}	
}
