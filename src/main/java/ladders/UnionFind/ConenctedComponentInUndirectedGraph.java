package main.java.ladders.UnionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 431. Connected Component in Undirected Graph - Medium

Find the number connected component in the undirected graph. 
Each node in the graph contains a label and a list of its neighbors. 
(a connected component (or just component) of an undirected graph is a subgraph 
in which any two vertices are connected to each other by paths, 
and which is connected to no additional vertices in the supergraph.)

 Notice
Each connected component should sort by label.

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

Tags: Breadth First Search Union Find

Related Problems 
Medium Graph Valid Tree 27 %
 * */

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


public class ConenctedComponentInUndirectedGraph {
	
	/**
	 * @param nodes a array of Undirected graph node
	 * @return a connected set of a Undirected graph
	 */
	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
		//
		HashSet<Integer> set = new HashSet<>();
		for(UndirectedGraphNode node : nodes) {
			set.add(node.label);
		}
		
		UnionFind uf = new UnionFind(set);
		for(UndirectedGraphNode node: nodes) {
			for(UndirectedGraphNode neighbor : node.neighbors) {
				uf.union(node.label, neighbor.label);
			}
		}
		
		return print(uf, set);
	}
	
	public List<List<Integer>> print(UnionFind uf, HashSet<Integer>set){
		 HashMap<Integer, List<Integer>> map = new HashMap<>();
		 
		 for (Integer nodeLabel : set) {
	            int root = uf.find(nodeLabel);
	            if (!map.containsKey(root)) {
	                List<Integer> list = new ArrayList<>();
	                list.add(nodeLabel);
	                map.put(root, list);
	            }
	            else {
	                map.get(root).add(nodeLabel);
	            }
	        }
	        
	        List<List<Integer>> res = new ArrayList<>();
	        for (List<Integer> list : map.values()) {
	            Collections.sort(list);
	            res.add(list);
	        }
	        
	        return res;
	}
	
	class UnionFind {
		public HashMap<Integer, Integer> root;
		
		public UnionFind(HashSet<Integer> set) {
			root = new HashMap<>();
			for(Integer node : set) {
				root.put(node, node);
			}
		}
		
		public int find(int node) {
			while(node != root.get(node)) {
				root.put(root.get(node), root.get(root.get(node)));
				node = root.get(node);
			}
			return node;
		}
		
		public void union(int src, int dst) {
			int p1 = find(src);
			int p2 = find(dst);
			if(p1 != p2)
				root.put(root.get(p1), p2);
		}
	}

}
