package main.java.ladders.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/**
 * 
 * 431. Connected Component in Undirected Graph - Medium

Find the number connected component in the undirected graph. 
Each node in the graph contains a label and a list of its neighbors. 
(a connected component (or just component) of an undirected graph is a subgraph 
in which any two vertices are connected to each other by paths, 
and which is connected to no additional vertices in the supergraph.)

 Notice: Each connected component should sort by label.

Clarification
Learn more about representation of graphs

Example
Given graph:

A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}

Tags: Union Find, Breadth First Search

Related Problems 
1- Medium Graph Valid Tree 27 %
2- Medium Find the Weak Connected Component in the Directed Graph 26 %
 

*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x){
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

public class ConnectedComponentInUndirectedGraph {
	
	 public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
		 
		 int m = nodes.size();
		 Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
		 
		 for(UndirectedGraphNode node : nodes) {
			 visited.put(node, false);
		 }
		 
		 List<List<Integer>> result = new ArrayList<>();
		 for(UndirectedGraphNode node : nodes) {
			 if(visited.get(node) == false) {
				 bfs(node, visited, result);
			 }
		 }

		 return result;
	 }
	 
	 public void bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean>visited, List<List<Integer>>result) {
		 List<Integer> list = new ArrayList<Integer>();
		 Queue<UndirectedGraphNode>queue = new LinkedList<UndirectedGraphNode>();
		 
		 queue.offer(node);
		 visited.put(node, true);
		 
		 while(!queue.isEmpty()){
			 UndirectedGraphNode current = queue.poll();
			 list.add(current.label);
			 
			//must check the neighbor is visited, since each neighbor may connect to each other( circle), 
			 //we must add the node that is unvisited
			 for(UndirectedGraphNode neighbor : current.neighbors) {
				 if(visited.get(neighbor) == false) {
					 queue.offer(neighbor);
					 visited.put(neighbor, true);
				 }
			 }
		 }
		 
		 java.util.Collections.sort(list);
		 result.add(list);
	 }

}
