package DataStructureI;
/**
 * 477. Surrounded Regions - Medium - Optional
 * 
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
Tags: Union Find Breadth First Search

Related Problems 
Medium Nearest Exit 31 %
Medium Connecting Graph 39 %
Hard Number of Islands II 19 %
Easy Number of Islands 25 %*/

public class SurroundedRegions {
	public void surroundedRegions(char[][] board) {
        if(board ==null || board.length<2||board[0].length<2){
            return;
        }
        for(int i= 0 ; i< board[0].length;i++){
            dfs(board,0, i);
            dfs(board,board.length-1, i);
        }
        for(int i= 0 ; i< board.length;i++){
            dfs(board,i, 0);
            dfs(board, i, board[0].length-1);
        }
         for(int i= 0 ; i< board.length;i++){
            for(int j= 0; j<board[0].length; j++){
                if (board[i][j] =='B'){
                    board[i][j]='O';
                    
                }else if(board[i][j] =='O'){
                    board[i][j]='X';
                  
                }
            }
        }
    }
    static int directions[][] = {{0,1},{1,0},{-1,0}, {0,-1}};
    private void dfs(char[][] board, int x, int y) {
        if(board[x][y]=='O'){
            board[x][y] = 'B';
            for(int i[] : directions){
                int new_x= x+ i[0];
                int new_y = y+ i[1];
                if(new_x<board.length&&new_x>-1&&new_y>-1&&new_y<board[0].length&&board[new_x][new_y]=='O'){
                    dfs(board,new_x,new_y);
                }
            }
        }
    }

}
