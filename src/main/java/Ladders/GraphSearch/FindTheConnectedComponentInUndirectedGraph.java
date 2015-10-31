package GraphSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * Find the number connected component in the undirected graph. 
 * Each node in the graph contains a label and a list of its neighbors. 
 * (a connected component (or just component) of an undirected graph 
 * is a subgraph in which any two vertices are connected to each other 
 * by paths, and which is connected to no additional vertices 
 * in the supergraph.)
 * Example Given graph:

A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component 
which is {A,B,D}, {C,E}

*/
/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class FindTheConnectedComponentInUndirectedGraph {
	/**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
	
	// Breath First Search version
	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
		int m = nodes.size();
		Map<UndirectedGraphNode, Boolean>visited = new HashMap<>();
		
		for (UndirectedGraphNode node: nodes){
			visited.put(node, false);
		}
		List<List<Integer>> result = new ArrayList<>();
		for (UndirectedGraphNode node : nodes){
			if (visited.get(node) == false){
				if (visited.get(node) == false){
					bfs(node, visited, result);
				}
			}
		}
		return result;
	}

	private void bfs(UndirectedGraphNode node, 
					Map<UndirectedGraphNode, 
					Boolean> visited, 
					List<List<Integer>> result) {
		List<Integer>row = new ArrayList<>();
		Queue<UndirectedGraphNode>queue = new LinkedList<>();
		visited.put(node, true);
		queue.offer(node);
		
		while(!queue.isEmpty()){
			UndirectedGraphNode u = queue.poll();
			row.add(u.label);
			
			for (UndirectedGraphNode v : u.neighbors){
				if (visited.get(v) == false){
					visited.put(v, true);
					queue.offer(v);
				}
			}
		}
		Collections.sort(row);
		result.add(row);
	}
	
	// Depth First Search Version
	
	public List<List<Integer>> connectedSet2(ArrayList<UndirectedGraphNode>nodes){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
		for(UndirectedGraphNode node: nodes){
			if(!visited.contains(node)){
				dfs(node, visited, path);
				result.add(new ArrayList<Integer>(path));
				path.clear();
			}
		}
		return result;
	}
	public void dfs(UndirectedGraphNode node, 
			Set<UndirectedGraphNode>visited,
			List<Integer>path){
		visited.add(node);
		path.add(node.label);
		for(UndirectedGraphNode n : node.neighbors){
			if(!visited.contains(n)){
				dfs(n, visited, path);
			}
		}
	}
	
}
