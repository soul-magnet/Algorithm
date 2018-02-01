package DataStructureI;
/**
 * 123. Word Search - Required
 
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example
Given board =

[
  "ABCE",
  "SFCS",
  "ADEE"
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

Tags: Backtracking Facebook

*/

public class WordSearch {
	/**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] b, String k) {
		if ( b==null||b.length==0){
			return false;
		}
		if(k.length()==0){
			return true;
		}
		for(int i=0; i< b.length;i++){
			for(int j=0;j< b[0].length;j++){
				if( find ( b, k, i,j,0)){
					return true;
				}
			}
		}
		return false;
	}

	private boolean find(char[][] b, String k, int i, int j, int pos) {
		if (pos==k.length()){
			return true;
		}
		if( i<0||i>=b.length||j<0||j>=b[0].length||b[i][j]!=k.charAt(pos)){
			return false;
		}
		char temp = k.charAt(pos);
		b[i][j]= '#'; // prevent using it back and force : koko, search koko not ko 2 times
		boolean res= (find(b,k,i-1,j,pos+1)||find(b,k,i+1,j,pos+1)||find(b,k,i,j+1,pos+1)||find(b,k,i,j-1,pos+1));
		b[i][j]= temp;
		return res;
	}

}
