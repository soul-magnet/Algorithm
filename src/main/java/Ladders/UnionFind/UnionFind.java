package UnionFind.Heap;

/**
 * UnionFind/Disjoint Set data structure implementation 
 * This code is an inspired modification of the union find implementation found in 
 * 'Algorithms Fourth Edition' by Robert Sedgewick and Kevin Wayne.
 *
 * @author Emine.Topkaya
 **/


public class UnionFind {
	
	private int size;
	private int[] sz;
	private int[] id;
	private int numComponents;
	
	public UnionFind(int size){
		if(size <= 0){
			throw new IllegalArgumentException("Size <= 0 is not allowed");
		}
		
		this.size = numComponents = size;
		sz = new int[size];
		id = new int[size];
		
		for(int i = 0; i < size; i++){
			id[i] = i; //link to itself(self root)
			sz[i] = 1;//each component is originally of size one
		}
	}
	
	public int find(int p){
		int root = p;
		while(root != id[root])
			root = id[root];
		
		//compress the path leading back to the root
		while(p != root){
			int next = id[p];
			id[p] = root;
			p = next;
		}
		
		return root;
	}
	
	//recursivelly
	/*public int find(int p){
		if(p == id[p]) return p;
		return id[p] = find(id[p]);
	}*/
	
	
	
	

}
