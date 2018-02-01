package DataStructureI;
/**
 * 
 * 473. Add and Search Word - Medium - required

Design a data structure that supports the following two operations: addWord(word) and search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or ..
A . means it can represent any one letter.
Notice: You may assume that all words are consist of lowercase letters a-z.

Example
addWord("bad")
addWord("dad")
addWord("mad")
search("pad")  // return false
search("bad")  // return true
search(".ad")  // return true
search("b..")  // return true

Tags: Trie

Related Problems 
1-Hard K Edit Distance 27 %
2-Medium Implement Trie 32 %
 * */
public class SearchWord {
    class TrieNode {
	    // Initialize your data structure here.
	    public HashMap<Character, TrieNode> children;
			public boolean hasWord;
			// Initialize your data structure here.
			public TrieNode() {
				children= new HashMap<Character, TrieNode>();
				hasWord=false;
			}
	}
   private TrieNode root;
	public SearchWord(){
		root= new TrieNode();
		
	}
   // Adds a word into the data structure.
   public void addWord(String word) {
   	TrieNode node = root;
       for(int i=0; i<word.length();i++){
       	char c = word.charAt(i);
       	if(!node.children.containsKey(word.charAt(i))){
       		node.children.put(c, new TrieNode());
       	}
       	node=node.children.get(c);
       	
       }
       node.hasWord=true;
   }

   // Returns if the word is in the data structure. A word could
   // contain the dot character '.' to represent any one letter.
   public boolean search(String word) {
		return find(word, 0, root);
	}
	private boolean find(String word, int i, TrieNode node ) {
		if(i>word.length()-1){
			return false;
		}
		else
		{
			char c = word.charAt(i);
			if(i== word.length()-1 &&node.children.containsKey(c) ){
			    if( node.children.get(c).hasWord){
			        return true;
			    }else {
			       return false;
			    }
				
			}else if(node.children.containsKey(c)){
				return find(word, i+1, node.children.get(c));
			}
			else if(c=='.'){
				for (Map.Entry<Character, TrieNode> entry: node.children.entrySet()){
					if(i== word.length()-1 && entry.getValue().hasWord){
						return true;
					}
					if(find(word, i+1, entry.getValue())){
						return true;
					}

				}
				return false;
			} 
			return false;
			
		}
	}
}

//Your WordDictionary object will be instantiated and called as such:
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("word");
//wordDictionary.search("pattern");
