/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
package main.java.ladders.UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Find the number Weak Connected Component in the directed graph. 
 * Each node in the graph contains a label and a list of its neighbors. 
 * (a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)
 * Example Given graph:

A----->B  C
 \     |  | 
  \    |  |
   \   |  |
    \  v  v
     ->D  E <- F
Return {A,B,D}, {C,E,F}. Since there are two connected component which are {A,B,D} and {C,E,F}

Note: Sort the element in the set in increasing order
Analysis: 
*/


public class FindWeakConnectedComponentInTheDirectedGraph {
	
	/**
	 * @param nodes a array of Directed graph node
	 * @return a connected set of a directed graph
	 */
	public List<List<Integer>> conenctedSet2(ArrayList<DirectedGraphNode> nodes){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashMap<Integer, Integer>map = new HashMap<Integer, Integer>();
		for (DirectedGraphNode node : nodes){
			for (DirectedGraphNode n: node.neighbors){
				int fa = find(map, node.label);
				int ch = find(map, n.label);
				map.put(fa, ch);
			}
		}
		HashMap<Integer, ArrayList<Integer>> record = new HashMap<Integer, ArrayList<Integer>>();
		for (DirectedGraphNode node: nodes){
			int val = find(map, node.label);
			if (!record.containsKey(val)){
				record.put(val, new ArrayList<Integer>());
			}
			record.get(val).add(node.label);
		}
		
		for (int key : record.keySet()){
			ArrayList<Integer> sub = new ArrayList<Integer>();
			sub.addAll(record.get(key));
			result.add(sub);
		}
		return result;
 	}

	private int find(HashMap<Integer, Integer> map, int label) {
		if (!map.containsKey(label)){
			map.put(label, label);
			return label;
		}
		while (map.get(label) != label)
			label = map.get(label);
		return label;
	}
}
