package main.java.ladders.UnionFind;

/**
 * UnionFind/Disjoint Set data structure implementation.
 * This code was inspired by the union find implementation found in 
 * 'Algorithms Fourth Edition' by Robert Sedgewick and Kevin Wayne.
 * 
 **/



public class UnionFind {
	
	// The number of elements in this union find
	private int size;
	
	// Used to track the size of each of the component
	private int[] sz;
	
	// id[i] points to the parent of i, if id[i] = i then i is a root node
	private int[] id;
	
	// tracks the number of components in the union find
	private int numComponents;
	
	public UnionFind(int size){
		
		//make sure there are positive number of elements
		if(size <= 0) throw new IllegalArgumentException("Size <= 0 is not allowed");
		
		
		this.size = numComponents = size;
		sz = new int[size];
		id = new int[size];
		
		for(int i = 0; i < size; i++){
			id[i] = i; //link to itself(self root)
			sz[i] = 1;//each component is originally of size one
		}
	}
	
	//Find which component/set 'p' be;ongs to, takes amortized constant time.
	public int find(int p){
		
		// Find the root of the component/set
		int root = p;
		while(root != id[root])
			root = id[root];
		
		//compress the path leading back to the root
		//doing this operation is called 'path compression'
		//and is what gives us amortized time complexity
		while(p != root){
			int next = id[p];
			id[p] = root;
			p = next;
		}
		
		return root;
	}
	
	//recursively
	/*public int find(int p){
		if(p == id[p]) return p;
		return id[p] = find(id[p]);
	}*/
	
	//return whether or not the elements 'p' and 'q'
	//are in the same components/set
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	//return the size of the components/set 'p' belongs to
	public int componentSize(int p){
		return sz[find(p)];
	}
	
	//return the number of remaining components/sets
	public int components(){
		return numComponents;
	}
	
	
	// Unify the components.sets containing elements 'p' and 'q'
	public void unify(int p, int q){
		
		int root1 = find(p);
		int root2 = find(q);
		
		if(root1 == root2) //these elements are already in the same group
			return;
		
		if(sz[root1] < sz[root2]){
			sz[root2] += sz[root1];
			id[root1] = root2;
		}else {
			sz[root1] += sz[root2];
			id[root2] = root1;
		}
		
		//since the roots found are different we know that 
		//the number of components/sets has decreased
		numComponents--;
		
	}
	
	

}
