package Ladder7.FollowUp;
/**
 * 
 * 553. Bomb Enemy 

Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' 
(the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall 
since the wall is too strong to be destroyed.

 Notice
You can only put the bomb at an empty cell.

Example
Given a grid:

0 E 0 0
E 0 W E
0 E 0 0
return 3. (Placing a bomb at (1,1) kills 3 enemies)

Tags:Dynamic Programming Google
 * */

public class BombEnemy {
	/**
     * @param grid Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid){
        int row = grid.length;
        int col = row>0?grid[0].length:0;
        
        int res=0;
        int row1[] = new int [row];
        int col1[] = new int [col];
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                //iterate each row
                //if last row is wall, then found sum of enemy from crt to next wall/the end of col
                if(i==0||grid[i-1][j]=='W'){
                    col1[j]=0;
                    for(int k=i; k<row&&grid[k][j]!='W'; k++){
                        if(grid[k][j]=='E'){
                            col1[j]+=1;
                        }
                    }
                }
                //in crt row,if lasts col is wall, then find the sum of enemy from crt to the next wall/the end of the row
                if(j==0||grid[i][j-1]=='W'){
                    row1[i]=0;
                    for(int k=j; k<col&&grid[i][k]!='W'; k++){
                        if(grid[i][k]=='E'){
                            row1[i]+=1;
                        }
                    }
                }
                if (grid[i][j]=='0'){
                    res = Math.max(res, col1[j]+row1[i]);
                }
               
            }
        }
           return res;
    }

}
