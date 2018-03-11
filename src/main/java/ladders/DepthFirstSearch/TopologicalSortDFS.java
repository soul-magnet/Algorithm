package DepthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import GraphSearch.DirectedGraphNode;

//provide the implementaion in both ways using ArrayDeque Stack and HashSet from tushar roy and 
//Sack with ArrayList HashMap
public class TopologicalSortDFS {
	
	/**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */  
	public Deque<DirectedGraphNode> topSort(Deque<DirectedGraphNode> graph){
		if(graph == null || graph.size() == 0) return graph;
		
		Deque<DirectedGraphNode> stack = new ArrayDeque<>();
		Set<DirectedGraphNode> visited = new HashSet<>();
		
		for(DirectedGraphNode vertex : graph){
			for(DirectedGraphNode neighbor : vertex.allVetex){
				if(visited.contains(vertex)){
					continue;
				}
				topSortUtil(vertex, stack, visited);
			}
			
			
		}
		
		return stack;
		
	}
	
	private void topSortUtil(DirectedGraphNode vertex, Deque<DirectedGraphNode>stack,
			Set<DirectedGraphNode>visited){
		
		visited.add(vertex);
		for(DirectedGraphNode childVertex : vertex.allVetex){
			if(visited.contains(childVertex)){
				continue;
			}
			
			topSortUtil(childVertex, stack, visited);
		}
		
		stack.offerFirst(vertex);
	}
	

}
