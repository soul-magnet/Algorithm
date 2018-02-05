package Ladder2.DataStructure_I;
/**591. Connecting Graph III - Medium - required
 * Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), an edge to connect node a and node b
2. query(), Returns the number of connected component in the graph


Example
5 // n = 5
query() return 5
connect(1, 2)
query() return 4
connect(2, 4)
query() return 3
connect(1, 4)
query() return 3

Tags: Union Find

Related Problems 
1- Hard Minimum Spanning Tree 26 %
2- Medium Connecting Graph II 37 %
3- Medium Connecting Graph 39 %
 * 
 * */

public class ConnectingGraph3 {
	
   int father[]= null;
   int ct  = 0;
   public ConnectingGraph3(int n) {
       father = new int[n+1];
       ct = n;
       for(int i=1; i< n+1; i++){
           father[i] = i;
       }
   }

   public void connect(int a, int b) {
       int root_a = find (a);
       int root_b = find(b);
       if(root_a!=root_b){
          ct--;
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

   public int query() {

       return ct;
   }

}
