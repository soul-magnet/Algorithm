package Ladder2.DataStructure_I;
/**
132. Word Search II - Hard -Required

Given a matrix of lower alphabets and a dictionary. 
Find all words in the dictionary that can be found in the matrix.
A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 

Example
Given matrix:

doaf
agai
dcan
and dictionary:

{"dog", "dad", "dgdg", "can", "again"}

return {"dog", "dad", "can", "again"}


dog:
doaf
agai
dcan
dad:

doaf
agai
dcan
can:

doaf
agai
dcan
again:

doaf
agai
dcan

Challenge: Using trie to implement your algorithm.

Tags 
1- LintCode Copyright Trie Airbnb
2- Related Problems 
3- Hard Boggle Game 18 %
*
*/
public class WordSearch2 {
   	class TrieNode {
		// Initialize your data structure here.
		public char c;
		public String word;
		public HashMap<Character, TrieNode> hm;
		public TrieNode() {
			hm = new HashMap<>();
		}
		public TrieNode(char c) {
			hm = new HashMap<>();
			this.c = c;
		}
	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			TrieNode root = this.root;
			for(char i: word.toCharArray()){
				if(!root.hm.containsKey(i)){
					TrieNode now = new TrieNode(i);
					root.hm.put(i, now);
				}
				root = root.hm.get(i);
			}
			root.word = word;
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode root = this.root;
			for( char i : word.toCharArray()){
				if(root.hm.containsKey(i)){
					root = root.hm.get(i);
				}
				else{
					return false;
				}
			}
			return root.word==word;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			TrieNode root = this.root;
			for( char i : prefix.toCharArray()){
				if(root.hm.containsKey(i)){
					root = root.hm.get(i);
				}
				else{
					return false;
				}
			}
			return true;
		}
	}
	/**
	 * @param board: A list of lists of character
	 * @param words: A list of string
	 * @return: A list of string
	 */
	public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
		Trie trie = new Trie();
		for (String word: words){
		    trie.insert(word);
        }
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i< board.length;i++){
            for(int j= 0; j< board[0].length;j++){
                search(trie.root, res, i, j, board);
            }
        }
       return res;
	}

    private void search(TrieNode root, ArrayList<String> res, int i, int j, char[][] board) {
        int [] [] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        if(root.hm.containsKey(board[i][j])){
            TrieNode crt = root.hm.get(board[i][j]);
            if(crt.word != null&& !res.contains(crt.word)){
                res.add(crt.word);
            }
            char temp = board[i][j];
            board[i][j]=0;
            for(int[] now: directions){
                int x = i+now[0];
                int y = j+now[1];
                if(x>-1&&y>-1&&x<board.length&&y<board[0].length&& board[x][y]!=0){
                    search(crt, res, x,y,board);
                }
            }
            board[i][j]=temp;
        }
    }
}