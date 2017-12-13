package GraphSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author Emine.Topkaya
 * 
 * Given a directed acyclic graph, do a topological sort on this graph
 * Do DFS by keeping visited. Put the vertex which are completely explored 
 * into a stack. Pop from stack to get sorted order.
 * 
 * Space and time complexity O(n)
 * 
 * */
public class TopologicalSorting <T>{
	
	public Deque<Vertex<T>> topSort(Graph<T> graph) {
		Deque<Vertex<T>> stack = new ArrayDeque();
		Set<Vertex<T>> visited = new HashSet<>();
		for (Vertex<T> vertex : graph.getAllVertex()) {
			if (visited.contains(vertex)){
				continue;
			}
			topSortUtil(vertex, stack, visited);
		}
		return stack;
	}
	
	private void topSortUtil(Vertex<T> vertex, Deque<Vertex<T>> stack, Set<Vertex<T>> visited) {
		visited.add(vertex);
		for(Vertex<T> childVertex : vertex.getAdjacentVertexes()){
			if(visited.contains(childVertex)){
				continue;
			}
			topSortUtil(childVertex, stack, visited);
		}
		stack.offerFirst(vertex);
	}
	
	public static void main(String args[]){
		Graph<Integer> graph = new Graph<>(true);
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        
        TopologicalSorting<Integer> sort = new TopologicalSorting<Integer>();
        Deque<Vertex<Integer>> result = sort.topSort(graph);
        while(!result.isEmpty()){
        	System.out.println(result.poll());
        }
	}
	
	//version II - from Lint Code
	public ArrayList<DirectedGraphNode> topSort2(ArrayList<DirectedGraphNode> graph){
		
		HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
		ArrayList<DirectedGraphNode> result = new ArrayList<>();
		for(DirectedGraphNode node : graph){
			for(DirectedGraphNode neighbor : node.neighbors){
				if(map.containsKey(neighbor)){
					map.put(neighbor, map.get(neighbor)+1);
				}else{
					map.put(neighbor, 1);
				}
			}
		}
		
		Queue<DirectedGraphNode> queue = new LinkedList<>();
		for(DirectedGraphNode node : graph){
			if(!map.containsKey(node)){
				queue.offer(node);
				//the first node in the order can be any node in the graph
				// with no nodes directed to it.
				result.add(node);
			}
		}
		
		while(!queue.isEmpty()){
			DirectedGraphNode node = queue.poll();
			for(DirectedGraphNode neighbor : node.neighbors){
				map.put(neighbor, map.get(neighbor) - 1);
				if(map.get(neighbor) == 0){
					result.add(neighbor);
				}
			}
		}
		return result;
	}
	
	public ArrayList<DirectedGraphNode> topSort3(ArrayList<DirectedGraphNode> graph){
		Stack<DirectedGraphNode>stack = new Stack<>();
		HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
		for(DirectedGraphNode node: graph){
			for(DirectedGraphNode neighbor: node.neighbors){
				if(map.containsKey(neighbor)){
					map.put(neighbor, map.get(neighbor)+1);
				}else{
					map.put(neighbor, 1);
				}
			}
		}
		
		for(DirectedGraphNode node: graph){
			if(!map.containsKey(node)){
				stack.push(node);
			}
		}
		
		ArrayList<DirectedGraphNode> result = new ArrayList<>();
		while(!stack.isEmpty()){
			DirectedGraphNode crt = stack.pop();
			result.add(crt);
			for(DirectedGraphNode node : crt.neighbors){
				int indegree = map.get(node)-1;
				map.put(node, map.get(node)-1);
				if(indegree == 0){
					stack.push(node);
				}
			}
		}
		
		return result;
	}
	

}
