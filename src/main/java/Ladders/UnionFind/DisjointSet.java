package UnionFind.Heap;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

	private Map<Long, Node> map = new HashMap<>();
	
	class Node {
		long data;
		Node parent;
		int rank;
	}
	
	/*
	 * Create a set with only one element
	 * */
	
	public void makeSet(long data){
		Node node = new Node();
		node.data = data;
		node.parent = data;
		node.rank = 0;
		map.put(data, node);
	}
	
	/*
	 * Combines two sets together to one
	 * Does union by rank
	 * 
	 * @return data1 and data2 are in different set before union else false
	 * 
	 * */
	public boolean union(long data1, long data2){
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);
		
		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);
	}
}
