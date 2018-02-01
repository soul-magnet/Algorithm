package DataStructureI;
/**
 * 589. Connecting Graph  - Medium - required

Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), add an edge to connect node a and node b. 2.query(a, b)`, check if two nodes are connected


Example
5 // n = 5
query(1, 2) return false
connect(1, 2)
query(1, 3) return false
connect(2, 4)
query(1, 4) return true

Tags: Union Find

Related Problems 
1- Hard Minimum Spanning Tree 26 %
2- Medium Connecting Graph III 55 %
3- Medium Connecting Graph II 37 %
4- Medium Graph Valid Tree 27 %
5- Medium Surrounded Regions 23 %
6- Hard Number of Islands II 19 %
7- Medium Find the Weak Connected Component in the Directed Graph 26 %
 * */

public class ConnectingGraph { 
	   int father [] =null;
	    public ConnectingGraph(int n) {
	       father = new int [n+1];
	        for (int i = 1; i< n+1; i++){
	            father[i] = i;
	        }
	    }

	    public void connect(int a, int b) {
	        int root_a = find(a);
	        int root_b = find(b);
	        if(root_a!=root_b){
	            father[root_a]=father[root_b];
	        }
	    }

	    private int find(int a) {
	        if(father[a]==a){
	            return a;
	        }
	        father[a] =find(father[a]);
	        return father[a];
	    }

	    public boolean  query(int a, int b) {
	       return find(a)==find(b);
	    }
	}