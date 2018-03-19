package main.java.ladders.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/**
 * 176. Route Between Two Nodes in Graph - Medium
 * 
Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

Example
Given graph:

A----->B----->C
 \     |
  \    |
   \   |
    \  v
     ->D----->E
for s = B and t = E, return true

for s = D and t = C, return false

Tags: Cracking The Coding Interview Depth First Search Breadth First Search

Related Problems 
Medium Parser 23 %
Medium Clone Graph 29 %
 * */

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class RouteBetweenTwoNodesInGraph {
	/**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
	public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
            DirectedGraphNode s, DirectedGraphNode t) {
		if (s == t)
			return true;
		if (graph == null || graph.size() == 0 || s == null || t == null){
			return false;
		}
		Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
		Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
		stack.push(s);
		while (!stack.isEmpty()){
			DirectedGraphNode node = stack.pop();
			if (visited.contains(node)){
				continue;
			}
			visited.add(node);
			for (DirectedGraphNode neighbor : node.neighbors){
				if (neighbor == t){
					return true;
				}
				stack.push(neighbor);
			}
		}
		return false;
	}
	
	//////////////////////////////////////////////
	public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
            DirectedGraphNode s, DirectedGraphNode t) {
		if (s == t)
			return true;
		HashSet<DirectedGraphNode> set = new HashSet<>();
		Stack<DirectedGraphNode> stack = new Stack<>();
		set.add(s);
		stack.push(s);
		while (!stack.isEmpty()) {
			DirectedGraphNode crt = stack.pop();
			for (DirectedGraphNode neighbor : crt.neighbors) {
				if (neighbor == t) {
					return true;
				}
				if (set.contains(neighbor)) {
					continue;
				}

				set.add(neighbor);
				stack.push(neighbor);

			}
		}
		return false;
	}
}
