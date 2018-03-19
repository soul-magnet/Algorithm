package main.java.ladders.BreadthFirstSearch;
/**
 * 127. Topological Sorting - Medium - Required
e
Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

 Notice
You can assume that there is at least one topological order in the graph.

Clarification
Learn more about representation of graphs

Example
For graph as follow:

picture

The topological order can be:

[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...
Challenge 
Can you do it in both BFS and DFS?

Tags: LintCode Copyright Geeks for Geeks Depth First Search Topological Sort Breadth First Search

Related Problems 
Medium Course Schedule 22 %
Medium Course Schedule II 21 %
Medium Sequence Reconstruction 19 %
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class TopologicalSorting {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
     //BFS Version 1 with Queue
    public ArrayList<DirectedGraphNode> topSort1(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode,Integer> map = new HashMap<>();
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        for(DirectedGraphNode node: graph){
            for (DirectedGraphNode neighbor: node.neighbors){
                if(map.containsKey(neighbor)){
                    map.put(neighbor, map.get(neighbor)+1);
                }else{
                    map.put(neighbor,1);
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<>();
        for (DirectedGraphNode node: graph){
            if(!map.containsKey(node)){
                q.offer(node);
                //The first node in the order can be any node in the graph with no nodes direct to it.
                res.add(node);
            }
        }
        while(!q.isEmpty()){
            DirectedGraphNode node = q.poll();
            for(DirectedGraphNode neighbor:node.neighbors){
                map.put(neighbor,map.get(neighbor)-1);
                if(map.get(neighbor)==0){
                    res.add(neighbor);
                    q.offer(neighbor);
                }
                
            }
        }
        
        return res;
    }
    //BFS Version 2 with Stack
    public ArrayList<DirectedGraphNode> topSort2(ArrayList<DirectedGraphNode> graph) {
        Stack<DirectedGraphNode> stack = new Stack<>();
        HashMap<DirectedGraphNode, Integer> map= new HashMap<>();
        for(DirectedGraphNode node: graph){
           for(DirectedGraphNode neightbor: node.neighbors){
               if(map.containsKey(neightbor)){
                   map.put(neightbor, map.get(neightbor)+1);
               }else{
                   map.put(neightbor,1);
               }
           }
        }
        for(DirectedGraphNode node: graph){
            if(!map.containsKey(node)){
                stack.push(node);
            }
        }
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        while(!stack.isEmpty()){
            DirectedGraphNode crt = stack.pop();
            res.add(crt);
            for(DirectedGraphNode node: crt.neighbors){
                int indegree =  map.get(node)-1;
                map.put(node, map.get(node)-1);
                if(indegree==0){
                    stack.push(node);
                }
            }
        }
        return res;
    }
    
    //BFS Approach
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
    
    
    
}