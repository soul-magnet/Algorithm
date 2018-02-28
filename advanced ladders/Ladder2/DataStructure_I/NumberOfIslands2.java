package Ladder2.DataStructure_I;
/**
 * 
 * 434. Number of Islands II - Hard - Required
 
Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). 
Originally, the 2D matrix is all 0 which means there is only sea in the matrix. 
The list pair has k operator and each operator has two integer A[i].x, A[i].y means that 
you can change the grid matrix[A[i].x][A[i].y] from sea to island. 
Return how many island are there in the matrix after each operator.

Notice: 0 is represented as the sea, 1 is represented as the island. 
If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.


Example
Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].

return [1,1,2,2].

Tags: Union Find Google

Related Problems 
Medium Number of Big Islands 21 %
Hard Minimum Spanning Tree 26 %
Medium Connecting Graph 39 %
Medium Surrounded Regions 23 %
Easy Number of Islands 25 %
Medium Find the Weak Connected Component in the Directed Graph
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

class Point{
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
	
}
public class NumberOfIslands2 {
//    	private class UnionFind{
//		    int n,m;
//			HashMap<Integer,Integer> hm = new HashMap<>();
//			UnionFind(int n, int m){
//			    this.n=n;
//	            this.m=m;
//				for(int i=0; i< n; i++){
//					for (int j=0; j< m; j++){
//						hm.put(i*m+j, i*m+j);
//					}
//				}
//			}
//			int find(int crt){
//				int now =crt;
//				while(hm.get(now)!=(now)){
//					now = hm.get(now);
//				}
//				int father = now;
//				now =crt;
//				while(!hm.get(now).equals(father)){
//					int temp = now ;
//					now = hm.get(now);
//					hm.put(temp, father);
//				}
//				return father;
//			}
//			void  union(int a, int b){
//				int father_a = find(a);
//				int father_b = find(b);
//				if(father_a!=(father_b)){
//					hm.put(father_a, father_b);
//				}
//			}
//	}
	public List<Integer> numIslands2(int n, int m, Point[] operators) {
		List<Integer> res = new ArrayList<>();
		if(n==0||m==0||operators==null){
			return res;
		}
		UnionFind uf = new UnionFind(n,m);
		int ct =0;
		boolean [][] visited = new boolean[n][m];
		int [][] ditections = {
				{0,1},{1,0},{0,-1},{-1,0}
		};
		for(Point now : operators){
		    ct++;
			visited[now.x][now.y]= true;
			for(int [] crt : ditections){
				int x= crt[0]+ now.x;
				int y= crt[1]+ now.y;
				if(x>-1&&y>-1&&x<n&&y<m&&visited[x][y]){
					int father_now = uf.find(now.x*m+now.y);
					int father_new = uf.find(x*m+y);
					if(father_new!=(father_now)){
						uf.union(father_now, father_new);
						ct--;
					}
				}
			}
			res.add(ct);
		}
		return res;
	}
}