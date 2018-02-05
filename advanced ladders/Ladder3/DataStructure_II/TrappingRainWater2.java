package Ladder3.DataStructure_II;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 364. Trapping Rain Water II - Hard - Rquired 

Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1, 
compute how much water it is able to trap after raining.

Example
Given 5*4 matrix

[12,13,0,12]
[13,4,13,12]
[13,8,10,12]
[12,13,12,12]
[13,13,13,13]
return 14.

Tags: LintCode Copyright Heap Matrix

Related Problems 
Medium Trapping Rain Water 37 %
 * */
public class TrappingRainWater2 {
	
	 class Cell{
		    public int x,y, h;
		    Cell(){}
		    Cell(int xx,int yy, int hh){
		        x= xx;
		        y= yy;
		        h =hh;
		    }
		}
		 class CellComparator implements Comparator<Cell> {
			@Override
		    public int compare(Cell x, Cell y)
		    {
		       return x.h-y.h;
		    }
		} 
		 
		 
	final static int [][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
	public int trapRainWater(int[][] heights) {
		if(heights==null||heights.length<3||heights[0].length<3){
			return 0;
		}
		 boolean visited[][] = new boolean[heights.length][heights[0].length];
		PriorityQueue<Cell> priorityQueue = new PriorityQueue<Cell>(1,new CellComparator());
		for(int i= 0 ; i< heights[0].length;i++){
			priorityQueue.offer(new Cell(0, i,heights[0][i] ));
			priorityQueue.offer(new Cell(heights.length-1, i, heights[heights.length-1][i]));
			visited[0][i] = true;
			visited[heights.length-1][i] = true;
		}
		for(int i= 0 ; i< heights.length;i++){
			priorityQueue.offer(new Cell(i, 0,heights[i][0] ));
			priorityQueue.offer(new Cell(i, heights[0].length-1, heights[i][heights[0].length-1]));
			visited[i][0] =true;
			visited[i][heights[0].length-1]= true;
		}
		int res =0;
		while(!priorityQueue.isEmpty()){
			Cell crt = priorityQueue.poll();
			for(int i[]:directions){
				int x = crt.x + i[0];
				int y = crt.y + i[1];
				if(x>-1&&y>-1&&x<heights.length&&y<heights[0].length&&!visited[x][y]){
				//      System.out.println(crt.h );
				//  	System.out.println(heights[x][y] );
				    visited[x][y]=true;
					priorityQueue.offer(new Cell(x,y,Math.max(crt.h,heights[x][y])));
					res = res+ Math.max(0, crt.h-heights[x][y] );
				}
			}
		}
		return  res;
	}

}

//Juizhang Solution
class Cell{
	  public int x,y, h;
	  Cell(){}
	  Cell(int xx,int yy, int hh){
	    x = xx;
	    y = yy;
	    h = hh;
	  }
	}
	class CellComparator implements Comparator<Cell> {
	  @Override
	  public int compare(Cell x, Cell y)
	  {
	    if(x.h > y.h)
	      return 1;
	    else if(x.h == y.h){
	     return 0;
	    }
	    else {
	      return -1;
	    }
	  }
	} 


	public class Solution {
	  int []dx = {1,-1,0,0};
	  int []dy = {0,0,1,-1};
	  public  int trapRainWater(int[][] heights) {
	       // write your code here
	      if(heights.length == 0)  
	        return 0;
	      PriorityQueue<Cell> q =  new PriorityQueue<Cell>(new CellComparator());
	      int n = heights.length;
	      int m = heights[0].length;
	      int [][]visit = new int[n][m];
	      
	      for(int i = 0; i < n; i++) {
	        q.offer(new Cell(i,0,heights[i][0]));

	        q.offer(new Cell(i,m-1,heights[i][m-1]));
	        visit[i][0] = 1;
	        visit[i][m-1] = 1;
	      }
	      for(int i = 0; i < m; i++) {
	        q.offer(new Cell(0,i,heights[0][i]));

	        q.offer(new Cell(n-1,i,heights[n-1][i]));
	        visit[0][i] = 1;
	        visit[n-1][i] = 1;

	      }
	      int ans = 0 ;
	      while(!q.isEmpty()) {
	        
	        Cell now = q.poll();
	        
	        for(int i = 0; i < 4; i++) {
	          
	          int nx = now.x + dx[i];
	          int ny = now.y + dy[i];
	          if(0<=nx && nx < n && 0 <= ny && ny < m && visit[nx][ny] == 0) {
	            visit[nx][ny] = 1;
	            q.offer(new Cell(nx,ny,Math.max(now.h,heights[nx][ny])));
	            ans = ans + Math.max(0,now.h - heights[nx][ny]);
	          }
	          
	        }
	      }
	      return ans;
	    } 
	}