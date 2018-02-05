package DataStructureI;

/**
 * 433. Number of Islands - Easy - required

Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. 
If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Find the number of islands.

Example
Given graph:

[
[1, 1, 0, 0, 0],
[0, 1, 0, 0, 1],
[0, 0, 0, 1, 1],
[0, 0, 0, 0, 0],
[0, 0, 0, 0, 1]
]
return 3.

Tags: Google Facebook Zenefits

Related Problems 
1- Medium Number of Big Islands 21 %
2- Medium Nearest Exit 31 %
3- Medium Surrounded Regions 23 %
4- Hard Number of Islands II
 * 
 * */

public class NumberOfIslands {
	private int n, m;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
	 /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
  /*  public int numIslands(boolean[][] g) {
       int ct= 0;
       n=g.length;
       
       if(n==0){
           return 0;
       }
       
       m=g[0].length;
       if(m==0){
           return 0;
       }
       
       for(int i=0; i<n;i++){
    	   for(int j=0; j<m;j++){
    		   if (g[i][j]==true){
    			   UnionFind(i,j,g);
    			   ct++;
    		   }
    	   }
       }
       return ct;
    }
    
	private void UnionFind(int i, int j, boolean[][] g) {
		g[i][j]=false;
		for(int d=0;d<4;d++ ){
			int x= i+dx[d];
			int y= j+dy[d];
			if (x<n&&y<m&&x>=0&&y>=0&&g[x][y]==true){
				UnionFind(x,y,g);
			}
		}
	}	*/

}
