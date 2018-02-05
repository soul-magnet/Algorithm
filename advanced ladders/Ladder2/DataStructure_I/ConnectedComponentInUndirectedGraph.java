package Ladder2.DataStructure_I;
/**
 * 431. Connected Component in Undirected Graph - required

Find the number connected component in the undirected graph. 
Each node in the graph contains a label and a list of its neighbors. 
(a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)

 Notice: Each connected component should sort by label.

Clarification: Learn more about representation of graphs

Example
Given graph:

A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}

Tags: Union Find Breadth First Search

Related Problems 
1- Medium Graph Valid Tree 27 %
2- Medium Find the Weak Connected Component in the Directed Graph 26 %
 * */

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class ConnectedComponentInUndirectedGraph {
    public class UnionFind<T>{
		Map<T,T> father = new HashMap<T, T>();
		public UnionFind(List<T> set){
			for(T crt: set){
				father.put(crt,crt);
			}
		}
		public T find(T a){
			if(father.get(a).equals(a)){
				return a;
			}
			//father.put(a, find(father.get(a)));
			T root = a;
			while(!father.get(root).equals(root)){
				root =father.get(root);
			}
			T crt= a;
			while(!father.get(crt).equals(root)){
				crt = father.get(crt);
				father.put(crt, root);
			}
			return root;
		}
		public void union(T a, T b){
			T roota= find(a);
			T rootb =find(b);
			if(!roota.equals(rootb)){
				father.put(roota,rootb);
			}
		}
	}
	/**
	 * @param nodes a array of Undirected graph node
	 * @return a connected set of a Undirected graph
	 */
	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
		UnionFind<UndirectedGraphNode> unionFind = new UnionFind(nodes);
		HashSet<UndirectedGraphNode> visited = new HashSet<>();
		for(UndirectedGraphNode crt: nodes){
			for(UndirectedGraphNode neighbor : crt.neighbors){
				if(visited .contains(neighbor)){
					continue;
				}
				UndirectedGraphNode root_crt = unionFind.find(crt);
				UndirectedGraphNode root_neighbor = unionFind.find(neighbor);
				if(!root_crt.equals(root_neighbor)){
					unionFind.union(root_neighbor,root_crt);
				}
			}
			visited.add(crt);
		}
		HashMap<UndirectedGraphNode, List<Integer>> res = new HashMap<>();

		for( UndirectedGraphNode crt: visited){
			UndirectedGraphNode root_crt = unionFind.find(crt);
			if(!res.containsKey(root_crt)){
				res.put(root_crt, new ArrayList<Integer>());
			}
			res.get(root_crt).add(crt.label);
		}
		List<List<Integer>> res1 = new ArrayList<>();
				res1.addAll(res.values());
		for(List<Integer> crt: res1){
			Collections.sort(crt);
		}
		return res1;
	}
     public List<List<Integer>> connectedSet1(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        
        int m = nodes.size();
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        
       for (UndirectedGraphNode node : nodes){
            visited.put(node, false);
       }
        
        List<List<Integer>> result = new ArrayList<>();
        
        for (UndirectedGraphNode node : nodes){
            if (visited.get(node) == false){
                bfs(node, visited, result);
            }
        }
        
        return result;
    }
    
    
    public void bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> visited, List<List<Integer>> result){
        
        
		List<Integer> list = new ArrayList<Integer>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.offer(node);
		visited.put(node, true);
		while(!queue.isEmpty()){
			UndirectedGraphNode crt = queue.poll();
			list.add(crt.label);

			for(UndirectedGraphNode neighbor: crt.neighbors){
				if(visited.get(neighbor)==false){
					//must check the neighbor is visited, since each neighbor may connect to each other( circle), we must add the node that is unvisited
					queue.offer(neighbor);
					visited.put(neighbor,true);
				}
				
			}
		}
		Collections.sort(list);
		result.add(list);
    }
}