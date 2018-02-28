package Ladder2.DataStructure_I;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 178. Graph Valid Tree - Medium - required

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

Notice: You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.


Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Tags: Depth First Search Facebook Zenefits Union Find Breadth First Search Google

Related Problems 
1- Medium Portal 26 %
2- Medium Connecting Graph 39 %
3- Medium Connected Component in Undirected Graph 25 %
 * */

public class GraphValidTree {
	
	 /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
     //BFS Approach - Its like course schedule - topological sort
     	public boolean validTree1(int n, int[][] edges) {
     	    if(n == 0) return false;
     	    if(edges.length != n-1) return false;
     	    
     	    ArrayList<Integer>[] adjacencyList = new ArrayList[n];
     	    for(int i = 0; i < n; i++)
     	        adjacencyList[i] = new ArrayList<Integer>();
     	    
     	    for(int i = 0; i < edges.length; i++){
     	        adjacencyList[edges[i][0]].add(edges[i][1]);
     	        adjacencyList[edges[i][1]].add(edges[i][0]);
     	    }
     	    
     	    Queue<Integer> queue = new LinkedList<Integer>();
     	    HashSet<Integer> hashSet = new HashSet<Integer>();
     	    queue.add(0);
     	    hashSet.add(0);
     	    
     	    while(!queue.isEmpty()){
     	        int size = queue.size();
     	        for(int i = 0; i < size; i++){
     	            int node = queue.poll();
     	            hashSet.add(node);
     	            for(int j = 0; j < adjacencyList[node].size(); j++){
     	                if(!hashSet.contains(adjacencyList[node].get(j))){
     	                    queue.offer(adjacencyList[node].get(j));
     	                }
     	            }
     	        }
     	    }
     	    
     	    return hashSet.size() == n;
     	    
     	}
     	
     //DFS Approach
     	public boolean validTree(int n, int[][] edges) {
     	    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
     	    
     	    for(int i = 0; i < n; i++){
     	        ArrayList<Integer> list = new ArrayList<Integer>();
     	        map.put(i, list);
     	    }
     	    
     	    for(int[] edge : edges){
     	        map.get(edge[0]).add(edge[1]);
     	        map.get(edge[1]).add(edge[0]);
     	    }
     	    
     	    boolean[] visited = new boolean[n];
     	    if(!dfs(0, -1, map, visited))
     	        return false;
     	  
     	    for(boolean b : visited){
     	        if(!b)
     	            return false;
     	    }
     	    
     	    return true;
     	}
     	
     	public boolean dfs(int curr, int parent, HashMap<Integer, ArrayList<Integer>>map, boolean[] visited){
     	    if(visited[curr])
     	        return false;
     	        
     	    visited[curr] = true;
     	    
     	    for(int i : map.get(curr)){
     	        if(i != parent && !dfs(i,curr, map, visited))
     	            return false;
     	    }
     	    
     	    return true;
     	}
     
     
     //Union Find Approach
//      	private class UnionFind {
//      		HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
//
//			UnionFind(int n) {
//				for (int i =0; i< n; i++){
//					father.put(i,i);
//				}
//			}
//
//			int find(int x) {
//				int crt =x ;
//				while(father.get(crt)!=crt){
//					crt = father.get(crt);
//				}
//				int fa = crt;
//				crt= x;
//				while(father.get(crt)!=fa){
//					int temp = crt;
//					crt= father.get(crt);
//					father.put(temp, fa);
//				}
//				return fa;
//			}
//	
//			void union(int x, int y) {
//				int fx= father.get(x);
//				int fy = father.get(y);
//				if(fx!=fy){
//					father.put(fx,fy);
//				}
//			}
//	}

	/**
	 * @param n an integer
	 * @param edges a list of undirected edges
	 * @return true if it's a valid tree, or false
	 */
	public boolean validTree2(int n, int[][] edges) {
			if(n-1!=edges.length){
				return false;
			}
			UnionFind uf = new UnionFind(n);
		for(int [] crt : edges){
			int a = crt[0];
			int b = crt[1];
			if(uf.find(a)!=uf.find(b)){
				uf.union(a,b);
			}else{
				//circle
				return false;
			}
		}
		return true;
	}


}
