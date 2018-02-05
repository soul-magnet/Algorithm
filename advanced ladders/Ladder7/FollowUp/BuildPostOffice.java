package Ladder7.FollowUp;

import java.util.ArrayList;

/**
 * 574. Build Post Office - Hard -Optional

Given a 2D grid, each cell is either an house 1 or empty 0 (the number zero, one), 
find the place to build a post office, the distance that post office to all the house sum is smallest. 
Return the smallest distance. Return -1 if it is not possible.

 Notice
You can pass through house and empty.
You only build post office on an empty.

Example
Given a grid:

0 1 0 0
1 0 1 1
0 1 0 0
return 6. (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)

Tags 
Sort Binary Search
Related Problems 
Medium Nearest Exit 31 %
Hard Build Post Office II 27 %
 * */
public class BuildPostOffice {
	
	class Node {
        int x, y ;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

     /**
     * @param grid a 2D grid
     * @return an integer
     */
     //Solution 1: Find the median by Using Manhattan Distance
     public int shortestDistance(int[][] grid){
         int row = grid.length, column = grid[0].length;
         
         //corner cases
         if(row == 0 || column == 0 || !haveZero(grid, row, column)) return -1;
         
         int[] rowSum = new int[row];
         int[] colSum = new int[column];
         
         //find the houses in the grid
         for(int i = 0; i < row; i++)
             for(int j = 0; j < column; j++)
                 if(grid[i][j] == 1){
                    rowSum[i]++;
                    colSum[j]++;
                 }
            
        //sum of the houses to the ith row denoted as ansRow[i]
        //sum of the houese to the jth column denoted as ansColumn[j]
        int[] ansRow = new int[row];
        int[] ansColumn = new int[column];
        getSumDistance(rowSum, row, ansRow);
        getSumDistance(colSum, column, ansColumn);
        
        int ans = Integer.MAX_VALUE;
        for(int i=0; i < row; i++)
            for(int j = 0; j < column; j++)
                if(grid[i][j] == 0 && ans > ansRow[i] + ansColumn[j])
                    ans = ansRow[i] + ansColumn[j];
        
        return ans;
     }
     
     //check if there is a place to build office
     //otherwise everywhere is occupied by 1s as houses
     boolean haveZero(int[][] grid, int row, int column){
         for(int i = 0; i < row; i++){
             for(int j = 0; j < column; j++){
                 if(grid[i][j] == 0)
                    return true;
             }
         }
         return false;
     }
     
     //fnd prefixSum
     void getSumDistance(int[] a, int n, int[] ans){
         int[] prefixSum1 = new int[n]; //preifxSum[i]=a[0]+a[1]+a[2]+...+a[i]
         int[] prefixSum2 = new int[n];
         
         //1st stage
         prefixSum1[0] = a[0];
     }
     
    //too slow 
    public int shortestDistance(int[][] grid) {
        ArrayList<Integer> y = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> sumx = new ArrayList<>();
        ArrayList<Integer> sumy = new ArrayList<>();

        for(int i=0; i<grid.length; i ++){
            for(int j=0; j< grid[0].length;j++){
                if(grid[i][j]==1){
                    x.add(i);
                    y.add(j);
                }
            }
        }
        Collections.sort(x);
        Collections.sort(y);
        sumx.add(x.get(0));
        sumy.add(y.get(0));
        for(int i=1; i< x.size();i++){
            sumx.add(x.get(i)+sumx.get(i-1));
            sumy.add(y.get(i)+sumy.get(i-1));
        }
        int res = Integer.MAX_VALUE;
        for(int i=0; i<grid.length; i ++){
            for(int j=0; j< grid[0].length;j++){
                if(grid[i][j]==0){
                    int distanceX = distance(i,x,sumx);
            int distanceY = distance(j,y,sumy);
            res = Math.min(res, distanceX+distanceY);
                }
            }
        }
           
       

        return res;
    }

    private int distance(int crt, ArrayList<Integer> x, ArrayList<Integer> sumx) {
        int l=0, r= x.size()-1;
        while (l+1<r){
            int mid = l + (r-l)/2;
            if(x.get(mid)<=crt){
                l= mid;
            }else{
                r= mid;
            }
        }
        int index =0;
        if ( x.get(r)< crt){
             index =r;
        }else{
            index= l;
        }
        int last = sumx.size()-1;
        int after= (sumx.get(last)- sumx.get(index))- crt * (last-index);
        int front= crt*(index+1)-sumx.get(index);
        return after+ front;

    }

}
