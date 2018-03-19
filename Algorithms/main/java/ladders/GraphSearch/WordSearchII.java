package GraphSearch;

import java.util.ArrayList;

/*
 * Given a matrix of lower alphabets and a dictionary. 
 * Find all words in the dictionary that can be found in the matrix. 
 * A word can start from any position in the matrix and go left/right/up/down 
 * to the adjacent position. 
 * Example
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

Challenge
Using trie to implement your algorithm.

Reference about trie structure: 
http://www.toptal.com/java/the-trie-a-neglected-data-structure

Analysis: 
The benefit of the trie is the O(k) searching time for a string with length k.
The con is that it takes more space and needs some time for setting up the trie tree
from the dictionart 
Solutoin is from http://www.jiuzhang.com/solutions/word-search-ii/
*/
public class WordSearchII {
	/**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
	

}
