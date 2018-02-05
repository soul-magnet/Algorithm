package Ladder2.DataStructure_I;

/**590. Connecting Graph II   - Medium - required
 * Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
   You need to support the following method:
   1. connect(a, b), an edge to connect node a and node b
   2. query(a), Returns the number of connected component nodes which include node a.
 *
 * 
 * Example
	5 // n = 5
	query(1) return 1
	connect(1, 2)
	query(1) return 2
	connect(2, 4)
	query(1) return 3
	connect(1, 4)
	query(1) return 3
	
	
	Tags: Union Find
	
	Related Problems 
	1- Hard Minimum Spanning Tree 26 %
	2- Medium Connecting Graph III 55 %
	3-  Connecting Graph
 * 
 * */

public class ConnectingGraph2 {
    int father[]= null;
    int ct[] = null;
    public ConnectingGraph2(int n) {
      father = new int[n+1];
        ct = new int [ n+1];
        for(int i=1; i< n+1; i++){
            father[i] = i;
            ct[i] = 1;
        }
    }

    public void connect(int a, int b) {
        int root_a = find (a);
        int root_b = find(b);
        if(root_a!=root_b){
            ct[root_b] += ct[root_a];
            father[root_a] = root_b;
        }
    }

    private int find(int a) {
        if(father[a]== a){
            return a;
        }
        father[a] = find(father[a]);
        return father[a];
    }

    public int query(int a) {
        int root_a = find (a);
        return ct[root_a];
    }
}
