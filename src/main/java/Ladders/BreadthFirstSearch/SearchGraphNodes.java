package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import GraphSearch.UndirectedGraphNode;

/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


/**Given a undirected graph, a node and a target, 
 * return the nearest node to given node which value of it is target, 
 * return NULL if you can't find.

There is a mapping store the nodes' values in the given parameters.

 Notice

It's guaranteed there is only one available solution

Have you met this question in a real interview? Yes
Example
2------3  5
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      1 --4
Give a node 1, target is 50

there a hash named values which is [3,4,10,50,50], represent:
Value of node 1 is 3
Value of node 2 is 4
Value of node 3 is 10
Value of node 4 is 50
Value of node 5 is 50

Return node 4
Tags 
Apple Breadth First Search

*/
public class SearchGraphNodes {
	
	 /*
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */
	//Thoughs: this problem uses BFS - seeking shortest path genereally uses BFS
	
	    /*
	     * @param graph: a list of Undirected graph node
	     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
	     * @param node: an Undirected graph node
	     * @param target: An integer
	     * @return: a node
	     */
	    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
	                                          Map<UndirectedGraphNode, Integer> values,
	                                          UndirectedGraphNode node,
	                                          int target) {
	       Queue<UndirectedGraphNode> queue = new LinkedList<>();
	       queue.offer(node);
	       
	       HashSet<UndirectedGraphNode> visited = new HashSet<>();
	       visited.add(node);
	       
	       while(!queue.isEmpty()){
	           UndirectedGraphNode vertex = queue.poll();
	           if(values.get(vertex) == target)
	                return vertex;
	                
	            for(UndirectedGraphNode neighbor : vertex.neighbors){
	                if(visited.contains(neighbor))
	                    continue;
	                    
	                if(values.get(neighbor) == target)
	                    return neighbor;
	                    
	                queue.offer(neighbor);
	                visited.add(neighbor);
	            }
	       }
	       
	       return null;
	    }
}
