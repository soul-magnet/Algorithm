package Ladder3.DataStructure_II;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 364. Trapping Rain Water II - Hard - Required

Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1, compute how much water it is able to trap after raining.

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
