package main.java.ladders.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;



/**
 * Given an directed graph, a topological order of the graph nodes is defined as follow:
 * For each directed edge A -> B in graph, A must before B in the order list.
 * The first node in the order can be any node in the graph with no nodes direct to it.
 * Find any topological order for the given graph.
 * Notice: You can assume that there is at least one topological order in the graph.
 * 
	...
	Challenge: Can you do it in both BFS and DFS?
 *
 * 
 * 
 * Thoughts:
 * BFS Approach
 * 1. Find the node which has no parent node: this will be the beginning node.
 *    Use a HashMap to map all nodes with children
 *    
 * 2. Starting from this node, put all nodes in the queue (breath-first)
 * 3. Process each node in the queue: add to array list
 * 
 * 
 *
 * */


/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;
	DirectedGraphNode(int x){
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
}
public class TopologicalSortingBFS {
	/**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
	//BFS Version 1
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph){
		ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
		
		if(graph == null || graph.size() == 0) return graph;
		
		//Keep track of all neighbors in HashMap
		HashMap<Integer, Integer>map = new HashMap<Integer, Integer>();
		for(DirectedGraphNode node : graph){
			for(DirectedGraphNode neighbor : node.neighbors){
				int keyN = neighbor.label;
				if(map.containsKey(keyN)){
					map.put(keyN, map.get(keyN) + 1);
				}else{
					map.put(keyN, 1);
				}
			}
		}
		
		//BFS: Add root node
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for(DirectedGraphNode node : graph){
			if(!map.containsKey(node.label)){
				queue.offer(node);
				result.add(node);
			}
		}
		
		//BFS: go through all children
		while(!queue.isEmpty()){
			DirectedGraphNode node = queue.poll();
			for(DirectedGraphNode n : node.neighbors){
				int label = n.label;
				map.put(label, map.get(label) - 1);
				if(map.get(label) == 0){
					result.add(n);
					queue.offer(n);
				}
			}
		}
		
		return result;
	}
	
	//BFS Version 2
	public ArrayList<DirectedGraphNode> topSort1(ArrayList<DirectedGraphNode> graph){
		
		if(graph == null || graph.size() == 0) return graph;
		
		Stack<DirectedGraphNode> stack = new Stack<>();
		Map<DirectedGraphNode, Integer>map = new HashMap<>();
		ArrayList<DirectedGraphNode> result = new ArrayList<>();
		
		for(DirectedGraphNode vertex : graph){
			for(DirectedGraphNode neighbor : vertex.neighbors){
				if(map.containsKey(neighbor))
					map.put(neighbor, map.get(neighbor)+1);
				else
					map.put(neighbor, 1);
			}
		}
		
		for(DirectedGraphNode vertex: graph){
			if(!map.containsKey(vertex))
				stack.push(vertex);
		}
		
		while(!stack.isEmpty()){
			DirectedGraphNode currentVertex = stack.pop();
			result.add(currentVertex);
			for(DirectedGraphNode vertex : currentVertex.neighbors){
				int indegrees = map.get(vertex) - 1;
				map.put(vertex, map.get(vertex) - 1);
				if(indegrees == 0){
					stack.push(vertex);
				}
			}
		}
		
		return result;
	}
	
	

}
