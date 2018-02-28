package main.java.ladders.UnionFind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 178. Graph Valid Tree - Medium

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

 Notice: You can assume that no duplicate edges will appear in edges.
 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Tags: Depth First Search Facebook Zenefits Union Find Breadth First Search Google

Related Problems 
Medium Portal 28 %
Medium Connected Component in Undirected Graph 25 %
 * */
public class GraphValidTree {
	/**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
	
	//Union Find Approach
	/*Thoughts and Motivation for using Union FInd Data Structure
	 * 1- Whether these edges form a loop or  not, if there is a cycle we cannot form a tree
	 * 2- Whether these edges can connect all the nodes or not if there are nodes that cannot be connected
	 * 
	 * Since we do not need to know what a concrete tree looks like, knowing the connectivity is a better way
	 * to look up than deep first search. We define a  data structure for a lookup and
	 * provide a standard four interfaces
	 * 
	 * Union - put two nodes in a collection
	 * Find - Find the node belongs to the collection number
	 * */
	
//	class UnionFind{
//		HashMap<Integer, Integer>father = new HashMap<Integer, Integer>();
//		
//		UnionFind(int n){
//			for(int i=0; i<n; i++) {
//				father.put(i, i);
//			}
//		}
//		
//		// Find the root of the component/set
//		int find(int p) {
//			int root = p;
//			while(root != father.get(root))
//				root = father.get(root);
//			
//			//compress the path leading back to the root
//			//doing this operation is called 'path compression'
//			//and is what gives us amortized time complexity
//			while(p != father.get(root)){
//				int next = root;
//				root = father.get(root);
//				father.put(next, root);
//			}
//			
//			return root;
//		}
//		
//		void union(int x, int y) {
//			int fx = father.get(x);
//			int fy = father.get(y);
//			if(fx != fy)
//				father.put(fx, fy);
//		}
//	}

	/*I liked this version better*/
//	class UnionFind {
//		int []ids;
//		int cnt;
//		
//		public UnionFind(int size) {
//			this.ids = new int[size];
//			for(int i = 0; i < this.ids.length; i++) {
//				this.ids[i]  = i;
//			}
//			this.cnt = size;
//		}
//		
//		public int find(int m) {
//			return ids[m];
//		}
//		
//		public boolean union (int m, int n) {
//			int src = find(m);
//			int dst = find(n);
//			
//			if(src != dst) {
//				//if two nodes are not into the same group collect them into one
//				for(int i = 0; i < ids.length; i++) {
//					if(ids[i] == src) {
//						ids[i] = dst;
//					}
//				}
//				cnt--;
//				return true;
//			}else {
//				return false;
//			}
//		}
//		
//		public boolean areConnected(int m, int n) {
//			return find(m) == find(n);
//		}
//		
//		public int count() {
//			return cnt;
//		}
//		
//	}
//	
//	<!--My fave -->
//	public boolean validTree(int n, int[][]edges) {
//		UnionFind uf = new UnionFind(n);
//		for(int i = 0; i < edges.length; i++) {
//			// If two nodes are already in the same set, a new loop will be generated
//			if(!uf.union(edges[i][0], edges[i][1])) {
//				return false;
//			}
//		}
//		return uf.count() == 1;
//	}
	
	
	public static boolean validTree1(int n, int[][] edges) {
		
		if(n == 0 || edges.length != n -1) return false;
		
		UnionFind ufo = new UnionFind(n);
		for(int [] crt : edges) {
			int p1 = crt[0];
			int p2 = crt[1];
			
			if(ufo.find(p1) != ufo.find(p2)) {
				ufo.unify(p1, p2);
			}else {
				System.out.println("Tree cannot form a cycle");
				return false; //circle
			}
		}
		System.out.println("Its tree!");
		return true;
		
	}
     //BFS Approach - Its like course schedule - topological sort
     	public static boolean validTree(int n, int[][] edges) {
     		
     		if(n == 0 || edges.length != n-1) return false;
     		
     		ArrayList<Integer>[] adjacencyList = new ArrayList[n];
     		for(int i = 0; i < n; i++) {
     			adjacencyList[i] = new ArrayList<Integer>();
     		}
     		
     		//constructing adjacencyList
     		for(int i = 0; i < edges.length; i++) {
     			adjacencyList[edges[i][0]].add(edges[i][1]);
     			adjacencyList[edges[i][1]].add(edges[i][0]);
     		}
     		
     		Queue<Integer>queue = new LinkedList<Integer>();
     		HashSet<Integer> hashSet = new HashSet<Integer>();
     		queue.add(0);
     		hashSet.add(0);
     		
     		//begin BFS
     		while(!queue.isEmpty()) {
     			int size = queue.size();
     			for(int i = 0; i < size; i++) {
     				int node = queue.poll();
     				hashSet.add(node);
     				for(int j = 0; j < adjacencyList[node].size(); j++) {
     					if(!hashSet.contains(adjacencyList[node].get(j))) {
     						queue.offer(adjacencyList[node].get(j));
     					}
     				}
     			}
     		}
     		
     		if(hashSet.size() == n) {
     			System.out.println("its tree!");
     		}else {
     			System.out.println("cycle cannot form a tree");
     		}
     		return hashSet.size() == n;
     	}
     	
     	public static void main(String args[]) {
     		int n = 5;
     		int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}}; //return true
     		int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};  //return false
     		
     		validTree(5, edges2);
     		
     	}

}
