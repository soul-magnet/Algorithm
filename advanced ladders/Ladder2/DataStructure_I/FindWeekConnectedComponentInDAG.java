package Ladder2.DataStructure_I;
/**
 * 
 * 432. Find the Weak Connected Component in the Directed Graph - medium - required
 
Find the number Weak Connected Component in the directed graph. Each node in the graph contains a label and a list of its neighbors. (a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)

 Notice: Sort the element in the set in increasing order


Example
Given graph:

A----->B  C
 \     |  | 
  \    |  |
   \   |  |
    \  v  v
     ->D  E <- F
Return {A,B,D}, {C,E,F}. Since there are two connected component which are {A,B,D} and {C,E,F}

Tags: Union Find

Related Problems 
1-Medium Connecting Graph 39 %
2-Hard Number of Islands II 19 %
3-Medium Find the Weak Connected Component in the Directed Graph 26 %
4-Medium Connected Component in Undirected Graph 25 %

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class FindWeekConnectedComponentInDAG {
   	/**
	 * @author K25553
	 * @param <T>
	 *
	 */
	
	private class DirectedGraphNode {
		int label;
		ArrayList<DirectedGraphNode> neighbors;
		DirectedGraphNode(int x) { 
			label = x; 
			neighbors = new ArrayList<DirectedGraphNode>(); 
		}
	};
		 
//	private class UnionFind<T> {
//		Map<T, T> hm = new HashMap<T, T>();
//		public UnionFind(HashSet<T> hs) {
//			for(T a: hs){
//				hm.put(a, a);
//			}
//		}
//		
//		public T  find(T x) {
//			T father = hm.get(x);
//			while (father!=hm.get(father)){
//				father=hm.get(father);
//			}
//			//compress_find from link to star map
//			T temp ;
//			T next= hm.get(x);
//			while(next!=hm.get(next) ){
//				temp= hm.get(next);
//				hm.put(next, father);
//				next=temp;
//			}
//			return father;
//		}
//		
//		public void union ( T x, T y){
//			T fx= hm.get(x);
//			T fy= hm.get(y);
//			if (fx!= fy){
//				hm.put(fx, fy);
//			}
//		}
//		
//	}
	/**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
	public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
		HashSet<DirectedGraphNode> set = new HashSet<DirectedGraphNode>(nodes);
        UnionFind<DirectedGraphNode> uf = new UnionFind<DirectedGraphNode>(set);
        for(DirectedGraphNode crt: nodes){
        	for(DirectedGraphNode neighbor : crt.neighbors){
        		DirectedGraphNode cfa= uf.find(crt);
        		DirectedGraphNode nfa = uf.find(neighbor);
        		if (!cfa.equals(nfa)){
        			uf.union(cfa, nfa);
        		}
        	}
        }
        
        return print(nodes, uf);
    }
	private List<List<Integer>> print(ArrayList<DirectedGraphNode> nodes,
			UnionFind<DirectedGraphNode> uf) {
		HashMap<DirectedGraphNode, ArrayList<Integer>> hashMap = new HashMap<>();
		for(DirectedGraphNode crt	: nodes){
			DirectedGraphNode cfa = uf.find(crt);
			if(hashMap.containsKey(cfa)){
				hashMap.get(cfa).add(crt.label);
			}else{
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(crt.label);
				hashMap.put(cfa,list );
			}
		}
		List<List <Integer> > ans = new ArrayList<List<Integer>>();
		 for( List <Integer> now: hashMap.values()) {
	            Collections.sort(now);
	        	ans.add(now);
	        }
			return ans;
	}
}
