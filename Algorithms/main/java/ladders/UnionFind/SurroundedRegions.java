package main.java.ladders.UnionFind;

import java.util.Arrays;

/**
 * 477. Surrounded Regions - Medium 

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O''s into 'X''s in that surrounded region.

Example
X X X X
X O O X
X X O X
X O X X
After capture all regions surrounded by 'X', the board should be:

X X X X
X X X X
X X X X
X O X X

Tags:Breadth First Search Union Find

Related Problems 
Medium Nearest Exit 32 %
Hard Number of Islands II 19 %
Easy Number of Islands 25 %
 * */
public class SurroundedRegions {
	 /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
	 //Thoughts
	
	 //Union Find Solution with Path compression and weighted union - cool
	 int n, m;
	 private int[] id;
	 private int[] sz; // Used to track the size of each of the component(union Set)
	 private int OOnEdge; // the id of union set for'O''s on the edge
	 
     public void surroundedRegions(char[][] board) {
    	 if((m = board.length) == 0|| (n = board[0].length) == 0) return;
    	 
    	 id = new int[n * m];
    	 sz = new int[n * m];
    	 
    	 Arrays.fill(sz, 1);
    	 OOnEdge = -1;
    	 
    	 for(int i = 0; i < m; i++) {
    		 for(int j = 0; j < n; j++) {
    			 if(board[i][j] == 'X') {
    				 continue;
    			 }
    			 int index = i * n + j;
    			 id[index] = index;
    			 //Nodes on edges
    			 if(i == 0 || j == 0 || i == m - 1 || j == n -1) {
    				 if(OOnEdge == -1) {
    					 //set OOnEdge if it has not been set yet
    					 OOnEdge = index;
    				 }else {
    					 //if OOnEdge is already set, unite it with index
    					 union(OOnEdge, index);
    				 }
    			 }
    			 
    			 //Unite node with its upper neighbor
    			 if(i > 0 && board[i - 1][j] == 'O') {
    				 union(index, index - 1);
    			 }
    			 
    			 //Unite node with it's left neighbor
    			 if(j > 0 && board[i][j - 1] == '0') {
    				 union(index, index - 1);
    			 }
    		 }
    	 }
    	 
    	 //Find
    	 for(int i = 1; i < m - 1; i++) {
    		 for(int j =1; j < n -1; j++) {
    			 if(board[i][j] == 'X')
    				 continue;
    			 int index = i * n + j;
    			 if(OOnEdge == -1 || !find(index, OOnEdge)) {
    				 board[i][j] = 'X';
    			 }
    		 }
    	 }
     }
     
     private void union(int a, int b) {
    	 int i = findRoot(a);
    	 int j = findRoot(b);
    	 
    	 //weighted quick union
    	 if(sz[i] < sz[j]) {
    		 id[i] = j;
    		 sz[j] += sz[i];
    	 }else {
    		 id[j] = i;
    		 sz[i] += sz[j];
    	 }
     }
     
     private boolean find(int a, int b) {
    	 return findRoot(a) == findRoot(b);
     }
     
     private int findRoot(int i) {
    	 while(i != id[i]) {
    		 //path compression
    		 id[i] = id[id[i]];
    		 i = id[i];
    	 }
    	 
    	 return i;
     }

}
